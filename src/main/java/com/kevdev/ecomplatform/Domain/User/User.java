package com.kevdev.ecomplatform.Domain.User;

import org.springframework.lang.Nullable;

public class User {
    @Nullable
    String UserName;
    @Nullable
    String instgramName;
    @Nullable
    String Address;

    String contactNumber;
    Boolean isAdmin;
    double totalSpent;
}
