/*
package springboot.template.global.config;

import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import springboot.template.global.shiro.CustomRealm;

*/
/**
 * @Auther HUGH
 * @Date 2018/6/11
 * @Description ShiroConfig
 *//*

//@Configuration
public class ShiroConfig {
    */
/**
     *  注入自定义的realm，告诉shiro如何获取用户信息来做登录或权限控制
     * @return
     *//*

//    @Bean
    public CustomRealm customRealm() {
        return new CustomRealm();
    }
//    @Bean
    public static DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
*/
/*
         setUsePrefix(false)用于解决一个奇怪的bug。在引入spring aop的情况下。
         在@Controller注解的类的方法中加入@RequiresRole注解，会导致该方法无法映射请求，导致返回404。
         加入这项配置能解决这个bug
*//*

        creator.setUsePrefix(true);
        return creator;
    }
    */
/**
     * 这里统一做鉴权，即判断哪些请求路径需要用户登录，哪些请求路径不需要用户登录
     * @return
     *//*

//    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition(){
        DefaultShiroFilterChainDefinition chain = new DefaultShiroFilterChainDefinition();
       */
/* chain.addPathDefinition( "/userInfo/selectById", "authc, roles[admin]");
        chain.addPathDefinition( "/logout", "anon");
        chain.addPathDefinition( "/userInfo/selectAll", "anon");
        chain.addPathDefinition( "/userInfo/login", "anon");*//*

        chain.addPathDefinition( "/**", "authc");
        return chain;
    }
}
*/
