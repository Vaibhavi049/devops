package com.rcoem.devops.interfaces;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/devops")
public class DevopsController {
    @Value("${source.path}")
    private String path;

    @Value("${environment}")
    private String env;

    @GetMapping("/health")
    public ResponseEntity<String> getHealth(){
        return ResponseEntity.ok("Online");
    }
    @GetMapping("/env-path")
    public String getPath() {
        if (env.equalsIgnoreCase("prod")) {
            return "invoked in prod";
        }
        return " invoked in " + env;
    }


}
