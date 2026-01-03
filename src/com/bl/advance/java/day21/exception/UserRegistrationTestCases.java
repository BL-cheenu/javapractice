package com.bl.advance.java.day21.exception;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UserRegistrationTestCases {
    @Test // UC1
    public void givenFirstName_WhenProperly_ShouldReturnTrue() {
        UserRegistrationWithExceptionHandling registration = new UserRegistrationWithExceptionHandling();
        Assert.assertTrue(registration.uc1("Abcde"));
    }

    @Test // UC1
    public void givenFirstName_WhenImproperly_ShouldReturnFalse() {
        UserRegistrationWithExceptionHandling registration = new UserRegistrationWithExceptionHandling();
        Assert.assertFalse(registration.uc1("Ab"));
    }

    @Test // UC2
    public void givenLastName_WhenProperly_ShouldReturnTrue() {
        UserRegistrationWithExceptionHandling registration = new UserRegistrationWithExceptionHandling();
        Assert.assertTrue(registration.uc2("Abcde Abcd"));
    }

    @Test // UC2
    public void givenLastName_WhenImproperly_ShouldReturnFalse() {
        UserRegistrationWithExceptionHandling registration = new UserRegistrationWithExceptionHandling();
        Assert.assertFalse(registration.uc2("Abcd Ab"));
    }

    @Test // UC3 mandatory
    public void givenMail_WhenProperly_ShouldReturnTrue() {
        UserRegistrationWithExceptionHandling registration = new UserRegistrationWithExceptionHandling();
        Assert.assertTrue(registration.uc3("abcd@bl.co"));
    }

    @Test // UC3 mandatory with optional
    public void givenMailWithOptional_WhenProperly_ShouldReturnTrue() {
        UserRegistrationWithExceptionHandling registration = new UserRegistrationWithExceptionHandling();
        Assert.assertTrue(registration.uc3("abcd.ab@bl.co"));
    }

    @Test // UC3 with error
    public void givenMail_WhenImProperly_ShouldReturnFalse() {
        UserRegistrationWithExceptionHandling registration = new UserRegistrationWithExceptionHandling();
        Assert.assertFalse(registration.uc3("abcd@co.ac"));
    }

    @Test // UC4
    public void givenPhone_WhenProperly_ShouldReturnTrue() {
        UserRegistrationWithExceptionHandling registration = new UserRegistrationWithExceptionHandling();
        Assert.assertTrue(registration.uc4("91 1234567890"));
    }

    @Test // UC4 invalid case 1
    public void givenPhone_WhenImProperly1_ShouldReturnFalse() {
        UserRegistrationWithExceptionHandling registration = new UserRegistrationWithExceptionHandling();
        Assert.assertFalse(registration.uc4("90 123456789"));
    }

    @Test // UC4 invalid case 2
    public void givenPhone_WhenImProperly2_ShouldReturnFalse() {
        UserRegistrationWithExceptionHandling registration = new UserRegistrationWithExceptionHandling();
        Assert.assertFalse(registration.uc4("91 12345789"));
    }

    @Test // UC5
    public void givenPassword_WhenProperly_ShouldReturnTrue() {
        UserRegistrationWithExceptionHandling registration = new UserRegistrationWithExceptionHandling();
        Assert.assertTrue(registration.uc5("hello1234"));
    }

    @Test // UC5
    public void givenPassword_WhenImProperly_ShouldReturnFalse() {
        UserRegistrationWithExceptionHandling registration = new UserRegistrationWithExceptionHandling();
        Assert.assertFalse(registration.uc5("hel4"));
    }

    @Test // UC6
    public void givenPasswordWithAtleast1Captial_WhenProperly_ShouldReturnTrue() {
        UserRegistrationWithExceptionHandling registration = new UserRegistrationWithExceptionHandling();
        Assert.assertTrue(registration.uc6("Hello1234"));
    }

    @Test // UC6
    public void givenPasswordWithAtleast1Captial_WhenImProperly_ShouldReturnFalse() {
        UserRegistrationWithExceptionHandling registration = new UserRegistrationWithExceptionHandling();
        Assert.assertFalse(registration.uc6("hello1234"));
    }

    @Test // UC7
    public void givenPasswordWithAtleast1Numeric_WhenProperly_ShouldReturnTrue() {
        UserRegistrationWithExceptionHandling registration = new UserRegistrationWithExceptionHandling();
        Assert.assertTrue(registration.uc7("Hello1234"));
    }

    @Test // UC7
    public void givenPasswordWithAtleast1Numeric_WhenImProperly_ShouldReturnFalse() {
        UserRegistrationWithExceptionHandling registration = new UserRegistrationWithExceptionHandling();
        Assert.assertFalse(registration.uc7("helloHello"));
    }

    @Test // UC8
    public void givenPasswordWithAtleast1SplCharacter_WhenProperly_ShouldReturnTrue() {
        UserRegistrationWithExceptionHandling registration = new UserRegistrationWithExceptionHandling();
        Assert.assertTrue(registration.uc8("Hello@1234"));
    }

    @Test // UC8
    public void givenPasswordWithAtleast1SplCharacter_WhenImProperly_ShouldReturnFalse() {
        UserRegistrationWithExceptionHandling registration = new UserRegistrationWithExceptionHandling();
        Assert.assertFalse(registration.uc8("hello12345"));
    }

    @Test // UC9
    public void givenValidEmails_ShouldReturnTrue() {
        Assert.assertTrue(UserRegistrationWithExceptionHandling.uc9("abc@yahoo.com"));
        Assert.assertTrue(UserRegistrationWithExceptionHandling.uc9("abc-100@yahoo.com"));
        Assert.assertTrue(UserRegistrationWithExceptionHandling.uc9("abc.100@yahoo.com"));
        Assert.assertTrue(UserRegistrationWithExceptionHandling.uc9("abc111@abc.com"));
        Assert.assertTrue(UserRegistrationWithExceptionHandling.uc9("abc-100@abc.net"));
        Assert.assertTrue(UserRegistrationWithExceptionHandling.uc9("abc.100@abc.com.au"));
        Assert.assertTrue(UserRegistrationWithExceptionHandling.uc9("abc@1.com"));
        Assert.assertTrue(UserRegistrationWithExceptionHandling.uc9("abc@gmail.com"));
        Assert.assertTrue(UserRegistrationWithExceptionHandling.uc9("abc+100@gmail.com"));
    }

    // INVALID EMAILS
    @Test // Uc9
    public void givenInvalidEmails_ShouldReturnFalse() {
        Assert.assertFalse(UserRegistrationWithExceptionHandling.uc9("abc"));
        Assert.assertFalse(UserRegistrationWithExceptionHandling.uc9("abc@.com.my"));
        Assert.assertFalse(UserRegistrationWithExceptionHandling.uc9("abc123@gmail.a"));
        Assert.assertFalse(UserRegistrationWithExceptionHandling.uc9("abc123@.com"));
        Assert.assertFalse(UserRegistrationWithExceptionHandling.uc9("abc123@.com.com"));
        Assert.assertFalse(UserRegistrationWithExceptionHandling.uc9(".abc@abc.com"));
        Assert.assertFalse(UserRegistrationWithExceptionHandling.uc9("abc()*@gmail.com"));
        Assert.assertFalse(UserRegistrationWithExceptionHandling.uc9("abc@%*.com"));
        Assert.assertFalse(UserRegistrationWithExceptionHandling.uc9("abc..2002@gmail.com"));
        Assert.assertFalse(UserRegistrationWithExceptionHandling.uc9("abc.@gmail.com"));
        Assert.assertFalse(UserRegistrationWithExceptionHandling.uc9("abc@abc@gmail.com"));
        Assert.assertFalse(UserRegistrationWithExceptionHandling.uc9("abc@gmail.com.1a"));
        Assert.assertFalse(UserRegistrationWithExceptionHandling.uc9("abc@gmail.com.au.au"));
    }
}
