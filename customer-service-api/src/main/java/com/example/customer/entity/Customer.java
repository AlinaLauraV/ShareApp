package com.example.customer.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private int detailId;
    @Id
    private int customerId;
    private int shareId;
    private String shareType;
    private int quantity;
}
