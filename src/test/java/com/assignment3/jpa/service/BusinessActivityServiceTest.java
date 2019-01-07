package com.assignment3.jpa.service;

import com.assignment3.jpa.model.BusinessActivity;
import com.assignment3.jpa.utils.Helper;
import com.assignment3.jpa.utils.ServiceFactory;
import com.assignment3.jpa.utils.faker.BusinessActivityFaker;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BusinessActivityServiceTest {

    private BusinessActivityFaker faker = new BusinessActivityFaker();
    private BusinessActivityService businessActivityService;

    @AfterClass
    public static void dropDb() {
        Helper.dropDatabase();
    }

    @Before
    public void before() {
        Helper.dropDatabase();
        businessActivityService = ServiceFactory.getInstance().getBusinessActivityService();
    }

    private BusinessActivity createBusinessActivityWithCards() {
        BusinessActivity businessActivity = faker.createWithCards(5);
        businessActivityService.create(businessActivity);
        return businessActivity;
    }

    private BusinessActivity createBusinessActivityWithPlace() {
        BusinessActivity businessActivity = faker.createWithPlace();
        businessActivityService.create(businessActivity);
        return businessActivity;
    }

    private BusinessActivity createBusinessActivity() {
        BusinessActivity businessActivity = faker.create();
        businessActivityService.create(businessActivity);
        return businessActivity;
    }

    @Test
    public void create() {
        BusinessActivity businessActivity = createBusinessActivity();
        assertNotNull(businessActivity.getId());
    }

    @Test
    public void read() {
        BusinessActivity businessActivity = createBusinessActivity();
        businessActivity = businessActivityService.read(businessActivity.getId());
        assertNotNull(businessActivity);
        assertNotNull(businessActivity.getName());
        assertNotNull(businessActivity.getType());
    }

    @Test
    public void update() {
        BusinessActivity businessActivity = createBusinessActivity();
        businessActivity.setType("Test");
        businessActivity = businessActivityService.update(businessActivity);
        businessActivity = businessActivityService.read(businessActivity.getId());
        assertEquals(businessActivity.getType(), "Test");
    }

    @Test
    public void readAll() {
        createBusinessActivity();
        createBusinessActivity();
        List<BusinessActivity> list = businessActivityService.readAll();
        assertEquals(list.size(), 2);
    }

    @Test
    public void deleteAll() {
        createBusinessActivity();
        createBusinessActivity();
        createBusinessActivity();
        businessActivityService.deleteAll();
        List<BusinessActivity> list = businessActivityService.readAll();
        assertEquals(list.size(), 0);
    }

    @Test
    public void addPlace() {
        BusinessActivity businessActivity = createBusinessActivityWithPlace();
        assertNotNull(businessActivity.getPlace());
    }

    @Test
    public void removePlace() {
        BusinessActivity businessActivity = createBusinessActivityWithPlace();
        businessActivityService.removePlace(businessActivity);
        businessActivity = businessActivityService.read(businessActivity.getId());
        assertNull(businessActivity.getPlace());
    }

    @Test
    public void addCard() {
        BusinessActivity businessActivity = createBusinessActivityWithCards();
        assertEquals(5, businessActivity.getCards().size());
    }

    @Test
    public void removeCard() {
        BusinessActivity businessActivity = createBusinessActivityWithCards();
        //List<Card> cards = businessActivityService.getCards(businessActivity);
        businessActivityService.removeCard(businessActivity.getCards().get(0));
        //BusinessActivity newBusinessActivity = businessActivityService.read(businessActivity.getId());
        assertEquals(4, businessActivity.getCards().size());
    }

    @Test
    public void removeAllCard() {
        BusinessActivity businessActivity = createBusinessActivityWithCards();
        businessActivityService.removeAllCard(businessActivity);
        businessActivity = businessActivityService.read(businessActivity.getId());
        assertEquals(0, businessActivity.getCards().size());
    }

    @Test
    public void delete() {
        BusinessActivity businessActivity = createBusinessActivityWithCards();
        businessActivityService.delete(businessActivity);
        assertEquals(0, businessActivityService.readAll().size());

    }
}