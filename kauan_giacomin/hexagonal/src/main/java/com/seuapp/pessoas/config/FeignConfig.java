package kauan_giacomin.hexagonal.src.main.java.com.seuapp.pessoas.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.seuapp.pessoas.adapters.out.viacep")
public class FeignConfig { }