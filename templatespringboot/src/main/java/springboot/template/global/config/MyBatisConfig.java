//package springboot.template.global.config;
//
////import org.mybatis.spring.mapper.MapperScannerConfigurer;
//
//
//import org.mybatis.spring.mapper.MapperScannerConfigurer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * 废弃
// *
// * @Auther HUGH
// * @Date 2018/6/9
// * @Description MyBatisConfig
// * 此方法配置entity dao xml 失败，无法与mysql连接,改为在启动类配置，错误如下
// * <p>
// * nested exception is org.apache.ibatis.exceptions.PersistenceException:
// * ### Error querying database.  Cause: org.springframework.jdbc.CannotGetJdbcConnectionException:
// * Failed to obtain JDBC Connection; nested exception is java.sql.SQLException: Access denied for
// * user ''@'localhost' (using password: YES)
// * ### The error may exist in file [D:\IdeaProjects\IdeaProjects\templatespringboot\target\classes
// * \mapper\springboot\template\UserInfoMapper.xml]
// * ### The error may involve springboot.template.mvc.mapper.UserInfoMapper.selectByPrimaryKey
// * ### The error occurred while executing a query
// * ### Cause: org.springframework.jdbc.CannotGetJdbcConnectionException: Failed to obtain JDBC
// * Connection; nested exception is java.sql.SQLException: Access denied for user ''@'localhost'
// * (using password: YES)] with root cause
// */
//@Configuration
//public class MyBatisConfig {
////    //    @Bean
////    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
////        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
////        factoryBean.setDataSource(dataSource);
//////        设置entity目录
////        factoryBean.setTypeAliasesPackage("springboot.**.entity");
//////        设置xml目录
////        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
////        factoryBean.setMapperLocations(resolver.getResources("classpath:mapper/**/*.xml"));
////        return factoryBean.getObject();
////    }
//
//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer() {
//        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
//        scannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
//        scannerConfigurer.setBasePackage("springboot.template.mvc.mapper");
//        return scannerConfigurer;
//    }
//}
