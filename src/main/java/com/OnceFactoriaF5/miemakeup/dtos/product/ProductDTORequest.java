package com.OnceFactoriaF5.miemakeup.dtos.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

public record ProductDTORequest(
        @NotBlank(message = "Product name is required")
        @Size(min = 1, max = 20, message = "Product name must be at least 1 characters and max 20 characters.")
        String name,
        @NotNull
        @Positive(message = "The product price must be a positive number")
        double price,
        @URL
        String imageUrl,
        @NotNull
        boolean featured,
        @NotBlank(message = "Product description is required")
        @Size(min = 10, max = 200, message = "Product description must be at least 10 characters and max 200 characters.")
        String description,
        @NotBlank(message = "Product ingredients are required")
        @Size(min = 50, max = 500, message = "Product ingredients must be at least 50 characters and max 500 characters.")
        String ingredients) {
}
