package waa.finalproject.repository;

import waa.finalproject.domain.Buyer;
import waa.finalproject.domain.Order;
import waa.finalproject.domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order,Long> {

    List<Order> findAllByBuyer(Buyer buyer);

    Order findFirstByProduct(Product product);

    List<Order> findAllByProduct(Product product);
}
