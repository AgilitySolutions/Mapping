package com.agilitysolutions.mapping.geocoding.library

import com.agilitysolutions.mapping.geocoding.library.enums.AddressComponentType
import com.agilitysolutions.mapping.geocoding.library.enums.LocationType

class ResultTest extends GroovyTestCase {
    private Result _result;

    void setUp() {
        super.setUp()

        _result = new Result();
    }

    void testSetGetAddressComponentTypes() {
        List<AddressComponentType> addressComponentTypes = new ArrayList<AddressComponentType>();
        addressComponentTypes.add(AddressComponentType.Political);
        addressComponentTypes.add(AddressComponentType.AdministrativeAreaLevel2);

        _result.setAddressComponentTypes(addressComponentTypes);

        assertEquals(addressComponentTypes, _result.getAddressComponentTypes());
    }

    void testSetGetFormattedAddress() {
        _result.setFormattedAddress("Test formatted address");

        assertEquals("Test formatted address", _result.getFormattedAddress());
    }

    void testSetGetAddressComponents() {
        List<AddressComponentType> addressComponentTypes = new ArrayList<AddressComponentType>();
        addressComponentTypes.add(AddressComponentType.Political);
        addressComponentTypes.add(AddressComponentType.AdministrativeAreaLevel2);

        AddressComponent addressComponent = new AddressComponent();
        addressComponent.setAddressComponentTypes(addressComponentTypes);

        List<AddressComponent> addressComponents = new ArrayList<AddressComponent>();
        addressComponents.add(addressComponent);

        _result.setAddressComponents(addressComponents);

        assertEquals(addressComponents, _result.getAddressComponents());
    }

    void testSetGetGeometry() {
        Geometry geometry = new Geometry();

        Location location = new Location();
        location.setLatitude(BigDecimal.valueOf(34.172684));
        location.setLongitude(BigDecimal.valueOf(-118.604794));

        geometry.setLocation(location);
        geometry.setLocationType(LocationType.Approximate);

        Viewport viewport = new Viewport();

        Location northeast = new Location();
        northeast.setLatitude(BigDecimal.valueOf(34.236144));
        northeast.setLongitude(BigDecimal.valueOf(-118.500938));

        viewport.setNortheast(northeast);

        Location southwest = new Location();
        southwest.setLatitude(BigDecimal.valueOf(34.172684));
        southwest.setLongitude(BigDecimal.valueOf(-118.604794));

        viewport.setSouthwest(southwest);

        geometry.setViewport(viewport);

        _result.setGeometry(geometry);

        assertEquals(BigDecimal.valueOf(34.172684), _result.getGeometry().getLocation().getLatitude());
        assertEquals(BigDecimal.valueOf(-118.604794),  _result.getGeometry().getLocation().getLongitude());
        assertEquals(LocationType.Approximate,  _result.getGeometry().getLocationType());
        assertEquals(BigDecimal.valueOf(34.236144),  _result.getGeometry().getViewport().getNortheast().getLatitude());
        assertEquals(BigDecimal.valueOf(-118.500938),  _result.getGeometry().getViewport().getNortheast().getLongitude());
        assertEquals(BigDecimal.valueOf(34.172684),  _result.getGeometry().getViewport().getSouthwest().getLatitude());
        assertEquals(BigDecimal.valueOf(-118.604794),  _result.getGeometry().getViewport().getSouthwest().getLongitude());
    }

    void testSetGetPartialMatch() {
        _result.setPartialMatch(true);

        assertTrue(_result.getPartialMatch());
    }
}
