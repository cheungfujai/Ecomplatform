package com.kevdev.ecomplatform.Domain.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_sub_type")
public class Subtype {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "sub_type_name")
    private String subTypeName;

    @OneToOne(mappedBy="subType")
    private Product product;

    public Subtype(String subTypeName){
        this.subTypeName = subTypeName;
    }
}
