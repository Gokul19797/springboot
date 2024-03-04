package com.learning.association.association.controller;

import com.learning.association.association.dto.OrderRequestDto;
import com.learning.association.association.dto.OrdersResponseDTO;
import com.learning.association.association.model.OrderDetails;
import com.learning.association.association.model.Orders;
import com.learning.association.association.repository.CustomerRepository;
import com.learning.association.association.repository.OrderDetailsRepository;
import com.learning.association.association.repository.OrderRepository;
import com.learning.association.association.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/order/")
@AllArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;
    private final OrderDetailsRepository orderDetailsRepository;


    @PostMapping("place-order/{customerId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<OrdersResponseDTO> placeOrder(@PathVariable Long customerId, @RequestBody OrderRequestDto orderRequestDto){

      Orders orders=  mapOrderDetailsToOrders(customerId,orderRequestDto);

        orders= orderRepository.save(orders);

      OrderDetails orderDetails =  createOrderDetailsToSave(orders,orderRequestDto);

        orderDetails=  orderDetailsRepository.save(orderDetails);

        OrdersResponseDTO ordersResponseDTO=  mapOrderDetailsToOrderResponseDto(orderDetails);

        return ResponseEntity.ok(ordersResponseDTO);

    }

    private OrdersResponseDTO mapOrderDetailsToOrderResponseDto(OrderDetails orderDetails) {

        OrdersResponseDTO ordersResponseDTO = new OrdersResponseDTO();
        ordersResponseDTO.setOrderDetailsNumber(orderDetails.getOrderNumber());
        ordersResponseDTO.setOrderDate(orderDetails.getOrderDate());
        ordersResponseDTO.setQuantity(orderDetails.getQuantity());
        return  ordersResponseDTO;

    }

    private OrderDetails createOrderDetailsToSave(Orders orders, OrderRequestDto orderRequestDto) {

        OrderDetails orderDetails = new OrderDetails();

        orderDetails.setOrderId(orders.getOrderId());
        orderDetails.setProductId(orderRequestDto.getProduct().getId());
        orderDetails.setQuantity(orderRequestDto.getQuantity());
        orderDetails.setOrderDate(new Date());
        orderDetails.setOrderNumber(generateOrderNumber());

        return orderDetails;
    }

    private Orders mapOrderDetailsToOrders(Long customerId, OrderRequestDto orderRequestDto) {

        Orders orders = new Orders();
        orders.setCustomerId(customerId);

        return  orders;
    }

    public static String generateOrderNumber() {
        // Generate random UUID
        UUID uuid = UUID.randomUUID();
        // Convert UUID to string and remove hyphens
        String uuidString = uuid.toString().replace("-", "");
        // Extract the first 10 characters to get alphanumeric order number
        String orderNumber = uuidString.substring(0, 10);
        return orderNumber;
    }

}
