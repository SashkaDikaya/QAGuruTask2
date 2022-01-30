package com.dikayaav.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

public class SelenideFilesTest {

    @Test
    void downloadTest() throws FileNotFoundException {
        Selenide.open("https://github.com/junit-team/junit5/blob/main/LICENSE.md");
        File downloadFile = Selenide.$("#raw-url").download();
        System.out.println();
    }

}
