package waa.finalproject.service.address;

import waa.finalproject.domain.Address;
import waa.finalproject.dto.AddressDto;
import waa.finalproject.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Override
    public void deleteAddress(long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public Address updateAddress(AddressDto addressDto, long id) {
       Address address = addressRepository.findById(id).get();
       address.setCity(addressDto.getCity());
       address.setState(addressDto.getState());
       address.setZipCode(addressDto.getZipCode());
       address.setAddressType(addressDto.getAddressType());
       return addressRepository.save(address);
    }
}
