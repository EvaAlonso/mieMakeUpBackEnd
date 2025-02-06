package com.OnceFactoriaF5.miemakeup.services;

import com.OnceFactoriaF5.miemakeup.dtos.product.DeleteProductDTOResponse;
import com.OnceFactoriaF5.miemakeup.dtos.product.ProductDTORequest;
import com.OnceFactoriaF5.miemakeup.dtos.product.ProductDTOResponse;
import com.OnceFactoriaF5.miemakeup.dtos.product.ProductMapper;
import com.OnceFactoriaF5.miemakeup.exceptions.EmptyException;
import com.OnceFactoriaF5.miemakeup.models.Category;
import com.OnceFactoriaF5.miemakeup.models.Product;
import com.OnceFactoriaF5.miemakeup.repositories.CategoryRepository;
import com.OnceFactoriaF5.miemakeup.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public ProductDTOResponse saveProduct(ProductDTORequest productDTORequest){
        Product newProduct = ProductMapper.dtoToEntity(productDTORequest);
        Product savedProduct = productRepository.save(newProduct);
        return ProductMapper.entityToDto(savedProduct);
    }

    public List<ProductDTOResponse> getProducts(){
        List<Product> products = productRepository.findAll();
        if (products.isEmpty()) throw new EmptyException("Not found products");
        return products.stream().map(ProductMapper::entityToDto).toList();
    }

    public ProductDTOResponse getProductById(int id){
        Product product = productRepository.findById(id).orElseThrow(()->new EmptyException("Product not found with id " + id));
        return ProductMapper.entityToDto(product);
    }

    public ProductDTOResponse updateProduct(int id, ProductDTORequest productDTORequest){
        Product existingProduct = productRepository.findById(id).orElseThrow(()->new EmptyException("Product not found with id " + id));

        existingProduct.setName(productDTORequest.name());
        existingProduct.setPrice(productDTORequest.price());
        existingProduct.setImageUrl(productDTORequest.imageUrl());
        existingProduct.setFeatured(productDTORequest.featured());
        existingProduct.setDescription(productDTORequest.description());
        existingProduct.setIngredients(productDTORequest.ingredients());

        Product updatedProduct = productRepository.save(existingProduct);
        return ProductMapper.entityToDto(updatedProduct);
    }

    public DeleteProductDTOResponse deleteProduct (int id){
        Product existingProduct = productRepository.findById(id).orElseThrow(()-> new EmptyException("Product not found with id " + id));
        ProductDTOResponse productDTOResponse = ProductMapper.entityToDto(existingProduct);
        productRepository.delete(existingProduct);
        String message = "Product " + existingProduct.getName() + " has been successfully deleted.";
        return new DeleteProductDTOResponse(productDTOResponse, message);
    }
    public List<ProductDTOResponse> getProductsByCategory (String categoryName){
        Category category = categoryRepository.findByName(categoryName)
                .orElseThrow(() -> new EmptyException("Category not found"));

        List<Product> productsByCategory = productRepository.findByCategory(category);

        return productsByCategory.stream()
                .map(ProductMapper::entityToDto)
                .toList();
    }

    public List<ProductDTOResponse> getProductsByPriceRange(double minPrice, double maxPrice) {

        List<Product> productsByPrice = productRepository.findByPriceBetween(minPrice, maxPrice);
        return productsByPrice.stream()
                .map(ProductMapper::entityToDto).toList();
    }

}
