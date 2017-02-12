package ru.atc.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.atc.domain.OldUral;

import java.util.List;

/**
 * Created by Дмитрий on 11.02.2017.
 */
@FeignClient(name = "pasha-service")
public interface PashaServiceFeignClient {

    @RequestMapping(value = "/profile", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String getPashaNodeProfile();

    @RequestMapping(value = "/findall", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    List<OldUral> getAllUralsFromPasha();
}
