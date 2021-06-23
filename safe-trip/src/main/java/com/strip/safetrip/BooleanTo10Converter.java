package com.strip.safetrip;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BooleanTo10Converter implements AttributeConverter<Boolean, Integer> {

    public Integer convertToDatabaseColumn(Boolean attribute) {
        return (attribute != null && attribute) ? 1 : 0;
    }

    public Boolean convertToEntityAttribute(Integer i) {
        return i == 1;
    }
}
