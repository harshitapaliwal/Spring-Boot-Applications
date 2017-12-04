package com.cg.emp;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import com.cg.emp.model.Employee;

@SpringBootApplication	
@EnableCaching
public class DemoEmpApplication {
	 @Bean
	    public JedisConnectionFactory jedisConnectionFactory() {
	        JedisConnectionFactory jd = new JedisConnectionFactory();
	        return jd;
	    }
	 @Bean
	    RedisTemplate<String, Employee> redisTemplate( ) {
	        final RedisTemplate<String, Employee> template =  new RedisTemplate<String, Employee>();
	        template.setConnectionFactory( jedisConnectionFactory() );
	        template.setKeySerializer( new StringRedisSerializer() );

	        return template;
	    }

	 @Bean
	 public RedisCacheManager redisCachemanager(){
		  RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate());
		    cacheManager.setDefaultExpiration(300);
			return cacheManager;
	 }



	public static void main(String[] args) {
		SpringApplication.run(DemoEmpApplication.class, args);
	}

	
}
