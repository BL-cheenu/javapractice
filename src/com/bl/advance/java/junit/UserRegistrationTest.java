package com.bl.advance.java.junit;

import com.bl.advance.java.regex.UserRegistration;
import org.junit.Assert;
import org.junit.Test;

public class UserRegistrationTest {
    @Test // UC1
    public void givenFirstName_WhenProperly_ShouldReturnTrue() {
        UserRegistration registration = new UserRegistration();
        boolean result = registration.uc1("Abcde");
        Assert.assertEquals(true, result);
    }

    @Test // UC1
    public void givenFirstName_WhenImproperly_ShouldReturnFalse() {
        UserRegistration registration = new UserRegistration();
        boolean result = registration.uc1("Ab");
        Assert.assertEquals(false, result);
    }

    @Test // UC2
    public void givenLastName_WhenProperly_ShouldReturnTrue() {
        UserRegistration registration = new UserRegistration();
        boolean result = registration.uc2("Abcde Abcd");
        Assert.assertEquals(true, result);
    }

    @Test // UC2
    public void givenLastName_WhenImproperly_ShouldReturnFalse() {
        UserRegistration registration = new UserRegistration();
        boolean result = registration.uc2("Abcd Ab");
        Assert.assertEquals(false, result);
    }

    @Test // UC3 mandatory
    public void givenMail_WhenProperly_ShouldReturnTrue() {
        UserRegistration registration = new UserRegistration();
        boolean result = registration.uc3("abcd@bl.co");
        Assert.assertEquals(true, result);
    }

    @Test // UC3 mandatory with optional
    public void givenMailWithOptional_WhenProperly_ShouldReturnTrue() {
        UserRegistration registration = new UserRegistration();
        boolean result = registration.uc3("abcd.ab@bl.co.in");
        Assert.assertEquals(true, result);
    }

    @Test // UC3 with error
    public void givenMail_WhenImProperly_ShouldReturnTrue() {
        UserRegistration registration = new UserRegistration();
        boolean result = registration.uc3("abcd@co.ac");
        Assert.assertEquals(false, result);
    }
}
