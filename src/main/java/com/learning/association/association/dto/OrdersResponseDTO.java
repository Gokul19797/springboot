package com.learning.association.association.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrdersResponseDTO {


    private String OrderDetailsNumber;

    private Integer quantity;

    private Date orderDate;

}
