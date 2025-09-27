package com.project.rest_app.repo;

import com.project.rest_app.model.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailRepo extends JpaRepository<ProductDetail, Long> {
    List<ProductDetail> findAllByProductId(Long productId);
}
