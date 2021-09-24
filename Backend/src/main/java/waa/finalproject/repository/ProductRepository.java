package waa.finalproject.repository;

import waa.finalproject.domain.Product;
import waa.finalproject.domain.Seller;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ProductRepository extends CrudRepository<Product, Long> {

    Set<Product> findAllBySeller(Seller seller);
 }
