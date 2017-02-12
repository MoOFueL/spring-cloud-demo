package ru.atc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@RefreshScope
@SpringBootApplication
@EnableEurekaClient
@EnableBinding(OldUralInputChannel.class)
public class PashaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PashaServiceApplication.class, args);
    }
}

@Component
class Populator implements CommandLineRunner {

    private OldUralsRepository oldUralsRepository;

    @Autowired
    public Populator(OldUralsRepository oldUralsRepository) {
        this.oldUralsRepository = oldUralsRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        oldUralsRepository.deleteAll();
        Stream.of("pavel,old", "pasha,new").map(tuple -> tuple.split(","))
                .forEach(pair -> oldUralsRepository.save(new OldUral(pair[0], pair[1])));
        oldUralsRepository.findAll().forEach(System.out::println);
        oldUralsRepository.findByName("pasha").forEach(System.out::println);
    }
}