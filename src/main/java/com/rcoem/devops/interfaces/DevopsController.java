package com.rcoem.devops.interfaces;

import com.rcoem.devops.application.DevopsService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    DevopsService devopsService;

    @GetMapping("/health")
    public ResponseEntity<String> getHealth(){
        return ResponseEntity.ok("Online");
    }

    @GetMapping("/env-path")
    public String getPath() {
        return  devopsService.getPath();
    }


}
