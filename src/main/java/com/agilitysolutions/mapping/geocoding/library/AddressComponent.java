package com.agilitysolutions.mapping.geocoding.library;

import com.agilitysolutions.mapping.geocoding.library.enums.AddressComponentType;

import java.util.List;

public class AddressComponent {
    private String longName;
    private String shortName;
    private List<AddressComponentType> addressComponentTypes;

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public List<AddressComponentType> getAddressComponentTypes() {
        return addressComponentTypes;
    }

    public void setAddressComponentTypes(List<AddressComponentType> addressComponentTypes) {
        this.addressComponentTypes = addressComponentTypes;
    }
}
