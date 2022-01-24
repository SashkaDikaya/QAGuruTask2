package com.dikayaav.tests;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.dikayaav.tests.TestData.*;

public class FillFormTest extends TestBase{

    @Test
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
                .typeHobbie(hobbie);
                //.pressUploadPictureButton(picture)
                //File file = new File("src/test/resources/img/Alukard.jpg");
                //$("[class*='form-control-file']").uploadFile(file);
        registrationPage.typeAddress(randomAddress)
                .pressStateDDList()
                .setStateValue(state)
                .pressCityDDList()
                .setStateValue(city)
                .pressSubmitButton();

       registrationPage.checkResultsValue("Student name", randomFirstName + " " + randomLastName)
                .checkResultsValue("Student Email", email)
                .checkResultsValue("Gender", femaleGender)
                .checkResultsValue("Mobile", randomPhoneNumber)
                .checkResultsValue("Date of Birth", day + " " + month + "," + year)
                .checkResultsValue("Subjects", subject)
                .checkResultsValue("Hobbies", hobbie)
                .checkResultsValue("Picture", "Alukard.jpg")
                .checkResultsValue("Address", randomAddress)
                .checkResultsValue("State and City", state + " " + city);
    }
}
