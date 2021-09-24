package waa.finalproject.service.cart;

import waa.finalproject.domain.Product;
import waa.finalproject.domain.ShoppingCart;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Override
    public Product addProductToShoppingCart(Product product) {
        return null;
    }

    @Override
    public ShoppingCart addShoppingCart(ShoppingCart shoppingCart) {
        return null;
    }

    @Override
    public void deleteShoppingCart(ShoppingCart shoppingCart) {

    }
}
