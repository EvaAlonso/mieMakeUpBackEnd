package com.OnceFactoriaF5.miemakeup.dtos.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryDTORequest(
        @NotBlank(message = "Category is required")
        @Size(min = 3, max = 50, message = "Category description must be at least 3 characters and max 50 characters.")
        String name
) {
}
