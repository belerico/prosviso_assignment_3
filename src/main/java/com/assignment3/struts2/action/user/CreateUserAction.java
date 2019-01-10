package com.assignment3.struts2.action.user;

import com.assignment3.jpa.model.Place;
import com.assignment3.jpa.model.User;
import com.assignment3.jpa.service.ServiceFactory;
import com.assignment3.utils.faker.UserFaker;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CreateUserAction extends ActionSupport implements Preparable, ModelDriven<User> {

    private static SimpleDateFormat DATE_FORMAT;
    private static Date MIN_DATE;
    private static Date MAX_DATE;

    static {
        DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
        try {
            MIN_DATE = DATE_FORMAT.parse("01/01/1900");
            MAX_DATE = DATE_FORMAT.parse(DATE_FORMAT.format(new Date()));
        } catch (ParseException p) {
            p.printStackTrace();
        }
    }

    private String typedDateOfBirth;
    private Long placeId;
    private List<Place> places;
    private User user = new UserFaker().create();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTypedDateOfBirth() {
        return typedDateOfBirth;
    }

    public void setTypedDateOfBirth(String typedDateOfBirth) {
        this.typedDateOfBirth = typedDateOfBirth;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public String createUserPage() {
        prepare();
        return ActionSupport.SUCCESS;
    }

    public String createUser() throws ParseException {
        getUser().setDateOfBirth(DATE_FORMAT.parse(getTypedDateOfBirth()));
        getUser().addPlace(ServiceFactory.getInstance().getPlaceService().read(getPlaceId()));
        ServiceFactory.getInstance().getUserService().create(getUser());
        return ActionSupport.SUCCESS;
    }

    private boolean isDateOfBirthValid(String dateOfBirth) {
        Date typedDate;
        try {
            typedDate = DATE_FORMAT.parse(dateOfBirth);
        } catch (ParseException p) {
            return false;
        }
        return !typedDate.before(MIN_DATE) && !typedDate.after(MAX_DATE);
    }

    private boolean isEmailValid(String email) {
        return ServiceFactory.getInstance().getUserService().findUserByEmail(email) == null;
    }

    @Override
    public void validate() {
        if (!isEmailValid(getUser().getEmail()))
            addFieldError("user.email", "User with " + getUser().getEmail() + " email is already registered");
        if (!isDateOfBirthValid(getTypedDateOfBirth()))
            addFieldError("typedDateOfBirth", "Could not parse date, please enter a date in the format dd/mm/yyyy and between 01/01/1990 and current date");
    }

    @Override
    public void prepare() {
        setTypedDateOfBirth(DATE_FORMAT.format(getUser().getDateOfBirth()));
        setPlaces(ServiceFactory.getInstance().getPlaceService().readAll());
    }

    @Override
    public User getModel() {
        return user;
    }
}
