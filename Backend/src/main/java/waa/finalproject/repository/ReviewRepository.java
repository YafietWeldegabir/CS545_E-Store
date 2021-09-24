package waa.finalproject.repository;

import waa.finalproject.domain.Buyer;
import waa.finalproject.domain.Product;
import waa.finalproject.domain.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {

    List<Review> findAllByBuyer(Buyer buyer);
    List<Review> findAll();
    List<Review> findAllByProduct(Product product);
}
