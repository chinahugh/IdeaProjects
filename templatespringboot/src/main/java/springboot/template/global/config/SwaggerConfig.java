//package springboot.template.global.config;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.bind.annotation.RequestMapping;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
///**
// * @Auther HUGH
// * @Date 2018/6/9
// * @Description SwaggerConfig Swagger是一款通过我们添加的注解来对方法进行说明，
// * 来自动生成项目的在线api接口文档的web服务 https://swagger.io/
// */
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//    private final static Logger LOGGER = LoggerFactory.getLogger(SwaggerConfig.class);
//
//    @Bean
//    public Docket createRestApi() {
////        com.google.common.base.Predicate<RequestHandler> selector1 = RequestHandlerSelectors.basePackage("springboot.template.mvc.controller");
////        com.google.common.base.Predicate<RequestHandler> selector2 = RequestHandlerSelectors.basePackage("springboot.com.mvc.controller");
//
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.withClassAnnotation(RequestMapping.class))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder().title("Spring Boot中使用Swagger构建Rest Api")
//                .version("1.0").build();
//    }
//}
