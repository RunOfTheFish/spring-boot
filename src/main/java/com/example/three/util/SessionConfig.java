package com.example.three.util;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by admin on 2017/8/10.
 */
@EnableRedisHttpSession(maxInactiveIntervalInSeconds= 1800)
public class SessionConfig {

	@Bean
	public JedisConnectionFactory connectionFactory() {
		JedisConnectionFactory connection = new JedisConnectionFactory();
		return connection;
	}
}
