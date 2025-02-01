package com.OnceFactoriaF5.miemakeup.dtos.product;

public record ProductDTOResponse(
        String name,
        double price,
        String imageUrl,
        boolean featured
) {
}
