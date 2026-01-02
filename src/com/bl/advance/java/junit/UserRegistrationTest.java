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
        boolean result = registration.uc3("abcd.ab@bl.co");
        Assert.assertEquals(true, result);
    }

    @Test // UC3 with error
    public void givenMail_WhenImProperly_ShouldReturnFalse() {
        UserRegistration registration = new UserRegistration();
        boolean result = registration.uc3("abcd@co.ac");
        Assert.assertEquals(false, result);
    }

    @Test // UC4
    public void givenPhone_WhenProperly_ShouldReturnTrue() {
        UserRegistration registration = new UserRegistration();
        boolean result = registration.uc4("91 1234567890");
        Assert.assertEquals(true, result);
    }

    @Test // UC4 invalid case 1
    public void givenPhone_WhenImProperly1_ShouldReturnFalse() {
        UserRegistration registration = new UserRegistration();
        boolean result = registration.uc4("90 123456789");
        Assert.assertEquals(false, result);
    }

    @Test // UC4 invalid case 2
    public void givenPhone_WhenImProperly2_ShouldReturnFalse() {
        UserRegistration registration = new UserRegistration();
        boolean result = registration.uc4("91 12345789");
        Assert.assertEquals(false, result);
    }

    @Test // UC5
    public void givenPassword_WhenProperly_ShouldReturnTrue() {
        UserRegistration registration = new UserRegistration();
        boolean result = registration.uc5("hello1234");
        Assert.assertEquals(true, result);
    }

    @Test // UC5
    public void givenPassword_WhenImProperly_ShouldReturnFalse() {
        UserRegistration registration = new UserRegistration();
        boolean result = registration.uc5("hel4");
        Assert.assertEquals(false, result);
    }

    @Test // UC6
    public void givenPasswordWithAtleast1Captial_WhenProperly_ShouldReturnTrue() {
        UserRegistration registration = new UserRegistration();
        boolean result = registration.uc6("Hello1234");
        Assert.assertEquals(true, result);
    }

    @Test // UC6
    public void givenPasswordWithAtleast1Captial_WhenImProperly_ShouldReturnFalse() {
        UserRegistration registration = new UserRegistration();
        boolean result = registration.uc6("hello1234");
        Assert.assertEquals(false, result);
    }

    @Test // UC7
    public void givenPasswordWithAtleast1Numeric_WhenProperly_ShouldReturnTrue() {
        UserRegistration registration = new UserRegistration();
        boolean result = registration.uc7("Hello1234");
        Assert.assertEquals(true, result);
    }

    @Test // UC7
    public void givenPasswordWithAtleast1Numeric_WhenImProperly_ShouldReturnFalse() {
        UserRegistration registration = new UserRegistration();
        boolean result = registration.uc7("helloHello");
        Assert.assertEquals(false, result);
    }

    @Test // UC8
    public void givenPasswordWithAtleast1SplCharacter_WhenProperly_ShouldReturnTrue() {
        UserRegistration registration = new UserRegistration();
        boolean result = registration.uc8("Hello@1234");
        Assert.assertEquals(true, result);
    }

    @Test // UC8
    public void givenPasswordWithAtleast1SplCharacter_WhenImProperly_ShouldReturnFalse() {
        UserRegistration registration = new UserRegistration();
        boolean result = registration.uc8("hello12345");
        Assert.assertEquals(false, result);
    }
}
