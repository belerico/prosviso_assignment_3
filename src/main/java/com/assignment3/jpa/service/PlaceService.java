package com.assignment3.jpa.service;

import com.assignment3.jpa.dao.PlaceDao;
import com.assignment3.jpa.model.Place;
import com.assignment3.jpa.model.User;

import java.util.Iterator;
import java.util.List;

public class PlaceService extends AbstractService<Place, Long> {

    public PlaceService() { super(new PlaceDao()); }

    @Override
    public void delete(Place entity) {
        /*Iterator<User> i = entity.getUsers().iterator();
        while (i.hasNext()) {
            User u = i.next();
            i.remove();
            u.removePlace(entity);
        }*/
        getDao().begin();
        getDao().delete(entity);
        getDao().commit();


    }
}
