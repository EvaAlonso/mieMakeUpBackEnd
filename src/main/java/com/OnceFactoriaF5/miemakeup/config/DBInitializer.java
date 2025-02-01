package com.OnceFactoriaF5.miemakeup.config;

import com.OnceFactoriaF5.miemakeup.models.Product;
import com.OnceFactoriaF5.miemakeup.repositories.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DBInitializer {
    private final ProductRepository productRepository;

    public DBInitializer(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void initializer(){
        initProducts();
    }

    public void initProducts(){
        LocalDateTime dateTime = LocalDateTime.parse("2025-01-02T08:38");

        Product product1 = new Product("Base", 10, "https://images.pexels.com/photos/1926620/pexels-photo-1926620.jpeg", true, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book", "It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");

        productRepository.save(product1);
    }
    //hacer lo mismo con category, clients etc
}
