package com.OnceFactoriaF5.miemakeup.controllers;

import com.OnceFactoriaF5.miemakeup.dtos.product.DeleteProductDTOResponse;
import com.OnceFactoriaF5.miemakeup.dtos.product.ProductDTORequest;
import com.OnceFactoriaF5.miemakeup.dtos.product.ProductDTOResponse;
import com.OnceFactoriaF5.miemakeup.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductDTOResponse> saveProduct(@Valid @RequestBody ProductDTORequest productDTORequest){
        return new ResponseEntity<>(productService.saveProduct(productDTORequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTOResponse>> getProducts(){
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTOResponse> getProductById(@PathVariable int id){
        ProductDTOResponse productDTOResponse = productService.getProductById(id);
        return new ResponseEntity<>(productDTOResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTOResponse> updateProduct(@PathVariable int id, @Valid @RequestBody ProductDTORequest productDTORequest){
        ProductDTOResponse updatedProduct = productService.updateProduct(id, productDTORequest);
        return  new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteProductDTOResponse> deleteProduct(@PathVariable int id){
        DeleteProductDTOResponse response = productService.deleteProduct(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
