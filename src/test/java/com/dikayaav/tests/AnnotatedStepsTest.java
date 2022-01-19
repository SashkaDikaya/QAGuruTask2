package com.dikayaav.tests;

import com.dikayaav.pages.WebSteps;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnnotatedStepsTest {

    @Test
    @Owner("dikayaav")
    @Feature("Issue")
    @Story("Проверка Issue в репозитории eroshenkoam/allure-example")
    @DisplayName("Check issue in repository eroshenkoam/allure-example")
    @Severity(SeverityLevel.BLOCKER)

    public void annotatedStepsTest() {
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchForRepository("eroshenkoam/allure-example");
        steps.openRepositoryPage("eroshenkoam/allure-example");
        steps.checkIssuesTab("Issues");
        steps.pressIssuesTab("Issues");
        steps.checkIssue("#53");
        steps.attachPageSource();
    }
}
