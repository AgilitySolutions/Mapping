package com.agilitysolutions.mapping.geocoding.library

import com.agilitysolutions.mapping.geocoding.library.enums.AddressComponentType

class AddressComponentTest extends GroovyTestCase {
    private AddressComponent _addressComponent;

    void setUp() {
        super.setUp()

        _addressComponent = new AddressComponent();
    }

    void testSetGetLongName() {
        _addressComponent.setLongName("Test Long Name");

        assertEquals("Test Long Name", _addressComponent.getLongName());
    }

    void testSetGetShortName() {
        _addressComponent.setShortName("Test Short Name");

        assertEquals("Test Short Name", _addressComponent.getShortName());
    }

    void testSetGetAddressComponentTypes() {
        List<AddressComponentType> addressComponentTypes = new ArrayList<AddressComponentType>();
        addressComponentTypes.add(AddressComponentType.Political);
        addressComponentTypes.add(AddressComponentType.AdministrativeAreaLevel2);

        _addressComponent.setAddressComponentTypes(addressComponentTypes);

        assertEquals(addressComponentTypes, _addressComponent.getAddressComponentTypes());
    }
}
