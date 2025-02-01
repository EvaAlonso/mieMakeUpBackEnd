package com.OnceFactoriaF5.miemakeup.dtos.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryDTOResponse(
        int id,
        String name
) {
}
