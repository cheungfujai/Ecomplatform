package com.kevdev.ecomplatform.Domain.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name="user")
public class User {
    @Id
    @Nullable
    @Column(name="username")
    String UserName;
    @Nullable
    @Column(name="instgramName")
    String instgramName;
    @Nullable
    @Column(name="address")
    String Address;

    @Column(name="contactNumber")
    String contactNumber;
    @Column(name="admin")
    Boolean isAdmin;
    @Column(name="spent")
    double totalSpent;

    public User() {

    }
}
