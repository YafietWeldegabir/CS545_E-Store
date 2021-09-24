package waa.finalproject.dto;

import waa.finalproject.domain.AddressType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

    private String state;

    private String city;

    private int zipCode;

    private String country;

    private AddressType addressType;
}
