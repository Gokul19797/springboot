package com.learning.association.association.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(targetEntity = Orders.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId",referencedColumnName = "id")
    public List<Orders> orders;
}
