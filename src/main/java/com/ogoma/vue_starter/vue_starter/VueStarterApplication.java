package com.ogoma.vue_starter.vue_starter;


import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJpaAuditing
public class VueStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(VueStarterApplication.class, args
        );
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    MinioClient minioClient(@Value("${minio.end_point}") String endPoint,
                            @Value("${minio.access_key}") String accessKey,
                            @Value("${minio.secret_key}") String secretKey) throws Exception {
        return new MinioClient(
                endPoint,
                accessKey,
                secretKey
        );
    }
}
