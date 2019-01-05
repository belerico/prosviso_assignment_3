package com.assignment3.jpa.service;

import com.assignment3.jpa.dao.PlaceDao;
import com.assignment3.jpa.model.BusinessActivity;
import com.assignment3.jpa.model.Place;
import com.assignment3.jpa.model.User;

import java.util.Iterator;

public class PlaceService extends AbstractService<Place, Long> {

    public PlaceService() { super(new PlaceDao()); }

    @Override
    public void delete(Place entity) {
        getDao().begin();
        Iterator<User> iU = entity.getUsers().iterator();
        while (iU.hasNext()) {
            User u = iU.next();
            iU.remove();
            u.removePlace(entity);
        }
        Iterator<BusinessActivity> iB = entity.getActivities().iterator();
        while (iB.hasNext()) {
            BusinessActivity b = iB.next();
            iB.remove();
            b.removePlace(entity);
        }
        getDao().delete(entity);
        getDao().commit();


    }
}
