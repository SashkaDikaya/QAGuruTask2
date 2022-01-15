package com.dikayaav.tests;

import com.codeborne.selenide.Configuration;
import com.dikayaav.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        Configuration.holdBrowserOpen = true;
    }

    RegistrationPage registrationPage = new RegistrationPage();

}
