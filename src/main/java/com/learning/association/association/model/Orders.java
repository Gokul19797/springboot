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
@Table(name = "Orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Long customerId;

    @OneToMany(targetEntity = OrderDetails.class,cascade =CascadeType.ALL,fetch = FetchType.LAZY)
            @JoinColumn(name = "orderId",referencedColumnName = "orderId")
    List<OrderDetails>  orderDetails;
}
