package springboot.template.global.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springboot.template.global.shiro.CustomRealm;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Auther HUGH
 * @Date 2018/6/11
 * @Description ShiroConfig
 */
@Configuration
public class ShiroConfig {
    /**
     * 注入自定义的realm，告诉shiro如何获取用户信息来做登录或权限控制
     *
     * @return
     */
    @Bean
    public CustomRealm customRealm() {
        return new CustomRealm();
    }

    @Bean
    public static DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
//         setUsePrefix(false)用于解决一个奇怪的bug。在引入spring aop的情况下。
//         在@Controller注解的类的方法中加入@RequiresRole注解，会导致该方法无法映射请求，导致返回404。
//         加入这项配置能解决这个bug
        creator.setUsePrefix(true);
        return creator;
    }
    /**
     * 这里统一做鉴权，即判断哪些请求路径需要用户登录，哪些请求路径不需要用户登录
     *
     * @return
     */
   /* @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chain = new DefaultShiroFilterChainDefinition();
        //  chain.addPathDefinition("/userInfo/selectById", "authc, roles[admin]");
        chain.addPathDefinition("/login", "anon");
//        chain.addPathDefinition("/loginn", "anon");
        chain.addPathDefinition("/static/**", "anon");
//        chain.addPathDefinition("/userInfo/selectAll", "anon");
//        chain.addPathDefinition("/userInfo/login", "anon");
        chain.addPathDefinition("/**", "authc");
        return chain;
    }*/

    /**
     * SessionManager
     *
     * @return
     */
    @Bean("sessionManager")
    public SessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        //设置session过期时间为1小时(单位：毫秒)，默认为30分钟
        sessionManager.setGlobalSessionTimeout(60 * 60 * 1000);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        return sessionManager;
    }

    /**
     * 权限管理，配置主要是Realm的管理认证
     */
    @Bean("securityManager")
    public SecurityManager securityManager(SessionManager sessionManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(customRealm());
        securityManager.setSessionManager(sessionManager);
        return securityManager;
    }

    /**
     * Filter工厂，设置对应的过滤条件和跳转条件
     *
     * @param securityManager
     * @return
     */
    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
        shiroFilter.setLoginUrl("/");
        shiroFilter.setUnauthorizedUrl("/");
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/swagger/**", "anon");
        filterMap.put("/templates/a/**", "anon");
//        filterMap.put("/v2/api-docs", "anon");
        filterMap.put("/swagger-ui.html", "anon");
//        filterMap.put("/webjars/**", "anon");
        filterMap.put("/swagger-resources/**", "anon");
        filterMap.put("/static/**", "anon");
        filterMap.put("/login", "anon");
        filterMap.put("/logout", "anon");
        filterMap.put("/favicon.ico", "anon");
//        filterMap.put("/captcha.jpg", "anon");
        filterMap.put("/**", "authc");
        shiroFilter.setFilterChainDefinitionMap(filterMap);
        return shiroFilter;
    }

    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    /**
     * 加入注解的使用，不加入这个注解不生效
     */
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
}
