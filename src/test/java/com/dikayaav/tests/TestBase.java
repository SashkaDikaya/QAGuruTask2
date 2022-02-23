package com.dikayaav.tests;

import com.codeborne.selenide.Configuration;
import com.dikayaav.config.CredentialsConfig;
import com.dikayaav.helper.Attach;
import com.dikayaav.pages.RegistrationPage;
import com.github.javafaker.Faker;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {



    @BeforeAll
    static void setUp() {

        CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

        String login = config.login();
        String password = config.password();

        String browser = System.getProperty("browser", "chrome");
        String version = System.getProperty("version", "91");
        String size = System.getProperty("size", "1920x1080");
        String remoteUrl = System.getProperty("remoteUrl", "selenoid.autotests.cloud/wd/hub");

        Configuration.baseUrl = "https://demoqa.com";

        String url = "https://" + login + ":" + password + "@" + remoteUrl;
        Configuration.remote = url;
        Configuration.browser = browser;
        Configuration.browserVersion = version;
        Configuration.browserSize = size;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

        Attach.attachAsText("Browser: ", browser);
        Attach.attachAsText("Version: ", version);
        Attach.attachAsText("Remote Url: ", remoteUrl);
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }

    RegistrationPage registrationPage = new RegistrationPage();
    static Faker faker = new Faker(new Locale("ru"));


}
