package waa.finalproject.repository;

import waa.finalproject.domain.Address;
import waa.finalproject.domain.Buyer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address,Long> {

    List<Address> findAllByBuyer(Buyer buyer);
}
