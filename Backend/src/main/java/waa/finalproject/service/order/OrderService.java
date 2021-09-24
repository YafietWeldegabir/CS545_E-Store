package waa.finalproject.service.order;

import waa.finalproject.domain.Order;


public interface OrderService {

    Order findOrderById(long id);

    Order cancelOrder(long orderId);

    Order shipOrder(long orderId);

    Order deliverOrder(long orderId);
}
