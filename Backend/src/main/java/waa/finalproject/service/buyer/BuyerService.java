package waa.finalproject.service.buyer;

import waa.finalproject.domain.*;
import waa.finalproject.dto.OrderAddressDto;

import java.util.List;
import java.util.Set;


public interface BuyerService {

    Buyer findBuyerById(long id);

    Buyer addBuyer(Buyer buyer);

    List<Order> findBuyerOrdersById(long id);

    Review addReviewByBuyerId(Review review, long id, long productId);

    List<Review> findReviewsByBuyerId(long id);

    Address addAddressToBuyer(Address address, long id);

    List<Address> getAddressesOfBuyer(long id);

    List<Product> findOrCreateShoppingCart(long id);

    List<Product> addProductsToCart(List<Product> products, long id);

    List<Product> clearShoppingCart(long id);

    Invoice processShoppingCart(OrderAddressDto orderAddresses, long id);

    Set<Seller> followSeller(long id, long sellerId);

    Set<Seller> unfollowSeller(long id, long sellerId);

}
