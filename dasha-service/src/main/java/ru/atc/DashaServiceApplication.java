package ru.atc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.IntegrationComponentScan;
import ru.atc.messaging.PashaChannel;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableFeignClients
@EnableBinding(PashaChannel.class)
@IntegrationComponentScan
public class DashaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DashaServiceApplication.class, args);
	}
}
