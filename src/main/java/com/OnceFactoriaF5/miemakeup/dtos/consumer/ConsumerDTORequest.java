package com.OnceFactoriaF5.miemakeup.dtos.consumer;

import jakarta.validation.constraints.Size;

public record ConsumerDTORequest(
        @Size(min = 1, max = 20, message = "Consumer name must be at least 1 characters and max 50 characters.")
        String name,
        String password,
        String role
) {
}
