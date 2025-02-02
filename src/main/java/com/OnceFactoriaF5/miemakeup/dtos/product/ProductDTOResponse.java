package com.OnceFactoriaF5.miemakeup.dtos.product;

public record ProductDTOResponse(
        int id,
        String name,
        double price,
        String imageUrl,
        boolean featured,
        String description,
        String ingredients,
        String categoryName
) {
}
