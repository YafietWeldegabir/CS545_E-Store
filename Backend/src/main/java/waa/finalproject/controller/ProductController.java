package waa.finalproject.controller;

import waa.finalproject.domain.Order;
import waa.finalproject.domain.Product;
import waa.finalproject.domain.Review;
import waa.finalproject.dto.ProductRequestDto;
import waa.finalproject.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Product> loadAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product loadProductById(@PathVariable long id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
    }

    @PatchMapping("/products/{id}")
    public Product updateProduct(@RequestBody ProductRequestDto productRequestDto, @PathVariable long id){
        return productService.updateProduct(productRequestDto, id);
    }

    @GetMapping("/products/{id}/reviews")
    public List<Review> loadReviewsOfProduct(@PathVariable long id){
        return productService.getReviewsOfProduct(id);
    }

    @GetMapping("products/{id}/orders")
    public List<Order> loadOrdersOfProduct(@PathVariable long id){
        return productService.getOrdersOfProduct(id);
    }
}
