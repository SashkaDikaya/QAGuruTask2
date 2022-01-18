package com.dikayaav.tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage (){
        Selenide.open("https://github.com");
    }

    @Step("Ищем репозиторий {repository}")
    public void searchForRepository (String repository){
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("Переходим в репозиторий {repository}")
    public void openRepositoryPage (String repository){
        $(linkText(repository)).click();
    }

    @Step("Проверяем что открылся репозиторий {repository}")
    public void checkRepositoryName (String repository){
        $("#repository-container-header").shouldHave(text(repository));
    }

    @Step("Проверяем что на странице есть таб  {issues}")
    public void checkIssuesTab (String issues){
        $("#repository-container-header").shouldHave(text(issues));
    }

}
