package dikayaav.tests;


import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static org.assertj.core.api.Assertions.assertThat;


public class SelenideParsingTest {


    //private ClassLoader cl = getClass().getClassLoader();

    @Test
    void parseCsvTest() throws Exception {

        ZipFile zipFile = new ZipFile("src/test/resources/Downloads.zip");

        ZipEntry zipPdfEntry = zipFile.getEntry("programmirov.pdf");
        try (InputStream inputPdfStream = zipFile.getInputStream(zipPdfEntry)) {
            PDF parsed = new PDF(inputPdfStream);
            assertThat(parsed.author).contains("Yakov Fain");
            assertThat(parsed.numberOfPages).isEqualTo(231);
            assertThat(parsed.text).contains("BoxLayout - расположение по горизонтали или вертикали");
        }
    }

   /* @Test
    void parsePdfTest() throws Exception {
        Selenide.open("https://junit.org/junit5/docs/current/user-guide/");
        File pdfDownload = $(byText("PDF download")).download();
        PDF parsed = new PDF(pdfDownload); //еще создаем переменную для распарсенного файла
        assertThat(parsed.author).contains("Marc Philip");
    }

    @Test
    void parseXlsTest() throws Exception {
        try (InputStream stream = cl.getResourceAsStream("sample-xlsx-file.xlsx")) {
            XLS parsed = new XLS(stream);
            assertThat(parsed.excel.getSheetAt(0).getRow(1).getCell(2).getStringCellValue())
                    .isEqualTo("Abril");
        }
    }

    @Test
    void parseCsvTest() throws Exception {
        try (InputStream stream = cl.getResourceAsStream("example.csv")) {
            CSVReader reader = new CSVReader(new InputStreamReader(stream));
            List<String[]> list = reader.readAll();
            assertThat(list)
                    .hasSize(3)
                    .contains(
                            new String[]{"Author", "Book"},
                            new String[]{"Block", "Apteka"},
                            new String[]{"Esenin", "Cherniy Chelovek"}
                    );
        }
    }

    @Test
    void parsedZipTest() throws Exception {
        try (InputStream stream = cl.getResourceAsStream("sample-zip-file.zip");
             ZipInputStream zis = new ZipInputStream(stream)) {
            ZipEntry zipEntry;
            while ((zipEntry = zis.getNextEntry()) != null) {
                assertThat(zipEntry.getName()).isEqualTo("sample.txt");


            }
        }*/

}






