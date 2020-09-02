package com.springboot.security.config;

//import com.springboot.security.MyUserDetailService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author HGH
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    RedisService redisService;
//    @Autowired
//    MyUserDetailService userDetailService;

    /**
     * 功能：配置用户名和密码
     * <p>
     * 内存用户存储
     * <p>
     * <p>
     * Spring Security的用户存储配置有多个方案可以选择，包括：
     * <p>
     * 内存用户存储
     * 数据库用户存储
     * LDAP用户存储
     * 自定义用户存储
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("h1").password(passwordEncoder().encode("1")).authorities("admin")
                .and()
                .withUser("h2").password(passwordEncoder().encode("1")).authorities("base");

    }

    /**
     * 密码加密
     *
     * @return
     */
    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .anyRequest().authenticated() //任何请求,登录后可以访问
//                .antMatchers("/base", "/index").hasRole("base")
//                .and()
//                .authorizeRequests().antMatchers("/hello").hasRole("admin")
//                .and().formLogin().permitAll(); //登录页面用户任意访问
//        http.authorizeRequests().anyRequest().authenticated();
        //配置登陆相关的操作从方法名可知，配置了登录页请求路径，密码属性名，用户名属性名，和登陆请求路径，permitAll()代表任意用户可访问
        http.formLogin();
                    //.loginPage("/index2")
//                .loginProcessingUrl("/logg")
//                .successForwardUrl("/base").usernameParameter("username").passwordParameter("password").permitAll();
        http.authorizeRequests()
                .antMatchers("/base/**", "/index/**").hasRole("base")
                .antMatchers("/hello/**").hasRole("admin")
                .antMatchers("/logg","/index2", "/error", "/favicon.ico").permitAll()
                 ; //登录页面用户任意访问


        // 关闭CSRF跨域
        http.csrf().disable();

//      加自定义过滤器
//        http.addFilterAt(getAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
////        配置鉴权失败的处理器
//        http.exceptionHandling().accessDeniedHandler(new MyAccessDeniedHandler());
//        http.addFilterAfter(new MyOncePerRequestFilter(), LogoutFilter.class);
    }

    /**
     * 配置静态资源的处理方式
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        // 设置拦截忽略文件夹，可以对静态资源放行
        web.ignoring().antMatchers("/**/**/*.html", "/**/**/*.js", "/**/**/*.css");

    }
//public MyUsernamePasswordAuthenticationFilter getAuthenticationFilter(){
//    MyUsernamePasswordAuthenticationFilter myUsernamePasswordAuthenticationFilte = new MyUsernamePasswordAuthenticationFilter();
//    myUsernamePasswordAuthenticationFilte.setAuthenticationFailureHandler(new MySimpleUrlAuthenticationFailureHandler());
//    myUsernamePasswordAuthenticationFilte.setAuthenticationSuccessHandler(new MySimpleUrlAuthenticationSuccessHandler());
//    myUsernamePasswordAuthenticationFilte.setFilterProcessesUrl("/sign_in");
//    myUsernamePasswordAuthenticationFilte.setAuthenticationManager(getAuthenticationManager());
//    return myUsernamePasswordAuthenticationFilte;
//}
//    MyAuthenticationProvider getMyAuthenticationProvider(){
//        MyAuthenticationProvider myAuthenticationProvider = new MyAuthenticationProvider(userDetailService,new BCryptPasswordEncoder());
//        return myAuthenticationProvider;
//    }
//    DaoAuthenticationProvider daoAuthenticationProvider(){
//        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
//        daoAuthenticationProvider.setUserDetailsService(userDetailService);
//        return daoAuthenticationProvider;
//    }
//    protected AuthenticationManager getAuthenticationManager()  {
//        ProviderManager authenticationManager = new ProviderManager(Arrays.asList(getMyAuthenticationProvider(),daoAuthenticationProvider()));
//        return authenticationManager;
//    }
//
//    public AccessDecisionManager accessDecisionManager(){
//        List<AccessDecisionVoter<? extends Object>> decisionVoters
//                = Arrays.asList(
//                new MyWebExpressionVoter(),
//                new WebExpressionVoter(),
//                new RoleVoter(),
//                new AuthenticatedVoter());
//        return new UnanimousBased(decisionVoters);
//
//    }
}
