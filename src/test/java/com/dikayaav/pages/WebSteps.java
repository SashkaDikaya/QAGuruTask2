package com.dikayaav.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

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

    @Step("Проверяем что на странице есть таб  {issues}")
    public void checkIssuesTab (String issues){
        $("#repository-container-header").shouldHave(text(issues));
    }

    @Step("Нажимаем на таб  {issues}")
    public void pressIssuesTab (String issues){
        $(partialLinkText(issues)).click();
    }

    @Step("Проверяем наличие Issue {num}")
    public void openFirstIssue (){
        $x("//a[contains(@id, 'issue_')]").click();
    }

    @Attachment(value = "Screenshot", type = "text/html", fileExtension = "html")
    public byte[] attachPageSource() {
        return WebDriverRunner.source().getBytes(StandardCharsets.UTF_8);
    }



}
