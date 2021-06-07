package com.kevdev.ecomplatform.Domain.User;

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
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    @Nullable
    @Column(name="username")
    private String name;
    @Nullable
    @Column(name="instagramName")
    private String instagramName;
    @Nullable
    @Column(name="address")
    private String address;

    @Column(name="contactNumber")
    private String contactNumber;
    @Column(name="admin")
    private Boolean isAdmin;
    @Column(name="spent")
    private double totalSpent;


}
