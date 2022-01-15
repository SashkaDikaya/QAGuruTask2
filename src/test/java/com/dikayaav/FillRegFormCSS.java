package com.dikayaav;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FillRegFormCSS {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @AfterAll
    static void afterAll() {
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void FillRegForm() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        $("#firstName").setValue("Aleksandra");
        $("#lastName").setValue("Dikaya");
        $("#userEmail").setValue("dikaya@gmail.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("1236547890");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("1987");
        //используя not
        //$(".react-datepicker__day--029:not(.react-datepicker__day--outside-month)").click();
        $("[aria-label$='December 24th, 1987']").click(); //$= оканчивается на

        $("#subjectsInput").setValue("maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("img/Alukard.png");
        $("#currentAddress").setValue("Saint-P, Red kursant, house 4, app 15");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();

        $("#submit").click();

        $(".table-responsive").shouldHave(text("Aleksandra" + " " + "Dikaya"),
                text("dikaya@gmail.com"), text("Female"), text("1236547890"), text("29 December,1987"), text("Maths"),
                text("Music"), text("Alukard.png"), text("Saint-P, Red kursant, house 4, app 15"),
                text("Haryana" + " " + "Karnal"));

        $("#closeLargeModal").click();






    }
}
