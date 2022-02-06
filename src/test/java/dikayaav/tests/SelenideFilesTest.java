package dikayaav.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class SelenideFilesTest {



    @Test
    void downloadTest() throws Exception {
        Selenide.open("https://github.com/junit-team/junit5/blob/main/LICENSE.md");
        File downloadFile = $("#raw-url").download(); //кладем скаченный файл в пременную с типом File

        try (InputStream is = new FileInputStream(downloadFile)) {
            assertThat(new String(is.readAllBytes(), StandardCharsets.UTF_8)).contains("Eclipse Public License - v 2.0");

        }
    }

    @Test
    void uploadFile() {
        Selenide.open("https://the-internet.herokuapp.com/upload");
        $("input[type=file]").uploadFromClasspath("upload.txt");
        $("#file-submit").click();
        $("#uploaded-files").shouldHave(text("upload.txt"));

    }




}
