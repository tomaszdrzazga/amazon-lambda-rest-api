package pl.com.britenet.lambda.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@RestController
@CrossOrigin
public class StatusController {

    public static String ALIVE = "ALIVE";

    @GetMapping(path = "/status")
    public String getStatus() {
        return ALIVE;
    }
}
