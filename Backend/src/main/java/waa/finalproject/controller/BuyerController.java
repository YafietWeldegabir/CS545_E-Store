package waa.finalproject.controller;

import waa.finalproject.domain.*;
import waa.finalproject.dto.OrderAddressDto;
import waa.finalproject.service.buyer.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin("http://localhost:3000")
@RestController
public class BuyerController {

    @Autowired
    BuyerService buyerService;

    @GetMapping("/buyers/{id}")
    public Buyer loadBuyerById(@PathVariable long id){
        return buyerService.findBuyerById(id);
    }
    @GetMapping("/buyers/{id}/reviews") // get buyer reviews
    public List<Review> getBuyerReviews(@PathVariable long id){
        return buyerService.findReviewsByBuyerId(id);
    }

    @PostMapping("/buyers/{id}/products/{productId}/reviews") // add buyer review
    public Review addReviewToProductByBuyer(@RequestBody Review review, @PathVariable long id, @PathVariable long productId){
        return buyerService.addReviewByBuyerId(review, id, productId);
    }

    @PostMapping("/buyers/{id}/addresses") // add buyer address
    public Address addAddressToBuyer(@RequestBody Address address, @PathVariable long id){
        return buyerService.addAddressToBuyer(address, id);
    }

    @GetMapping("/buyers/{id}/addresses") // get buyer addresses
    public List<Address> getAddressesOfBuyer(@PathVariable long id){
        return buyerService.getAddressesOfBuyer(id);
    }

     @GetMapping("/buyers/{id}/orders") // get buyer orders
    public List<Order> loadOrdersForBuyer(@PathVariable long id){
        return buyerService.findBuyerOrdersById(id);
     }

     @PostMapping("/buyers/{id}/sellers/{sellerId}/follow")
     public Set<Seller> followSeller(@PathVariable long id, @PathVariable long sellerId){
         return buyerService.followSeller(id, sellerId);
     }

     @PostMapping("/buyers/{id}/sellers/{sellerId}/unfollow")
     public Set<Seller> unfollowSeller(@PathVariable long id, @PathVariable long sellerId){
         return buyerService.unfollowSeller(id, sellerId);
     }
    @GetMapping("/buyers/{id}/shoppingcart")
    public List<Product> loadShoppingCart(@PathVariable long id){
        return buyerService.findOrCreateShoppingCart(id);
    }

    @PatchMapping("/buyers/{id}/shoppingcart")
    public List<Product> addProductsToShoppingCart(@RequestBody List<Product> products, @PathVariable long id){
        return buyerService.addProductsToCart(products, id);
    }

    @PatchMapping("/buyers/{id}/shoppingcart/clear")
    public List<Product> clearShoppingCart(@PathVariable long id){
        return buyerService.clearShoppingCart(id);
    }

    @PostMapping("/buyers/{id}/shoppingcart/process")
    public Invoice processShoppingCart(@RequestBody OrderAddressDto orderAddresses, @PathVariable long id){
        return buyerService.processShoppingCart(orderAddresses, id);
    }

}
