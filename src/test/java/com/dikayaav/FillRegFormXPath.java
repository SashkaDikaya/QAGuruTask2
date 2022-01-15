package com.dikayaav;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class FillRegFormXPath {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @AfterAll
    static void afterAll() {
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillRegForm () {
        open("https://demoqa.com/automation-practice-form");
        $x("//div[@class='practice-form-wrapper']").shouldHave(text("Student Registration Form"));

        $x("//input[@id='firstName']").setValue("Aleksandra");
        $x("//input[@id='lastName']").setValue("Dikaya");
        $x("//input[@id='userEmail']").setValue("dikaya@gmail.com");
        $x("//div[@id='genterWrapper']").$(byText("Female")).click();
        $x("//input[@id='userNumber']").setValue("1236547890");

        $x("//input[@id='dateOfBirthInput']").click();
        $x("//select[@class='react-datepicker__month-select']").selectOption("December");
        $x("//select[@class='react-datepicker__year-select']").selectOption("1987");
        $x("//div[contains(@aria-label, 'December 29th, 1987')]").click();

        $x("//input[@id='subjectsInput']").setValue("Maths").pressEnter();
        $x("//div[@id='hobbiesWrapper']").$(byText("Music")).parent().click();
        $x("//input[@id='uploadPicture']").uploadFromClasspath("img/Alukard.png");
        $x("//*[@id='currentAddress']").setValue("Saint-P, Red kursant, house 4, app 15");
        $x("//div[@id='state']").click();
        $x("//*[@id='stateCity-wrapper']").$(byText("Haryana")).click();
        $x("//div[@id='city']").click();
        $x("//*[@id='stateCity-wrapper']").$(byText("Karnal")).click();

        $x("//button[@id='submit']").click();

        $x("//div[@class='modal-content']").shouldHave(text("Thanks for submitting the form"));
        $x("//div[@class='table-responsive']").shouldHave(text("Aleksandra" + " " + "Dikaya"),
                text("dikaya@gmail.com"),
                text("Female"),
                text("1236547890"),
                text("29 December,1987"),
                text("Maths"),
                text("Music"),
                text("Alukard.png"),
                text("Saint-P, Red kursant, house 4, app 15"),
                text("Haryana" + " " + "Karnal"));

        $x("//button[@id='closeLargeModal']").click();

    }

}
