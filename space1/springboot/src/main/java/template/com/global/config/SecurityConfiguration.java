package template.com.global.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.SecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.WebInvocationPrivilegeEvaluator;

import javax.servlet.Filter;
import java.util.List;

/**
 * @author HUGH
 * @Date 2019/1/7 21:37
 * @Description SecurityConfiguration
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfiguration {

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;
    @Autowired
//    private CustAuthenticationProvider authenticationProvider;
    public SecurityConfiguration() {
        super();
    }

    @Override
    public SecurityExpressionHandler<FilterInvocation> webSecurityExpressionHandler() {
        return super.webSecurityExpressionHandler();
    }

    /**
     * Creates the Spring Security Filter Chain
     *
     * @return the {@link Filter} that represents the security filter chain
     * @throws Exception
     */
    @Override
    public Filter springSecurityFilterChain() throws Exception {
        return super.springSecurityFilterChain();
    }

    /**
     * Creates the {@link WebInvocationPrivilegeEvaluator} that is necessary for the JSP
     * tag support.
     *
     * @return the {@link WebInvocationPrivilegeEvaluator}
     * @throws Exception
     */
    @Override
    public WebInvocationPrivilegeEvaluator privilegeEvaluator() throws Exception {
        return super.privilegeEvaluator();
    }

    /**
     * Sets the {@code <SecurityConfigurer<FilterChainProxy, WebSecurityBuilder>}
     * instances used to create the web configuration.
     *
     * @param objectPostProcessor    the {@link ObjectPostProcessor} used to create a
     *                               {@link WebSecurity} instance
     * @param webSecurityConfigurers the
     *                               {@code <SecurityConfigurer<FilterChainProxy, WebSecurityBuilder>} instances used to
     *                               create the web configuration
     * @throws Exception
     */
    @Override
    public void setFilterChainProxySecurityConfigurer(ObjectPostProcessor<Object> objectPostProcessor, List<SecurityConfigurer<Filter, WebSecurity>> webSecurityConfigurers) throws Exception {
        super.setFilterChainProxySecurityConfigurer(objectPostProcessor, webSecurityConfigurers);
    }

    @Override
    public void setImportMetadata(AnnotationMetadata importMetadata) {
        super.setImportMetadata(importMetadata);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        super.setBeanClassLoader(classLoader);
    }
}
