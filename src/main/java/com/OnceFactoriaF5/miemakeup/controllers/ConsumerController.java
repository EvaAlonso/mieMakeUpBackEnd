package com.OnceFactoriaF5.miemakeup.controllers;

import com.OnceFactoriaF5.miemakeup.dtos.consumer.ConsumerDTORequest;
import com.OnceFactoriaF5.miemakeup.dtos.consumer.ConsumerDTOResponse;
import com.OnceFactoriaF5.miemakeup.exceptions.ErrorResponse;
import com.OnceFactoriaF5.miemakeup.exceptions.UnauthorizedException;
import com.OnceFactoriaF5.miemakeup.services.ConsumerService;
import jakarta.validation.Valid;
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
    /*@PostMapping("/authenticate")
    public ResponseEntity<ConsumerDTOResponse> authenticateAdmin(@RequestParam String name, @RequestParam String password){
            ConsumerDTOResponse authenticatedConsumer = consumerService.authenticateAdmin(name, password);
            return ResponseEntity.ok(authenticatedConsumer);

    }*/
    @GetMapping("/search")
    public ResponseEntity<List<ConsumerDTOResponse>> findConsumersByFilters(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String role) {

        List<ConsumerDTOResponse> consumers = consumerService.findConsumersByFilters(name, role);
        return ResponseEntity.ok(consumers);
    }
    @GetMapping
    public ResponseEntity<List<ConsumerDTOResponse>> getConsumers() {
        List<ConsumerDTOResponse> consumers = consumerService.getConsumers();
        return ResponseEntity.ok(consumers);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ConsumerDTOResponse> getConsumerById(@PathVariable int id) {
        ConsumerDTOResponse consumerDTOResponse = consumerService.getConsumerById(id);
        return ResponseEntity.ok(consumerDTOResponse);
    }
    @PostMapping
    public ResponseEntity<ConsumerDTOResponse> saveConsumer(@Valid @RequestBody ConsumerDTORequest consumerDTORequest) {
        ConsumerDTOResponse savedConsumer = consumerService.saveConsumer(consumerDTORequest);
        return new ResponseEntity<>(savedConsumer, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ConsumerDTOResponse> updateConsumer(@PathVariable int id, @Valid @RequestBody ConsumerDTORequest consumerDTORequest) {
        ConsumerDTOResponse updatedConsumer = consumerService.updateConsumer(id, consumerDTORequest);
        return new ResponseEntity<>(consumerService.updateConsumer(id, consumerDTORequest), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsumer(@PathVariable int id) {
        consumerService.deleteConsumer(id);
        return ResponseEntity.noContent().build();
    }

}
