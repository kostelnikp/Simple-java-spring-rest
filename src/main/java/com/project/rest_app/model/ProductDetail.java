package com.project.rest_app.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ProductDetails")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String detail;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
