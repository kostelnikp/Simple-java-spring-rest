package com.project.rest_app.controller;

import com.project.rest_app.model.Order;
import com.project.rest_app.model.OrderProduct;
import com.project.rest_app.repo.OrderProductRepo;
import com.project.rest_app.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderProductController {

    @Autowired
    private OrderProductRepo orderProductRepo;

    @Autowired
    private OrderRepo orderRepo;

    @GetMapping("/getAllOrderProducts")
    public ResponseEntity<List<OrderProduct>> getAllOrderProducts() {
        try {
            List<OrderProduct> orderProductList = new ArrayList<>();
            orderProductRepo.findAll().forEach(orderProductList::add);

            if (orderProductList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(orderProductList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOrderProductById/{id}")
    public ResponseEntity<OrderProduct> getOrderProductById(@PathVariable Long id) {
        Optional<OrderProduct> orderProductData = orderProductRepo.findById(id);

        if (orderProductData.isPresent()) {
            return new ResponseEntity<>(orderProductData.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/createOrderProduct")
    public ResponseEntity<OrderProduct> createOrderProduct(@RequestBody OrderProduct orderProduct) {

        OrderProduct orderProductObj = orderProductRepo.save(orderProduct);

        if (orderRepo.findById(orderProduct.getOrder().getId()).isPresent()){
            Order order = orderRepo.findById(orderProduct.getOrder().getId()).get();

            Long currentTotalAmount = order.getTotalAmount();

            currentTotalAmount += orderProduct.getTotalPrice();

            order.setTotalAmount(currentTotalAmount);

            orderRepo.save(order);
        }



        return new ResponseEntity<>(orderProductObj, HttpStatus.CREATED);


    }


    @PutMapping("/updateOrderProductById/{id}")
    public ResponseEntity<OrderProduct> updateOrderProductById(@PathVariable Long id, @RequestBody OrderProduct orderProduct) {
        Optional<OrderProduct> oldOrderProductData = orderProductRepo.findById(id);

        if (oldOrderProductData.isPresent()) {
            OrderProduct newOrderProductData = oldOrderProductData.get();
            newOrderProductData.setOrder(orderProduct.getOrder());
            newOrderProductData.setProduct(orderProduct.getProduct());
            newOrderProductData.setQuantity(orderProduct.getQuantity());
            newOrderProductData.setTotalPrice(orderProduct.getTotalPrice());

            OrderProduct updatedOrderProduct = orderProductRepo.save(newOrderProductData);
            return new ResponseEntity<>(updatedOrderProduct, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteOrderProductById/{id}")
    public ResponseEntity<HttpStatus> deleteOrderProductById(@PathVariable Long id) {
        try {
            orderProductRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
