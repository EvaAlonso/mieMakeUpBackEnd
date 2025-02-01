package com.OnceFactoriaF5.miemakeup.repositories;

import com.OnceFactoriaF5.miemakeup.models.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ConsumerRepository extends JpaRepository<Consumer, Integer> {
    Optional<Consumer> findByName(String name);
    Optional<Consumer>findByRole(Consumer.Role role);
    Optional<Consumer> findByNameAndRole(String name, Consumer.Role role);

}
