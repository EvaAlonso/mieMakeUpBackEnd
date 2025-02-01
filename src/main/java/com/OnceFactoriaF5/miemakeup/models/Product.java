package com.OnceFactoriaF5.miemakeup.models;

import jakarta.persistence.*;
import lombok.*;

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

    //rating
    //reviewCount

    public Product(String name, double price, String imageUrl, boolean featured, String description, String ingredients) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.featured= featured;
        this.description = description;
        this.ingredients = ingredients;
    }



}
