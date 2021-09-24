package waa.finalproject.controller;

import waa.finalproject.domain.Order;
import waa.finalproject.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:3000")
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PatchMapping("/orders/{orderId}/cancel")
    public Order cancel(@PathVariable long orderId){
        return orderService.cancelOrder(orderId);
    }

    @PatchMapping("/orders/{orderId}/ship")
    public Order ship(@PathVariable long orderId){
        return orderService.shipOrder(orderId);
    }

    @PatchMapping("/orders/{orderId}/deliver")
    public Order deliver(@PathVariable long orderId){
        return orderService.deliverOrder(orderId);
    }
}
