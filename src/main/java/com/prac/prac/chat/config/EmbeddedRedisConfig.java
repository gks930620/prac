package com.prac.prac.chat.config;
// import 생략...

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

/**
 * 로컬 환경일경우 내장 레디스가 실행됩니다.
 */
@Profile("local")   //모든곳에 적용되는것이 아니라   yml 파일중 spring-activate가 "local" 로 되어있는 설정파일을 따르겠다.
@Configuration  //springboot에서 redis 사용하기 위한 설정
public class EmbeddedRedisConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;


    @Bean  //여기서 연결한 redis에 데이터가 저장되있다는 소리인데..   확인을 못하겠네..
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory(host, port);
    }
}