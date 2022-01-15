package com.dikayaav.pages;

import com.codeborne.selenide.SelenideElement;
import com.dikayaav.pages.components.CalendarComponents;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderRadioButton = $("#genterWrapper"),
            phoneNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            addressInput = $("#currentAddress"),
            pictureUploadButton = $("#uploadPicture"),
            stateDDList = $("#state"),
            stateCityWrapper =  $("#stateCity-wrapper"),
            cityDDList = $("#city"),
            submitButton = $("#submit"),
            resultsTable = $(".table-responsive");

    public CalendarComponents calendarComponents = new CalendarComponents();

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
    }

    public RegistrationPage typeFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage typeLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage typeUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }

    public RegistrationPage selectGenderButton(String gender) {
        genderRadioButton.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage typePhoneNumber(String phoneNumber) {
        phoneNumberInput.setValue(phoneNumber);
        return this;
    }

    public RegistrationPage typeSubject(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage typeHobbie(String hobbie) {
        hobbiesWrapper.$(byText(hobbie)).click();
        return this;
    }

    public RegistrationPage typeAddress(String address) {
        addressInput.setValue(address);
        return this;
    }

    public RegistrationPage pressUploadPictureButton(String picture) {
        pictureUploadButton.uploadFromClasspath(picture);
        return this;
    }

    public RegistrationPage pressStateDDList() {
        stateDDList.click();
        return this;
    }

    public RegistrationPage setStateValue(String state) {
        stateCityWrapper.$(byText(state)).click();
        return this;
    }

    public RegistrationPage pressCityDDList() {
        cityDDList.click();
        return this;
    }

    public RegistrationPage pressSubmitButton() {
        submitButton.click();
        return this;
    }

    public RegistrationPage checkResultsValue(String key, String value) {
        resultsTable.shouldHave(text(key))
                .parent().shouldHave(text(value));
        return this;
    }

}
