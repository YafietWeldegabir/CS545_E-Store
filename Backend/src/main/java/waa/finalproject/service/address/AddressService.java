package waa.finalproject.service.address;

import waa.finalproject.domain.Address;
import waa.finalproject.dto.AddressDto;


public interface AddressService {

    void deleteAddress(long id);

    Address updateAddress(AddressDto addressDto, long id);
}
