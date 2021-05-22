package com.kevdev.ecomplatform.Domain.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_main_type")
public class Maintype {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "main_type_name")
    private String mainTypeName;

    @Nullable
    @OneToOne(mappedBy="mainType")
    private Product product;

    @Nullable
    @Column(name = "photo_url")
    private String base64StringPhoto;

    public Maintype(String mainTypeName){
        this.mainTypeName = mainTypeName;
    }
}
