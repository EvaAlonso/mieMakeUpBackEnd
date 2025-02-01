package com.OnceFactoriaF5.miemakeup.controllers;

import com.OnceFactoriaF5.miemakeup.dtos.product.ProductDTORequest;
import com.OnceFactoriaF5.miemakeup.dtos.product.ProductDTOResponse;
import com.OnceFactoriaF5.miemakeup.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductDTOResponse> saveProduct(@Valid @RequestBody ProductDTORequest productDTORequest){
        return new ResponseEntity<>(productService.saveProduct(productDTORequest), HttpStatus.CREATED);
    }
}
