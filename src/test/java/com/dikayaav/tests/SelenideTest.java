package com.dikayaav.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {

    @Test
    void WebTest() {
        Selenide.open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("SashkaDikaya/QAGuruTask2");
        $(".header-search-input").submit();
        $(linkText("SashkaDikaya/QAGuruTask2")).click();
        $("#repository-container-header").shouldHave(text("SashkaDikaya/QAGuruTask2"));
        $("#issues-tab").shouldHave(text("Issues"));
        $("#issues-tab").click();


    }
}
