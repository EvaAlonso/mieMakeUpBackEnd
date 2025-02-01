package com.OnceFactoriaF5.miemakeup.services;

import com.OnceFactoriaF5.miemakeup.dtos.consumer.ConsumerDTORequest;
import com.OnceFactoriaF5.miemakeup.dtos.consumer.ConsumerDTOResponse;
import com.OnceFactoriaF5.miemakeup.dtos.consumer.ConsumerMapper;
import com.OnceFactoriaF5.miemakeup.exceptions.EmptyException;
import com.OnceFactoriaF5.miemakeup.exceptions.UnauthorizedException;
import com.OnceFactoriaF5.miemakeup.models.Consumer;
import com.OnceFactoriaF5.miemakeup.repositories.ConsumerRepository;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class ConsumerService {
    private final ConsumerRepository consumerRepository;
    //private final BCryptPasswordEncoder passwordEncoder;

    public ConsumerService(ConsumerRepository consumerRepository /*BCryptPasswordEncoder passwordEncoder*/) {
        this.consumerRepository = consumerRepository;
        //this.passwordEncoder = passwordEncoder;
    }

   /* private boolean isPasswordValid(String password) {
        String regex = "(?=.*[A-Z])(?=.*\\d).{8,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }*/

//    public String encodePassword(String password) {
//        return passwordEncoder.encode(password);
//    }

   /* public ConsumerDTOResponse authenticateAdmin(String name, String password) {
        List<String> allowedAdmins = List.of("admin1", "admin2");

        if (!isPasswordValid(password)) {
            throw new UnauthorizedException("Password does not meet the required criteria.");
        }

        if (!allowedAdmins.contains(name)) {
            throw new UnauthorizedException("Admin access not allowed.");
        }
        Optional<Consumer> consumerOptional = consumerRepository.findByName(name);
        if (consumerOptional.isPresent()) {
            Consumer consumer = consumerOptional.get();
            if (passwordEncoder.matches(password, consumer.getPassword()) && consumer.getRole() == Consumer.Role.ADMIN) {
                return new ConsumerDTOResponse(consumer.getId(), consumer.getName(), consumer.getRole().name());
            }
            throw new UnauthorizedException("Invalid password or not an admin.");
        }
        throw new UnauthorizedException("Consumer not found");
    }*/

    public ConsumerDTOResponse saveConsumer(ConsumerDTORequest consumerDTORequest) {
        /*if (!isPasswordValid(consumerDTORequest.password())) {
            throw new UnauthorizedException("Password does not meet the required criteria.");
        }*/

        Consumer consumer = ConsumerMapper.INSTANCE.consumerDTORequestToConsumer(consumerDTORequest);
        consumer.setPassword(/*encodePassword*/(consumerDTORequest.password()));
        Consumer savedConsumer = consumerRepository.save(consumer);
        return ConsumerMapper.INSTANCE.consumerToConsumerDTOResponse(savedConsumer);
    }
    public List<ConsumerDTOResponse> getConsumers() {
        List<Consumer> consumers = consumerRepository.findAll();
        return consumers.stream()
                .map(ConsumerMapper.INSTANCE::consumerToConsumerDTOResponse)
                .collect(Collectors.toList());
    }
    public ConsumerDTOResponse getConsumerById(int id) {
        Consumer consumer = consumerRepository.findById(id)
                .orElseThrow(() -> new EmptyException("Consumer not found with id " + id));
        return ConsumerMapper.INSTANCE.consumerToConsumerDTOResponse(consumer);
    }
    public ConsumerDTOResponse updateConsumer(int id, ConsumerDTORequest consumerDTORequest) {
        Consumer existingConsumer = consumerRepository.findById(id)
                .orElseThrow(() -> new EmptyException("Consumer not found with id " + id));

        existingConsumer.setName(consumerDTORequest.name());
        existingConsumer.setRole(Consumer.Role.valueOf(consumerDTORequest.role()));

        if (!existingConsumer.getPassword().equals(consumerDTORequest.password())) {
            existingConsumer.setPassword(/*encodePassword*/(consumerDTORequest.password()));
        }

        Consumer updatedConsumer = consumerRepository.save(existingConsumer);
        return ConsumerMapper.INSTANCE.consumerToConsumerDTOResponse(updatedConsumer);
    }
    public void deleteConsumer(int id) {
        Consumer consumer = consumerRepository.findById(id)
                .orElseThrow(() -> new EmptyException("Consumer not found with id " + id));
        consumerRepository.delete(consumer);
    }

    public List<ConsumerDTOResponse> findConsumersByFilters(String name, String role) {
        List<Consumer> consumers;

        if (name != null && role != null) {
            Optional<Consumer> optionalConsumer = consumerRepository.findByNameAndRole(name, Consumer.Role.valueOf(role));
            consumers = optionalConsumer.map(Collections::singletonList).orElse(Collections.emptyList());
        } else if (name != null) {
            Optional<Consumer> optionalConsumer = consumerRepository.findByName(name);
            consumers = optionalConsumer.map(Collections::singletonList).orElse(Collections.emptyList());
        } else if (role != null) {
            Optional<Consumer> optionalConsumer = consumerRepository.findByRole(Consumer.Role.valueOf(role));
            consumers = optionalConsumer.map(Collections::singletonList).orElse(Collections.emptyList());
        } else {
            consumers = consumerRepository.findAll();
        }
        return consumers.stream()
                .map(consumer -> new ConsumerDTOResponse(consumer.getId(), consumer.getName(), consumer.getRole().name()))
                .collect(Collectors.toList());
    }
}