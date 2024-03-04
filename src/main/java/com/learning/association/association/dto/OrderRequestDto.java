package com.learning.association.association.dto;


import com.learning.association.association.model.Product;
import jakarta.persistence.Entity;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDto {

    private Long customerId;
    private Product product;
    private Integer quantity;


}
