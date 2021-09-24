package waa.finalproject.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class AddressTypeConverter implements AttributeConverter<AddressType,String> {
    @Override
    public String convertToDatabaseColumn(AddressType addressType) {
        if (addressType == null){
            return null;
        }
        return addressType.getType();
    }

    @Override
    public AddressType convertToEntityAttribute(String addressType) {
        if (addressType == null){
            return null;
        }
        return Stream.of(AddressType.values())
                .filter(c -> c.getType().equals(addressType))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
