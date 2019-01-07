package com.assignment3.jpa.utils;

import com.assignment3.jpa.service.BusinessActivityService;
import com.assignment3.jpa.service.CardService;
import com.assignment3.jpa.service.PlaceService;
import com.assignment3.jpa.service.UserService;

public class ServiceFactory {

    private static ServiceFactory instance;
    private CardService cardService;
    private UserService userService;
    private BusinessActivityService businessActivityService;
    private PlaceService placeService;

    private ServiceFactory() {
        cardService = new CardService();
        userService = new UserService();
        businessActivityService = new BusinessActivityService();
        placeService = new PlaceService();
    }

    public static synchronized ServiceFactory getInstance() {
        if (instance == null) {
            instance = new ServiceFactory();
        }
        return instance;
    }

    public CardService getCardService() {
        return cardService;
    }

    public UserService getUserService() {
        return userService;
    }

    public BusinessActivityService getBusinessActivityService() {
        return businessActivityService;
    }

    public PlaceService getPlaceService() {
        return placeService;
    }
}
