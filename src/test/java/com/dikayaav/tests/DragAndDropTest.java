package com.dikayaav.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class DragAndDropTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void DragNDropTest () {
        Selenide.open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement elementA = $("div #column-a");
        SelenideElement elementB = $("div #column-b");
        $(elementA).dragAndDropTo(elementB);
        elementA.shouldHave(text("B"));
        elementB.shouldHave(text("A"));

    }
}
