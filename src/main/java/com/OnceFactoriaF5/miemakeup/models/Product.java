package com.OnceFactoriaF5.miemakeup.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private double price;
    private String imageUrl;
    private boolean featured;
    private String description;
    private String ingredients;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany
    @JoinTable(
            name = "product_consumer",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "consumer_id")
    )
    private List<Consumer> consumers;

    public Product(String name, double price, String imageUrl, boolean featured, String description, String ingredients) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.featured= featured;
        this.description = description;
        this.ingredients = ingredients;
    }

    public Product(String name, double price, String imageUrl, boolean featured, String description, String ingredients, Category category, List<Consumer> consumers) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.featured = featured;
        this.description = description;
        this.ingredients = ingredients;
        this.category = category;
        this.consumers = consumers;
    }

    public Product(String name, double price, String imageUrl, boolean featured, String description, String ingredients, Category category) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.featured = featured;
        this.description = description;
        this.ingredients = ingredients;
        this.category = category;
    }
}
