package com.project.rest_app.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "OrderProducts")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "total_price")
    private Long totalPrice;
}
