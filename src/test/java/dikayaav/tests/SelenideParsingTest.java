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
    void parseTests() throws Exception {

        ZipFile zipFile = new ZipFile("src/test/resources/Downloads.zip");

        ZipEntry zipPdfEntry = zipFile.getEntry("programmirov.pdf");
        try (InputStream inputPdfStream = zipFile.getInputStream(zipPdfEntry)) {
            PDF parsed = new PDF(inputPdfStream);
            assertThat(parsed.author).contains("Yakov Fain");
            assertThat(parsed.numberOfPages).isEqualTo(231);
            assertThat(parsed.text).contains("BoxLayout - расположение по горизонтали или вертикали");
        }

        ZipEntry zipXlsEntry = zipFile.getEntry("sample-xlsx-file.xlsx");
        try (InputStream inputXlsStream = zipFile.getInputStream(zipXlsEntry)) {
            XLS parsed = new XLS(inputXlsStream);
            assertThat(parsed.excel.getSheetAt(0).getRow(3).getCell(4).getStringCellValue())
                    .isEqualTo("France");
            assertThat(parsed.excel.getSheetAt(0).getRow(22).getCell(1).getStringCellValue())
                    .isEqualTo("Holly");
        }

        ZipEntry zipCsvEntry = zipFile.getEntry("sample.csv");
        try (InputStream inputCsvStream = zipFile.getInputStream(zipCsvEntry)) {
            CSVReader reader = new CSVReader(new InputStreamReader(inputCsvStream));
            List<String[]> list = reader.readAll();
            assertThat(list)
                    .hasSize(51)
                    .contains(
                            new String[]{"0;First Name;Last Name;Gender;Country;Age;Date;Id"},
                            new String[]{"33;Jona;Grindle;Female;Great Britain;26;21/05/2015;6458"},
                            new String[]{"50;Rasheeda;Alkire;Female;United States;29;16/08/2016;6125"});
        }
    }
}






