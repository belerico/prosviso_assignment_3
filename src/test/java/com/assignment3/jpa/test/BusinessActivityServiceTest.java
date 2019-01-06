package com.assignment3.jpa.test;

import com.assignment3.jpa.Helper;
import com.assignment3.jpa.model.BusinessActivity;
import com.assignment3.jpa.service.BusinessActivityService;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BusinessActivityServiceTest {

    private static Faker faker;
    private static BusinessActivityService businessActivityService;

    @BeforeAll
    static void before() {
        Helper.dropDatabase();
        Helper.resetIdAutoIncrement(BusinessActivity.class);
        faker = new Faker(new Locale("it"));
        businessActivityService = new BusinessActivityService();
    }

    @AfterAll
    static void tearDown() {
        businessActivityService.getDao().close();
    }

    private BusinessActivity createBusinessActivity() {
        BusinessActivity businessActivity = new BusinessActivity();
        businessActivity.setName(faker.company().name());
        businessActivity.setType(faker.company().profession());
        businessActivityService.create(businessActivity);
        return businessActivity;
    }

    @Test
    void create() {
        BusinessActivity businessActivity = createBusinessActivity();
        assertNotNull(businessActivity.getId());
    }

    @Test
    void read() {
        BusinessActivity businessActivity = businessActivityService.read(1L);
        assertNotNull(businessActivity);
        assertNotNull(businessActivity.getName());
        assertNotNull(businessActivity.getType());
    }

    @Test
    void update() {
        BusinessActivity businessActivity = businessActivityService.read(1L);
        businessActivity.setType("Test");
        businessActivity = businessActivityService.update(businessActivity);
        assertEquals(businessActivity.getType(), "Test");
    }

    @Test
    void readAll() {
    }

    @Test
    void deleteAll() {
    }

    @Test
    void addPlace() {
    }

    @Test
    void removePlace() {
    }

    @Test
    void addCard() {
    }

    @Test
    void removeCard() {
    }

    @Test
    void removeAllCard() {
    }

    @Test
    void delete() {
    }
}