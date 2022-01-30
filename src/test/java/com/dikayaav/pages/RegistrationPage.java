package com.dikayaav.pages;

import com.codeborne.selenide.SelenideElement;
import com.dikayaav.pages.components.CalendarComponents;
import io.qameta.allure.Step;

import java.io.File;

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
            //pictureUploadButton = $("#uploadPicture"),
            pictureUploadButton = $("input[type='file']"),
            stateDDList = $("#react-select-3-input"),
            cityDDList = $("#react-select-4-input"),
            submitButton = $("#submit"),
            resultsTable = $(".table-responsive");

    public CalendarComponents calendarComponents = new CalendarComponents();

    @Step("Открытие формы регистрации")
    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
    }

    @Step("Ввод имени")
    public RegistrationPage typeFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    @Step("Ввод фамилии")
    public RegistrationPage typeLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    @Step("Ввод емэйла")
    public RegistrationPage typeUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }

    @Step("Выбор пола")
    public RegistrationPage selectGenderButton(String gender) {
        genderRadioButton.$(byText(gender)).click();
        return this;
    }

    @Step("Ввод номера телефона")
    public RegistrationPage typePhoneNumber(String phoneNumber) {
        phoneNumberInput.setValue(phoneNumber);
        return this;
    }

    @Step("Ввод предметов")
    public RegistrationPage typeSubject(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    @Step("Выбор хобби")
    public RegistrationPage typeHobbie(String hobbie) {
        hobbiesWrapper.$(byText(hobbie)).click();
        return this;
    }

    @Step("Ввод адреса")
    public RegistrationPage typeAddress(String address) {
        addressInput.setValue(address);
        return this;
    }

    @Step("Загрузка фото")
    public RegistrationPage pressUploadPictureButton(String picture) {
        //pictureUploadButton.uploadFromClasspath(picture);
        pictureUploadButton.uploadFile(new File("src/test/resources/img/Alukard.jpg"));
        return this;
    }

    @Step("Выбор штата")
    public RegistrationPage setStateValue(String state) {
        stateDDList.setValue(state).pressEnter();
        return this;
    }

    @Step("Выбор города")
    public RegistrationPage setCityValue(String city) {
        cityDDList.setValue(city).pressEnter();
        return this;
    }

    @Step("Утверждение формы")
    public RegistrationPage pressSubmitButton() {
        submitButton.click();
        return this;
    }

    @Step("Проверка заполненных данных")
    public RegistrationPage checkResultsValue(String key, String value) {
        resultsTable.shouldHave(text(key))
                .parent().shouldHave(text(value));
        return this;
    }

}
