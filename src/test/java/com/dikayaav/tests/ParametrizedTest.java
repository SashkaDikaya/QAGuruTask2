package com.dikayaav.tests;

import com.codeborne.selenide.Selenide;
import com.dikayaav.pages.WebSteps;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ParametrizedTest {


    @ValueSource(strings = {"eroshenkoam/allure-example", "SashkaDikaya/QAGuruTask2"})
    @ParameterizedTest(name = "Открытие первой Issue в репозитории : {0}")
    public void parametrizedAnnotatedStepsTest(String testData) {
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchForRepository(testData);
        steps.openRepositoryPage(testData);
        steps.checkIssuesTab("Issues");
        steps.pressIssuesTab("Issues");
        steps.openFirstIssue();
        steps.attachPageSource();
    }

    @ValueSource(strings = {"task1", "task2", "task3", "task5"})
    @ParameterizedTest(name = "Проверка наличия файла .gitignore в бранче : {0}")
    public void checkBranchTest(String branch) {
        Selenide.open("https://github.com/SashkaDikaya/QAGuruTask2");
        $("#branch-select-menu").click();
        $("div[data-target='ref-selector.listContainer']").$(byText(branch)).click();
        $("[role=grid]").shouldHave(text(".gitignore"));
    }

    @CsvSource(value = {
            "AnnotatedStepsTest.java, QAGuruTask2/tree/task6",
            "FillFormTest.java, QAGuruTask11/tree/master"
    })
    @ParameterizedTest(name = "Проверка наличия класса: {0}")
    public void checkRepoTest(String test, String repo) {
        Selenide.open("https://github.com/SashkaDikaya/" + repo + "/src/test/java/com/dikayaav/tests");
        $("[role=grid]").shouldHave(text(test));
    }

}


