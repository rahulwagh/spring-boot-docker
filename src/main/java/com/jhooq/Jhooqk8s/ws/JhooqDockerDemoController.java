package com.jhooq.Jhooqk8s.ws;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class JhooqDockerDemoController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello - Jhooq-k8s";
    }

    @GetMapping("/callOtherApp")
    public String otherApp() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://localhost:9090/makeOtherAppCall";
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl, String.class);

        return response.getBody();
    }


}
