package waa.finalproject.service.cart;

import waa.finalproject.domain.Product;
import waa.finalproject.domain.ShoppingCart;


public interface ShoppingCartService {
    Product addProductToShoppingCart(Product product);

    ShoppingCart addShoppingCart(ShoppingCart shoppingCart);

    void deleteShoppingCart(ShoppingCart shoppingCart);
}
