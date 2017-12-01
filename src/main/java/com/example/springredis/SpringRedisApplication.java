package com.example.springredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import org.springframework.data.redis.serializer.StringRedisSerializer;




@SpringBootApplication
public class SpringRedisApplication {
	 @Bean
	    public JedisConnectionFactory jedisConnectionFactory() {
	        JedisConnectionFactory jd = new JedisConnectionFactory();
	        return jd;
	    }
	 @Bean
	    RedisTemplate<String, Employee> redisTemplate() {
	        final RedisTemplate<String, Employee> template =  new RedisTemplate<String, Employee>();
	        template.setConnectionFactory( jedisConnectionFactory() );
	        template.setKeySerializer( new StringRedisSerializer() );

	        return template;
	    }
	public static void main(String[] args) {
		SpringApplication.run(SpringRedisApplication.class, args);
	}
}
