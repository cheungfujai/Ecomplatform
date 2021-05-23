package com.kevdev.ecomplatform.Domain.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jboss.jandex.Main;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name="product_name")
    private String productName;

    @Column(name="product_price")
    private double productPrice;

    @Column(name="create_at")
    private LocalDateTime createAt;

    @Nullable
    @Column(name="update_at")
    private LocalDateTime updateAt;

    @Nullable
    @Column(name="weight")
    private double productWeight;

    @Nullable
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Maintype> mainTypeList = new ArrayList<>();

    @Column(name = "inventory")
    private boolean hasInventory;

    public Product(
            String productName,
            double productPrice,
            double productWeight,
            boolean hasInventory) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.createAt = LocalDateTime.now();
        this.updateAt = LocalDateTime.now();
        this.productWeight = productWeight;
        this.hasInventory = hasInventory;
    }
}
