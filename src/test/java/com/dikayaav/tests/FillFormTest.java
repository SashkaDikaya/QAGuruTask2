package com.dikayaav.tests;

import org.junit.jupiter.api.Test;

import static com.dikayaav.tests.TestData.*;

public class FillFormTest extends TestBase{

    @Test
    void fillRegFormTest () {

        registrationPage.openPage();
        registrationPage
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(email)
                .selectGenderButton(femaleGender)
                .typePhoneNumber(phone)
                .calendarComponents.setDate(day, month, year);
        registrationPage.typeSubject(subject)
                .typeHobbie(hobbie)
                .pressUploadPictureButton(picture)
                .typeAddress(address)
                .pressStateDDList()
                .setStateValue(state)
                .pressCityDDList()
                .setStateValue(city)
                .pressSubmitButton();

       registrationPage.checkResultsValue("Student name", firstName + " " + lastName)
                .checkResultsValue("Student Email", email)
                .checkResultsValue("Gender", femaleGender)
                .checkResultsValue("Mobile", phone)
                .checkResultsValue("Date of Birth", day + " " + month + "," + year)
                .checkResultsValue("Subjects", subject)
                .checkResultsValue("Hobbies", hobbie)
                .checkResultsValue("Picture", "Alukard.png")
                .checkResultsValue("Address", address)
                .checkResultsValue("State and City", state + " " + city);
    }
}
