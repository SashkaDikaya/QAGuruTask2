package com.dikayaav.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaStepsTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int NUMBER = 53;

    @Test
    @Owner("dikayaav")
    @Feature("Issue")
    @Story("Проверка Issue в репозитории" + REPOSITORY)
    @DisplayName("Check issue in repository " + REPOSITORY)
    @Severity(SeverityLevel.BLOCKER)

    void lambdaStepsTest() {

        step("Открываем главную страницу", () -> {
            Selenide.open("https://github.com");
        });

        step("Ищем репозиторий" + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Переходим в репозиторий" + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Проверяем что на странице есть таб Issues", () -> {
            $("#issues-tab").shouldHave(text("Issues"));
        });

        step("Открываем таб Issues", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("Проверяем наличие Issue с номером " + NUMBER, () -> {
            $(withText("#" + NUMBER)).should(Condition.visible);
            Allure.addAttachment("Page Source", "text/html", WebDriverRunner.source(), "html");
        });
    }
}
