package com.agilitysolutions.mapping.geocoding.library;

import com.agilitysolutions.mapping.geocoding.library.enums.AddressComponentType;

import java.util.List;

public class AddressComponent {
    private String _longName;
    private String _shortName;
    private List<AddressComponentType> _addressComponentTypes;

    public String getLongName() {
        return _longName;
    }

    public void setLongName(String longName) {
        _longName = longName;
    }

    public String getShortName() {
        return _shortName;
    }

    public void setShortName(String shortName) {
        _shortName = shortName;
    }

    public List<AddressComponentType> getAddressComponentTypes() {
        return _addressComponentTypes;
    }

    public void setAddressComponentTypes(List<AddressComponentType> addressComponentTypes) {
        _addressComponentTypes = addressComponentTypes;
    }
}
