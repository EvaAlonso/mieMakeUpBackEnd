package com.OnceFactoriaF5.miemakeup.repositories;
import com.OnceFactoriaF5.miemakeup.models.Category;
import com.OnceFactoriaF5.miemakeup.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);
    List<Product> findByCategoryName(String categoryName);

    List<Product> findByCategory(Category category);

}
