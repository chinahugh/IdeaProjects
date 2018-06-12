package springboot.template.global.config;

import org.apache.shiro.aop.DefaultAnnotationResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springboot.template.global.shiro.CustomRealm;

/**
 * @Auther HUGH
 * @Date 2018/6/11
 * @Description ShiroConfig
 */
@Configuration
public class ShiroConfig {
    /**
     *  注入自定义的realm，告诉shiro如何获取用户信息来做登录或权限控制
     * @return
     */
    @Bean
    public CustomRealm customRealm() {
        return new CustomRealm();
    }
    @Bean
    public static DefaultAnnotationResolver defaultAnnotationResolver(){
    return null;
    }
}
