package springboot.template.global.shiro;

import net.sf.json.JSONArray;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import springboot.template.global.exception.ServiceException;
import springboot.template.mvc.entity.SysPermission;
import springboot.template.mvc.entity.SysRole;
import springboot.template.mvc.entity.UserInfo;
import springboot.template.mvc.service.SysPermissionService;
import springboot.template.mvc.service.SysRoleService;
import springboot.template.mvc.service.UserInfoService;

import java.util.HashSet;
import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/6/11
 * @Description CustomRealm  自定义如何查询用户信息，如何查询用户的角色和权限，如何校验密码等逻辑
 */
public class CustomRealm extends AuthorizingRealm {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private SysRoleService userRoleService;
    @Autowired
    private SysPermissionService sysPermissionService;

   /*   告诉shiro如何根据获取到的用户信息中的密码和盐值来校验密码*/
    {
        //设置用于匹配密码的 HashedCredentialsMatcher
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setStoredCredentialsHexEncoded(true);
        //加密次数
        matcher.setHashIterations(1);
        this.setCredentialsMatcher(matcher);
      }

    /**
     * 定义如何获取用户的角色和权限的逻辑，给shiro做权限判断
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        if (principals == null) {
            throw new AuthenticationException("PrincipalCollection method argument cannot be null");
        }
        //获取用户角色 权限数据
        UserInfo userInfo = (UserInfo) getAvailablePrincipal(principals);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(userInfo.getRoles());
        info.setStringPermissions(userInfo.getPermissions());
        return info;
    }

    /**
     * 定义如何获取用户信息的业务逻辑，给shiro做登录
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        //获取用户名
        String username = usernamePasswordToken.getUsername();
        if (StringUtils.isEmpty(username)) {
            throw new AccountException("Null usernames are not allowed by this realm");
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(username);
        //通过用户名，查找密码
        UserInfo oneUser = userInfoService.select(userInfo);
        System.out.println("JSONArray.fromObject(oneUser) = " + JSONArray.fromObject(oneUser));
        if (oneUser == null) {
            throw new UnknownAccountException("No account found for admin [" + username + "]");
        }
        if (oneUser.getIsDisable()==2) {
            throw new ServiceException("账号还未通过审核,请联系管理员");
        }
        //查询用户的角色和权限存到SimpleAuthenticationInfo中，这样在其它地方
        //SecurityUtils.getSubject().getPrincipal()就能拿出用户的所有信息，包括角色和权限
        List<SysRole> roleList = userRoleService.getUserRoles(oneUser.getId());
        List<SysPermission> permList = sysPermissionService.getUserPermissions(oneUser.getId());
        HashSet<String> roles = new HashSet(roleList);
        HashSet<String> perms = new HashSet(permList);
        oneUser.setRoles(roles);
        oneUser.setPermissions(perms);

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(oneUser, oneUser.getUserPassword(), getName());
        /*密码盐*/
        String SALT = "!@#$%^&";
//        info.setCredentialsSalt(ByteSource.Util.bytes(SALT));
        return info;
    }
}
