package com.ogoma.hr_core;


import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import io.minio.MinioClient;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.ssl.SSLContexts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
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
    MinioClient minioClient(@Value("${minio.end.point}") String endPoint,
                            @Value("${minio.access.key}") String accessKey,
                            @Value("${minio.secret.key}") String secretKey) throws Exception {

        var client = MinioClient.builder()
                .credentials(accessKey, secretKey)
                .region("eu-frankfurt-1")
                .endpoint(endPoint).build();
        return client;


    }

    @Bean(name = "threadPoolTaskExecutor")
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setMaxPoolSize(100);
        executor.initialize();
        return executor;
    }

    @Bean
    AmazonS3 s3client (
            @Value("${minio.access.key}") String accessKey,
            @Value("${minio.secret.key}") String secretKey
    ) throws Exception {
        var cred = new BasicAWSCredentials(
                accessKey,
                secretKey
        );
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        SSLConnectionSocketFactory scsf =new  SSLConnectionSocketFactory(
                SSLContexts.custom().loadTrustMaterial(null, new TrustSelfSignedStrategy()).build(),
                NoopHostnameVerifier.INSTANCE);
        clientConfiguration.getApacheHttpClientConfig().setSslSocketFactory(scsf);
        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(cred))
                .withRegion("us-east-2")
                .withClientConfiguration(clientConfiguration)
                .build();
    }
    //this makes json serialization not to include lazy loaded objects
//    @Bean
//    public Hibernate5Module hibernate5Module() {
//        return new Hibernate5Module();
//    }
}
