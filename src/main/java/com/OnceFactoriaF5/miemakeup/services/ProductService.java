package com.OnceFactoriaF5.miemakeup.services;

import com.OnceFactoriaF5.miemakeup.dtos.product.ProductDTORequest;
import com.OnceFactoriaF5.miemakeup.dtos.product.ProductDTOResponse;
import com.OnceFactoriaF5.miemakeup.dtos.product.ProductMapper;
import com.OnceFactoriaF5.miemakeup.models.Product;
import com.OnceFactoriaF5.miemakeup.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTOResponse saveProduct(ProductDTORequest productDTORequest){
        Product newProduct = ProductMapper.dtoToEntity(productDTORequest);
        Product savedProduct = productRepository.save(newProduct);
        return ProductMapper.entityToDto(savedProduct);
    }
}
