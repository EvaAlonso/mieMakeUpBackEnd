package com.OnceFactoriaF5.miemakeup.dtos.product;

import com.OnceFactoriaF5.miemakeup.models.Product;

public class ProductMapper {
    public static Product dtoToEntity(ProductDTORequest productDTORequest){
        return new Product(
                productDTORequest.name(),
                productDTORequest.price(),
                productDTORequest.imageUrl(),
                productDTORequest.featured(),
                productDTORequest.description(),
                productDTORequest.ingredients()
        );
    }
    public static ProductDTOResponse entityToDto(Product product){
        return new ProductDTOResponse(
                product.getName(),
                product.getPrice(),
                product.getImageUrl(),
                product.isFeatured()
        );
    }
}
