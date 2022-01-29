package com.dikayaav.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import java.io.File;

public class SelenideFilesTest {

    @Test
    void downloadTest(){
        File downloadFile = Selenide.$("#raw-url").download();
    }

}
