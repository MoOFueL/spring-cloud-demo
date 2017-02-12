package ru.atc.cloud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Дмитрий on 08.02.2017.
 */
@RestController
public class PrincipalRestController {


    @GetMapping("/user")
    Principal principal(Principal principal) {
        return principal;
    }
}
