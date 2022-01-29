package com.dikayaav.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.dikayaav.tests.TestData.*;

public class FillFormTest extends TestBase{

    @Test
    @Tag("properties")
    void fillRegFormTest () {

        registrationPage.openPage();
        registrationPage
                .typeFirstName(randomFirstName)
                .typeLastName(randomLastName)
                .typeUserEmail(email)
                .selectGenderButton(femaleGender)
                .typePhoneNumber(randomPhoneNumber)
                .calendarComponents.setDate(day, month, year);
        registrationPage.typeSubject(subject)
                .typeHobbie(hobbie)
                //.pressUploadPictureButton(picture)
                .typeAddress(randomAddress)
                .setStateValue(state)
                .setCityValue(city)
                .pressSubmitButton();

       registrationPage.checkResultsValue("Student name", randomFirstName + " " + randomLastName)
                .checkResultsValue("Student Email", email)
                .checkResultsValue("Gender", femaleGender)
                .checkResultsValue("Mobile", randomPhoneNumber)
                .checkResultsValue("Date of Birth", day + " " + month + "," + year)
                .checkResultsValue("Subjects", subject)
                .checkResultsValue("Hobbies", hobbie)
                //.checkResultsValue("Picture", "Alukard.jpg")
                .checkResultsValue("Address", randomAddress)
                .checkResultsValue("State and City", state + " " + city);
    }
}
