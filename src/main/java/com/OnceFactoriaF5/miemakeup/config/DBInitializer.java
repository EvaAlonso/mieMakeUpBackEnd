package com.OnceFactoriaF5.miemakeup.config;

import com.OnceFactoriaF5.miemakeup.models.Category;
import com.OnceFactoriaF5.miemakeup.models.Consumer;
import com.OnceFactoriaF5.miemakeup.models.Product;
import com.OnceFactoriaF5.miemakeup.repositories.CategoryRepository;
import com.OnceFactoriaF5.miemakeup.repositories.ConsumerRepository;
import com.OnceFactoriaF5.miemakeup.repositories.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Arrays;
import java.util.Optional;

@Component
public class DBInitializer {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ConsumerRepository consumerRepository;
    //private final BCryptPasswordEncoder passwordEncoder;

    public DBInitializer(ProductRepository productRepository, CategoryRepository categoryRepository, ConsumerRepository consumerRepository /*BCryptPasswordEncoder passwordEncoder*/) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.consumerRepository = consumerRepository;
       /* this.passwordEncoder = passwordEncoder;*/
    }

    @PostConstruct
    public void initializer(){
        initCategories();
        initProducts();
        initConsumers();
    }
    public void initCategories(){
        List<Category> categoriesList = Arrays.asList(
                new Category("Foundation"),
                new Category("Lipstick"),
                new Category("Mascara"),
                new Category("Blush"),
                new Category("Bronzer"),
                new Category("Highlighter"),
                new Category("Eyeshadow"),
                new Category("Setting Spray"),
                new Category("Eyebrow Products"),
                new Category("Concealer"),
                new Category("Nail Polish"),
                new Category("Makeup Brushes"),
                new Category("Primer"),
                new Category("Brow Pencil"),
                new Category("Makeup Remover")
        );
        categoryRepository.saveAll(categoriesList);
    }
    public void initProducts(){

        List<Product> productList = Arrays.asList(

         new Product("Charlotte Tilbury Airbrush Flawless Foundation", 40.00, "https://picsum.photos/300/200",true,"A full-coverage, long-lasting foundation that leaves skin looking smooth and flawless.", "Water, Dimethicone, Glycerin, Cyclopentasiloxane, Sodium Chloride",categoryRepository.findById(1).orElseThrow(()->new RuntimeException("Category with ID 1 not found!"))),
         new Product("Fenty Beauty Pro Filt'r Soft Matte Longwear Foundation", 36.00,"https://picsum.photos/300/200", false, "A soft matte foundation that provides medium to full coverage and controls shine.", "Water, Dimethicone, Glycerin, Isododecane, Iron Oxides", categoryRepository.findById(1).orElseThrow(()->new RuntimeException("Category with ID 1 not found!"))),
         new Product("Revolution Pro Full Coverage Foundation", 10.00,"https://picsum.photos/300/200", true, "A high-coverage foundation for a flawless complexion.", "Water, Dimethicone, Titanium Dioxide, Iron Oxides, Glycerin", categoryRepository.findById(1).orElseThrow(()->new RuntimeException("Category with ID 1 not found!"))),
         new Product("Charlotte Tilbury Pillow Talk Lipstick", 30.00, "https://picsum.photos/300/200", false, "A dreamy pink nude lipstick that creates the perfect pout.", "Castor Seed Oil, Cera Alba (Beeswax), Tocopherol (Vitamin E), Mica, Titanium Dioxide", categoryRepository.findById(2).orElseThrow(()->new RuntimeException("Category with ID 2 not found!"))),
         new Product("Fenty Beauty Gloss Bomb Universal Lip Luminizer", 19.00, "https://picsum.photos/300/200", true, "A lip gloss that delivers explosive shine and a hint of color.", "Castor Seed Oil, Tocopherol (Vitamin E), Copernicia Cerifera (Carnauba) Wax", categoryRepository.findById(2).orElseThrow(()->new RuntimeException("Category with ID 2 not found!"))),
         new Product("Revolution Pro Lipstick - Matte", 7.00, "https://picsum.photos/300/200", true,"A bold matte lipstick that delivers full color payoff.", "Cera Alba (Beeswax), Ricinus Communis (Castor) Seed Oil, Mica, Titanium Dioxide",categoryRepository.findById(2).orElseThrow(()->new RuntimeException("Category with ID 2 not found!"))),
         new Product("Charlotte Tilbury Magic Cream", 100.00,"https://picsum.photos/300/200", false, "A luxurious moisturizer that hydrates and plumps the skin.", "Water, Glycerin, Dimethicone, Butylene Glycol, Tocopherol (Vitamin E)", categoryRepository.findById(13).orElseThrow(()->new RuntimeException("Category with ID 13 not found!"))),
         new Product("Fenty Beauty Match Stix Matte Skinstick", 25.00, "https://picsum.photos/300/200", false, "A versatile stick that can be used to contour, highlight, and correct.", "Dimethicone, Cyclopentasiloxane, Silica, Glycerin, Iron Oxides", categoryRepository.findById(13).orElseThrow(()->new RuntimeException("Category with ID 13 not found!"))),
         new Product("Revolution Pro Sculpting Bronzer", 9.00, "https://picsum.photos/300/200", true, "A bronzer that adds warmth and dimension to the face.", "Mica, Titanium Dioxide, Iron Oxides, Dimethicone", categoryRepository.findById(5).orElseThrow(()->new RuntimeException("Category with ID 5 not found!"))),
         new Product("Charlotte Tilbury Matte Revolution Lipstick", 32.00, "https://picsum.photos/300/200", false, "A matte lipstick with a soft, creamy formula.", "Cera Alba (Beeswax), Dimethicone, Castor Seed Oil, Titanium Dioxide",categoryRepository.findById(2).orElseThrow(()->new RuntimeException("Category with ID 2 not found!"))),
         new Product("Fenty Beauty Killawatt Freestyle Highlighter", 36.00, "https://picsum.photos/300/200", true,  "A duo highlighter with shimmer and glow.", "Mica, Titanium Dioxide, Iron Oxides, Tocopherol (Vitamin E)", categoryRepository.findById(6).orElseThrow(()->new RuntimeException("Category with ID 6 not found!"))),
         new Product("Revolution Pro Fix Setting Spray", 8.00, "https://picsum.photos/300/200", false, "A setting spray that locks makeup in place for all-day wear.", "Water, Alcohol Denat., Glycerin, Citric Acid", categoryRepository.findById(8).orElseThrow(()->new RuntimeException("Category with ID 8 not found!"))),
         new Product("Charlotte Tilbury Cheek to Chic Blush", 40.00,"https://picsum.photos/300/200", true,  "A blush that gives a soft, natural flush to the cheeks.", "Talc, Mica, Iron Oxides, Dimethicone", categoryRepository.findById(4).orElseThrow(()->new RuntimeException("Category with ID 4 not found!"))),
         new Product("Fenty Beauty Pro Filt'r Instant Retouch Primer", 32.00, "https://picsum.photos/300/200", false, "A primer that smooths the skin and mattifies for a long-lasting finish.", "Dimethicone, Silica, Glycerin, Phenoxyethanol, Caprylyl Glycol", categoryRepository.findById(13).orElseThrow(()->new RuntimeException("Category with ID 13 not found!"))),
         new Product("Revolution Pro HD Powder", 7.00, "https://picsum.photos/300/200", false, "A translucent powder that sets makeup and controls shine.", "Talc, Silica, Titanium Dioxide, Mica", categoryRepository.findById(1).orElseThrow(()->new RuntimeException("Category with ID 1 not found!"))),
         new Product("Charlotte Tilbury Hollywood Flawless Filter", 44.00, "https://picsum.photos/300/200", true, "A radiant complexion booster that can be worn alone or as a primer.", "Dimethicone, Glycerin, Titanium Dioxide, Mica",categoryRepository.findById(6).orElseThrow(()->new RuntimeException("Category with ID 6 not found!"))),
         new Product("Fenty Beauty Sun Stalk'r Instant Warmth Bronzer", 32.00, "https://picsum.photos/300/200", false, "A bronzer that gives a sun-kissed glow to the skin.", "Mica, Titanium Dioxide, Iron Oxides, Glycerin", categoryRepository.findById(5).orElseThrow(()->new RuntimeException("Category with ID 5 not found!"))),
         new Product("Revolution Pro Supreme Pigment Eyeliner", 6.00, "https://picsum.photos/300/200", false,"A highly-pigmented eyeliner for bold lines.", "Water, Iron Oxides, Glycerin, Carnauba Wax", categoryRepository.findById(7).orElseThrow(()->new RuntimeException("Category with ID 7 not found!"))),
         new Product("Charlotte Tilbury Wonderglow Primer", 40.00, "https://picsum.photos/300/200", false, "A glow-giving primer that creates a flawless base.", "Dimethicone, Glycerin, Water, Titanium Dioxide", categoryRepository.findById(13).orElseThrow(()->new RuntimeException("Category with ID 13 not found!"))),
         new Product("Fenty Beauty Stunna Lip Paint Longwear Fluid Lip Color", 25.00, "https://picsum.photos/300/200", true,  "A long-wear liquid lipstick with a weightless formula.", "Cyclopentasiloxane, Dimethicone, Castor Seed Oil, Iron Oxides",categoryRepository.findById(2).orElseThrow(()->new RuntimeException("Category with ID 2 not found!"))),
         new Product("Revolution Pro Brow Pomade", 7.00, "https://picsum.photos/300/200",false,"A pomade to fill and define the eyebrows.", "Mica, Iron Oxides, Titanium Dioxide, Cera Alba (Beeswax)", categoryRepository.findById(9).orElseThrow(()->new RuntimeException("Category with ID 9 not found!"))),
         new Product("Charlotte Tilbury Hollywood Beauty Light Wand", 38.00, "https://picsum.photos/300/200", true, "A highlighter that creates a soft, luminous glow.", "Water, Dimethicone, Titanium Dioxide, Mica", categoryRepository.findById(1).orElseThrow(()->new RuntimeException("Category with ID 1 not found!"))),
         new Product("Fenty Beauty Pro Filt'r Soft Matte Foundation", 36.00, "https://picsum.photos/300/200", false,"A soft matte foundation that provides a flawless finish.", "Water, Dimethicone, Glycerin, Iron Oxides, Isododecane", categoryRepository.findById(1).orElseThrow(()->new RuntimeException("Category with ID 1 not found!"))),
         new Product("Revolution Pro Brow Gel", 6.00,"https://picsum.photos/300/200", false, "A brow gel that sets eyebrows in place.", "Water, Copernicia Cerifera (Carnauba) Wax, Glycerin", categoryRepository.findById(9).orElseThrow(()->new RuntimeException("Category with ID 9 not found!"))),
         new Product("Charlotte Tilbury Magic Away Concealer", 30.00,"https://picsum.photos/300/200",false, "A full-coverage concealer that covers blemishes and dark circles.", "Dimethicone, Titanium Dioxide, Glycerin, Cyclopentasiloxane", categoryRepository.findById(10).orElseThrow(()->new RuntimeException("Category with ID 10 not found!"))),
         new Product("Fenty Beauty Snap Shadows Mix & Match Eyeshadow Palette", 25.00,"https://picsum.photos/300/200",true, "A compact eyeshadow palette with six versatile shades.", "Mica, Titanium Dioxide, Iron Oxides, Dimethicone", categoryRepository.findById(7).orElseThrow(()->new RuntimeException("Category with ID 7 not found!"))),
         new Product("Revolution Pro Brow Kit", 9.00,"https://picsum.photos/300/200",false, "A brow kit that includes powder, wax, and a brush.", "Mica, Iron Oxides, Cera Alba (Beeswax)", categoryRepository.findById(9).orElseThrow(()->new RuntimeException("Category with ID 9 not found!"))),
         new Product("Charlotte Tilbury Luxury Palette Eyeshadow", 50.00,"https://picsum.photos/300/200",true, "A luxurious eyeshadow palette with four rich shades.", "Mica, Titanium Dioxide, Dimethicone, Iron Oxides", categoryRepository.findById(7).orElseThrow(()->new RuntimeException("Category with ID 7 not found!"))),
         new Product("Fenty Beauty Portable Highlighter", 30.00,"https://picsum.photos/300/200", true, "A portable highlighter with a luminous finish.", "Mica, Titanium Dioxide, Iron Oxides, Glycerin", categoryRepository.findById(6).orElseThrow(()->new RuntimeException("Category with ID 6 not found!"))),
         new Product("Revolution Pro Ultimate Brow Pencil", 6.00, "https://picsum.photos/300/200",false,"A pencil that defines and shapes eyebrows.", "Iron Oxides, Mica, Titanium Dioxide", categoryRepository.findById(14).orElseThrow(()->new RuntimeException("Category with ID 14 not found!"))),
         new Product("Charlotte Tilbury Matte Revolution Lipstick", 32.00,"https://picsum.photos/300/200",false, "A lipstick that offers full color with a matte finish.", "Cera Alba (Beeswax), Dimethicone, Castor Seed Oil", categoryRepository.findById(2).orElseThrow(()->new RuntimeException("Category with ID 2 not found!"))
                ));
        productRepository.saveAll(productList);

    }

    public void initConsumers() {
        /*List<Consumer> consumersList = Arrays.asList(
                new Consumer("admin1", passwordEncoder.encode("adminPassword"), Consumer.Role.ADMIN),
                new Consumer("admin2", passwordEncoder.encode("adminPassword"), Consumer.Role.ADMIN),
                new Consumer("customer1", passwordEncoder.encode("customerPassword"), Consumer.Role.CLIENT),
                new Consumer("customer2", passwordEncoder.encode("customerPassword"), Consumer.Role.CLIENT),
                new Consumer("customer3", passwordEncoder.encode("customerPassword"), Consumer.Role.CLIENT),
                new Consumer("customer4", passwordEncoder.encode("customerPassword"), Consumer.Role.CLIENT),
                new Consumer("customer5", passwordEncoder.encode("customerPassword"), Consumer.Role.CLIENT)
        );*/
        List<Consumer> consumersList = List.of(
                new Consumer("admin1", "adminPassword", Consumer.Role.ADMIN),
                new Consumer("consumer1", "adminPassword", Consumer.Role.CLIENT),
                new Consumer("consumer2", "adminPassword", Consumer.Role.CLIENT),
                new Consumer("consumer3", "adminPassword", Consumer.Role.CLIENT),
                new Consumer("consumer4", "adminPassword", Consumer.Role.CLIENT)
        );

        consumerRepository.saveAll(consumersList);
    }

}
