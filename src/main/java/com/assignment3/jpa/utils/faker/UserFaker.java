package com.assignment3.jpa.utils.faker;

import com.assignment3.jpa.model.User;

public class UserFaker extends AbstractFaker<User> {

    @Override
    public User create() {
        User user = new User();
        user.setName(getFaker().name().firstName());
        user.setSurname(getFaker().name().lastName());
        user.setDateOfBirth(getFaker().date().birthday());
        user.setEmail(getFaker().internet().safeEmailAddress());
        user.setPassword(getFaker().internet().password());
        user.setSex(getFaker().random().nextBoolean());
        return user;
    }
}
