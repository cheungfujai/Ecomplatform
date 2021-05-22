package com.kevdev.ecomplatform.Domain.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jboss.jandex.Main;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @Column(name="product_rice")
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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_main_type")
    private Maintype mainType;

    @Nullable
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_sub_type")
    private Subtype subType;

    @Column(name = "inventory")
    private boolean hasInventory;

    public Product(
            String productName,
            double productPrice,
            double productWeight,
            @Nullable Maintype mainType,
            @Nullable Subtype subType,
            boolean hasInventory) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.createAt = LocalDateTime.now();
        this.updateAt = LocalDateTime.now();
        this.productWeight = productWeight;
        this.mainType = mainType;
        this.subType = subType;
        this.hasInventory = hasInventory;
    }
}
