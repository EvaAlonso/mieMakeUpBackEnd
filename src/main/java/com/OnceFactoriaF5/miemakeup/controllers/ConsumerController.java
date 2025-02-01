package com.OnceFactoriaF5.miemakeup.controllers;

import com.OnceFactoriaF5.miemakeup.dtos.consumer.ConsumerDTOResponse;
import com.OnceFactoriaF5.miemakeup.exceptions.ErrorResponse;
import com.OnceFactoriaF5.miemakeup.exceptions.UnauthorizedException;
import com.OnceFactoriaF5.miemakeup.services.ConsumerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/api/consumers")
public class ConsumerController {

    private final ConsumerService consumerService;

    public ConsumerController(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }
    @PostMapping("/authenticate")
    public ResponseEntity<ConsumerDTOResponse> authenticateAdmin(@RequestParam String name, @RequestParam String password){
            ConsumerDTOResponse authenticatedConsumer = consumerService.authenticateAdmin(name, password);
            return ResponseEntity.ok(authenticatedConsumer);

    }
    @GetMapping("/search")
    public ResponseEntity<List<ConsumerDTOResponse>> findConsumersByFilters(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String role) {

        List<ConsumerDTOResponse> consumers = consumerService.findConsumersByFilters(name, role);
        return ResponseEntity.ok(consumers);
    }
}
