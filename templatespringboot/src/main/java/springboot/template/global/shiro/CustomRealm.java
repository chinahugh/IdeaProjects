/*
package springboot.template.global.shiro;

import org.apache.shiro.authc.AuthenticationException;

*/
/**
 * @Auther HUGH
 * @Date 2018/6/11
 * @Description CustomRealm  自定义如何查询用户信息，如何查询用户的角色和权限，如何校验密码等逻辑
 *//*


public class CustomRealm */
/*extends AuthorizingRealm *//*
{
*/
/*
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private UserRoleService userRoleService;
    @Resource
    private RoleDirectoryService roleDirectoryService;

    *//*
*/
/*
      告诉shiro如何根据获取到的用户信息中的密码和盐值来校验密码
     *//*
*/
/* {
        //设置用于匹配密码的 HashedCredentialsMatcher
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setStoredCredentialsHexEncoded(true);
        //加密次数
        matcher.setHashIterations(1024);
        this.setCredentialsMatcher(matcher);
    }

    *//*
*/
/**
     * 定义如何获取用户的角色和权限的逻辑，给shiro做权限判断
     *
     * @param principals
     * @return
     *//*
*/
/*
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        if (principals == null) {
            throw new AuthenticationException("PrincipalCollection method argument cannot be null");
        }
        UserInfo userInfo = (UserInfo) getAvailablePrincipal(principals);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(userInfo.getRoles());
        info.setStringPermissions(userInfo.getDirectorys());
        return info;
    }

    *//*
*/
/**
     * 定义如何获取用户信息的业务逻辑，给shiro做登录
     *
     * @param token
     * @return
     * @throws AuthenticationException
     *//*
*/
/*
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        if (StringUtils.isEmpty(username)) {
            throw new AccountException("Null usernames are not allowed by this realm");
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(username);
        UserInfo oneUser = userInfoService.findOneUser(userInfo);
        if (oneUser == null) {
            throw new UnknownAccountException("No account found for admin [" + username + "]");
        }
        //查询用户的角色和权限存到SimpleAuthenticationInfo中，这样在其它地方
        //SecurityUtils.getSubject().getPrincipal()就能拿出用户的所有信息，包括角色和权限
        List<String> roleList = userRoleService.getUserRoles(oneUser.getId());
        List<String> permList = roleDirectoryService.getUserDirectorys(oneUser.getId());
        Set<String> roles = new HashSet(roleList);
        Set<String> perms = new HashSet(permList);
        oneUser.setRoles(roles);
        oneUser.setDirectorys(perms);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(oneUser, oneUser.getUserPassword(), getName());
        info.setCredentialsSalt(ByteSource.Util.bytes(oneUser.getSex()));
        return info;
    }*//*

}
*/
