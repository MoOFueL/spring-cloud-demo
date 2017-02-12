package ru.atc.controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.atc.domain.OldUral;
import ru.atc.feign.PashaServiceFeignClient;
import ru.atc.messaging.OldUralsWriter;

import java.util.Collections;
import java.util.List;

/**
 * Created by Дмитрий on 11.02.2017.
 */
@RestController
@RequestMapping("/")
public class DashaController {

    private PashaServiceFeignClient pashaServiceFeignClient;
    private OldUralsWriter oldUralsWriter;

    @Autowired
    public DashaController(PashaServiceFeignClient pashaServiceFeignClient,
                           OldUralsWriter oldUralsWriter) {
        this.pashaServiceFeignClient = pashaServiceFeignClient;
        this.oldUralsWriter = oldUralsWriter;
    }

    @HystrixCommand(fallbackMethod = "getOldUralsFromPashaFallback")
    @GetMapping("/getUrals")
    public List<OldUral> getOldUralsFromPasha() {
        return this.pashaServiceFeignClient.getAllUralsFromPasha();
    }

    @HystrixCommand(fallbackMethod = "getPashaNodeProfileFallback")
    @GetMapping("/getProfile")
    public String getPashaNodeProfile() {
        return this.pashaServiceFeignClient.getPashaNodeProfile();
    }

    @PostMapping("/addNewUralToOldUrals")
    public void writeToPasha(@RequestBody OldUral oldUral) {
        this.oldUralsWriter.write(oldUral);
    }

    public List<OldUral> getOldUralsFromPashaFallback() {
        return Collections.emptyList();
    }

    public String getPashaNodeProfileFallback() {
        return "";
    }
}
