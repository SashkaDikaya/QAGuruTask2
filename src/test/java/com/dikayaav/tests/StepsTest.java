package com.dikayaav.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest {

    private static final String REPOSITORY = "SashkaDikaya/QAGuruTask2";

    @Test
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

        step("Проверяем что открылся репозиторий" + REPOSITORY, () -> {
            $("#repository-container-header").shouldHave(text(REPOSITORY));

        });

        step("Проверяем что на странице есть таб Issues", () -> {
            $("#issues-tab").shouldHave(text("Issues"));

        });


        $("#issues-tab").click();

    }

    @Test
    public void annotatedStepsTest() {
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchForRepository("SashkaDikaya/QAGuruTask2");
        steps.openRepositoryPage("SashkaDikaya/QAGuruTask2");
        steps.checkRepositoryName("SashkaDikaya/QAGuruTask2");
        steps.checkIssuesTab("Issues");
    }



}
