package com.agilitysolutions.mapping.geocoding.library.enums

class AddressComponentTypeTest extends GroovyTestCase {
    void testGetValue() {
        assertEquals(AddressComponentType.StreetAddress, AddressComponentType.getValue("street_address"));
        assertEquals(AddressComponentType.Route, AddressComponentType.getValue("route"));
        assertEquals(AddressComponentType.Intersection, AddressComponentType.getValue("intersection"));
        assertEquals(AddressComponentType.Political, AddressComponentType.getValue("political"));
        assertEquals(AddressComponentType.Country, AddressComponentType.getValue("country"));
        assertEquals(AddressComponentType.AdministrativeAreaLevel1, AddressComponentType.getValue("administrative_area_level_1"));
        assertEquals(AddressComponentType.AdministrativeAreaLevel2, AddressComponentType.getValue("administrative_area_level_2"));
        assertEquals(AddressComponentType.AdministrativeAreaLevel3, AddressComponentType.getValue("administrative_area_level_3"));
        assertEquals(AddressComponentType.ColloquialArea, AddressComponentType.getValue("colloguial_area"));
        assertEquals(AddressComponentType.Locatity, AddressComponentType.getValue("locality"));
        assertEquals(AddressComponentType.Sublocality, AddressComponentType.getValue("sublocality"));
        assertEquals(AddressComponentType.Neighborhood, AddressComponentType.getValue("neighborhood"));
        assertEquals(AddressComponentType.Premise, AddressComponentType.getValue("premise"));
        assertEquals(AddressComponentType.Subpremise, AddressComponentType.getValue("subpremise"));
        assertEquals(AddressComponentType.PostalCode, AddressComponentType.getValue("postal_code"));
        assertEquals(AddressComponentType.NaturalFeature, AddressComponentType.getValue("natural_feature"));
        assertEquals(AddressComponentType.Airport, AddressComponentType.getValue("airport"));
        assertEquals(AddressComponentType.Park, AddressComponentType.getValue("park"));
        assertEquals(AddressComponentType.PointOfInterest, AddressComponentType.getValue("point_of_interest"));
        assertEquals(AddressComponentType.PostBox, AddressComponentType.getValue("post_box"));
        assertEquals(AddressComponentType.StreetNumber, AddressComponentType.getValue("street_number"));
        assertEquals(AddressComponentType.Floor, AddressComponentType.getValue("floor"));
        assertEquals(AddressComponentType.Room, AddressComponentType.getValue("room"));

        assertNull(AddressComponentType.getValue("something"));
    }
}
