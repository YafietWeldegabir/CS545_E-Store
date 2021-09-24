package waa.finalproject.dto;

import waa.finalproject.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderAddressDto {

    private Address shippingAddress;
    private Address billingAddress;
}
