package waa.finalproject.controller;

import waa.finalproject.domain.Address;
import waa.finalproject.dto.AddressDto;
import waa.finalproject.service.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @PatchMapping("/addresses/{id}")
    public Address editAddress(@RequestBody AddressDto addressDto, @PathVariable long id){
        return addressService.updateAddress(addressDto, id);
    }
    @DeleteMapping("/addresses/{id}")
    public void removeAddress(@PathVariable long id){
        addressService.deleteAddress(id);
    }
}
