package com.OnceFactoriaF5.miemakeup.dtos.category;

import com.OnceFactoriaF5.miemakeup.models.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public record CategoryDTOResponse(
        int id,
        String name,
        List<Product> products
) {
}
