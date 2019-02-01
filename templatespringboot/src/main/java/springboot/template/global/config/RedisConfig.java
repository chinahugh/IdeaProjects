/*
package springboot.template.global.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

*/
/**
 * @Auther HUGH
 * @Date 2018/6/10
 * @Description RedisConfig  redis配置
 *//*

@Configuration
@EnableCaching   //开启缓存
public class RedisConfig extends CachingConfigurerSupport {
    private final static Logger LOGGER = LoggerFactory.getLogger(RedisConfig.class);
    @Bean
    @ConfigurationProperties(prefix = "spring.rides")
    public JedisPoolConfig jedisPoolConfig() {
        return new JedisPoolConfig();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.redis")
    public JedisConnectionFactory getConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        JedisPoolConfig config = jedisPoolConfig();
        factory.setPoolConfig(config);
        return factory;
    }

    @Bean
    public RedisTemplate<?, ?> getRedisTemplate() {
        return new StringRedisTemplate(getConnectionFactory());
    }
}
*/
