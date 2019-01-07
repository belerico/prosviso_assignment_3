package com.assignment3.jpa.utils.faker;

import com.assignment3.jpa.model.Place;

public class PlaceFaker extends AbstractFaker<Place> {

    @Override
    public Place create() {
        Place place = new Place();
        place.setCAP(getFaker().address().zipCode());
        place.setCity(getFaker().address().city());
        place.setProvince(getFaker().address().country());
        place.setRegion(getFaker().address().state());
        return place;
    }
}
