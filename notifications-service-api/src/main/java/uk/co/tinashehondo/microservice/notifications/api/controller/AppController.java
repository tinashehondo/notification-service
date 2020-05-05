
package uk.co.tinashehondo.microservice.notifications.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/")
public class AppController {
    @GetMapping("/hello")
    public ResponseEntity<String> hello(@RequestParam(required = false) final String name) {
        final String suffix = name == null ? "World" : name;
        final String response = "Hello " + suffix;
        return ResponseEntity.ok(response);
    }

}
