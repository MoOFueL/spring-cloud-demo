package ru.atc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Дмитрий on 09.02.2017.
 */
@RefreshScope
@RestController
public class OldUralsController {

    private Environment environment;

    private OldUralsRepository oldUralsRepository;

    @Autowired
    public OldUralsController(OldUralsRepository oldUralsRepository, Environment environment) {
        this.oldUralsRepository = oldUralsRepository;
        this.environment = environment;
    }

    @Value("${message}")
    private String messageFromUral;

    @GetMapping("/findall")
    public List<OldUral> findAll() {
        return oldUralsRepository.findAll();
    }

    @GetMapping("/profile")
    public List<String> findActiveProfiles() {
        return Arrays.asList(environment.getActiveProfiles());
    }

    @GetMapping("message")
    public String sayHello() {
        return messageFromUral;
    }
}
