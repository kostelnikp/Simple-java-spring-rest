package com.project.rest_app.controller;

import com.project.rest_app.model.ProductDetail;
import com.project.rest_app.repo.ProductDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductDetailController {

    @Autowired
    private ProductDetailRepo productDetailRepo;

    @GetMapping("/getAllProductDetails")
    public ResponseEntity<List<ProductDetail>> getAllProductDetails() {
        try {
            List<ProductDetail> productDetailsList = new ArrayList<>();
            productDetailRepo.findAll().forEach(productDetailsList::add);

            if (productDetailsList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(productDetailsList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getProductDetailById/{id}")
    public ResponseEntity<List<ProductDetail>> getProductDetailById(@PathVariable Long id) {
        try {
            List<ProductDetail> productDetails = productDetailRepo.findAllByProductId(id);

            if (productDetails.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(productDetails, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PostMapping("/createProductDetail")
    public ResponseEntity<ProductDetail> createProductDetail(@RequestBody ProductDetail productDetail) {
        ProductDetail productDetailObj = productDetailRepo.save(productDetail);

        return new ResponseEntity<>(productDetailObj, HttpStatus.CREATED);
    }

    @PutMapping("/updateProductDetailById/{id}")
    public ResponseEntity<ProductDetail> updateProductDetailById(@PathVariable Long id, @RequestBody ProductDetail productDetail) {
        Optional<ProductDetail> oldProductDetailData = productDetailRepo.findById(id);

        if (oldProductDetailData.isPresent()) {
            ProductDetail newProductDetailData = oldProductDetailData.get();
            newProductDetailData.setDetail(productDetail.getDetail());

            ProductDetail updatedProductDetail = productDetailRepo.save(newProductDetailData);
            return new ResponseEntity<>(updatedProductDetail, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteProductDetailById/{id}")
    public ResponseEntity<HttpStatus> deleteProductDetailById(@PathVariable Long id) {
        try {
            productDetailRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
