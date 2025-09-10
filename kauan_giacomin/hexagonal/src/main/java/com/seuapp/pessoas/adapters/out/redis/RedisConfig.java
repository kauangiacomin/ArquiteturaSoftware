package kauan_giacomin.hexagonal.src.main.java.com.seuapp.pessoas.adapters.out.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seuapp.pessoas.domain.model.Endereco;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.*;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.*;

@Configuration
public class RedisConfig {

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        // Ajuste host/port via application.yml
        return new LettuceConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, Endereco> redisTemplate(ObjectMapper om) {
        RedisTemplate<String, Endereco> t = new RedisTemplate<>();
        t.setConnectionFactory(redisConnectionFactory());
        t.setKeySerializer(new StringRedisSerializer());
        Jackson2JsonRedisSerializer<Endereco> valueSer =
                new Jackson2JsonRedisSerializer<>(Endereco.class);
        valueSer.setObjectMapper(om);
        t.setValueSerializer(valueSer);
        t.afterPropertiesSet();
        return t;
    }
}