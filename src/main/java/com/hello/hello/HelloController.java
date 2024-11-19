package com.hello.hello;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {


    @GetMapping(value = "/hi")
    public ResponseEntity<String> getHello() {
        return ResponseEntity.ok("""
                {
                    "message": "Hello!"
                }
                """);
    }

    @GetMapping(value = "/test")
    public ResponseEntity<String> getUser() {
        return ResponseEntity.ok("""
                {
                    "name": "test",
                    "id": 12456
                }
                """);
    }

    @GetMapping(value = "/api/user/{id}")
    public ResponseEntity<String> getUserById(@PathVariable String id) {
        return ResponseEntity.ok("""
                {
                    "name": "test",
                    "id": 1234
                }
                """);
    }
}
