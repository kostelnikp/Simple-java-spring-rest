package com.project.rest_app.controller;

import com.project.rest_app.model.Order;
import com.project.rest_app.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    private OrderRepo orderRepo;

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<Order>> getAllOrders() {
        try {
            List<Order> orderList = new ArrayList<>();
            orderRepo.findAll().forEach(orderList::add);

            if (orderList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(orderList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOrderById/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Optional<Order> orderData = orderRepo.findById(id);

        if (orderData.isPresent()) {
            return new ResponseEntity<>(orderData.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/createOrder")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order orderObj = orderRepo.save(order);

        return new ResponseEntity<>(orderObj, HttpStatus.OK);
    }

    @PostMapping("/updateOrderById/{id}")
    public ResponseEntity<Order> updateOrderById(@PathVariable Long id, @RequestBody Order order) {
        Optional<Order> oldOrderData = orderRepo.findById(id);

        if (oldOrderData.isPresent()) {
            Order newOrderData = oldOrderData.get();
            newOrderData.setOrderDate(order.getOrderDate());
            newOrderData.setTotalAmount(order.getTotalAmount());
            newOrderData.setStatus(order.getStatus());
            newOrderData.setCustomer(order.getCustomer());

            Order orderObj = orderRepo.save(newOrderData);
            return new ResponseEntity<>(orderObj, HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/deleteOrderById/{id}")
    public ResponseEntity<HttpStatus> deleteOrderById(@PathVariable Long id) {
        orderRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
