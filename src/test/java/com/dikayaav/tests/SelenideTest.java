package com.dikayaav.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTest {

    @Test
    @Owner("dikayaav")
    @Feature("Issue")
    @Story("Проверка Issue в репозитории eroshenkoam/allure-example")
    @DisplayName("Check issue in repository eroshenkoam/allure-example")
    @Severity(SeverityLevel.BLOCKER)

    void WebTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Selenide.open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("eroshenkoam/allure-example");
        $(".header-search-input").submit();
        $(linkText("eroshenkoam/allure-example")).click();
        Allure.addAttachment("Page Source", "text/html", WebDriverRunner.source(), "html");
        $(partialLinkText("Issues")).click();
        $(withText("#53")).should(Condition.visible);

    }
}
