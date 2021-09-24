package waa.finalproject.service.order;

import waa.finalproject.domain.Order;
import waa.finalproject.domain.OrderStatus;
import waa.finalproject.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order findOrderById(long id){
        return orderRepository.findById(id).get();
    }

    @Override
    public Order cancelOrder(long orderId) {
        Order order = findOrderById(orderId);
        if(order.getStatus() == OrderStatus.ORDERED){
            order.setStatus(OrderStatus.CANCELLED);
        }
        return orderRepository.save(order);
    }

    @Override
    public Order shipOrder(long orderId) {
        Order order = findOrderById(orderId);
        if (order.getStatus() == OrderStatus.ORDERED){
            order.setStatus(OrderStatus.SHIPPED);
        }
        return orderRepository.save(order);
    }

    @Override
    public Order deliverOrder(long orderId) {
        Order order = findOrderById(orderId);
        if (order.getStatus() == OrderStatus.SHIPPED){
            order.setStatus(OrderStatus.DELIVERED);
        }
        return orderRepository.save(order);
    }
}
