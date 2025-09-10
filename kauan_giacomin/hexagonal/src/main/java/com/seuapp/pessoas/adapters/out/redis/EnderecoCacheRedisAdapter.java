package kauan_giacomin.hexagonal.src.main.java.com.seuapp.pessoas.adapters.out.redis;

import com.seuapp.pessoas.application.port.out.EnderecoCachePort;
import com.seuapp.pessoas.domain.model.Endereco;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Optional;

@Component
public class EnderecoCacheRedisAdapter implements EnderecoCachePort {

    private final RedisTemplate<String, Endereco> redis;
    private final Duration ttl;

    public EnderecoCacheRedisAdapter(RedisTemplate<String, Endereco> redis,
                                     @Value("${cache.endereco.ttl-seconds:86400}") long ttlSeconds) {
        this.redis = redis;
        this.ttl = Duration.ofSeconds(ttlSeconds);
    }

    private String key(String cep) { return "endereco:" + cep; }

    @Override
    public Optional<Endereco> get(String cep) {
        Endereco e = redis.opsForValue().get(key(cep));
        return Optional.ofNullable(e);
    }

    @Override
    public void put(String cep, Endereco endereco) {
        redis.opsForValue().set(key(cep), endereco, ttl);
    }
}
