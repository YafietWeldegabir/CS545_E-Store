package waa.finalproject.service.product;

import waa.finalproject.domain.Order;
import waa.finalproject.domain.Product;
import waa.finalproject.domain.Review;
import waa.finalproject.dto.ProductRequestDto;

import java.util.List;


public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(long id);

    void deleteProduct(long id);

    Product updateProduct(ProductRequestDto product, long id);

    List<Review> getReviewsOfProduct(long id);

    List<Order> getOrdersOfProduct(long id);
}
