package tests.demoqa.tests.elements;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.demoqa.pages.elementsPage.UploadAndDownloadPage;
import tests.demoqa.tests.base.BaseUiTest;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UploadAndDownloadTest extends BaseUiTest {
    UploadAndDownloadPage uploadAndDownloadPage = new UploadAndDownloadPage();

    @AfterAll
    static void close() {
        Selenide.closeWebDriver();
    }

    @BeforeEach
    public void openPage() {
        Selenide.open("upload-download");
    }

    @Test
    public void downloadFileTest() {
        File file = uploadAndDownloadPage.download();
        assertTrue(file.exists());
        assertEquals("sampleFile.jpeg", file.getName());
    }

    @Test
    public void uploadFileTest() {
        String file = "testFile.txt";
        uploadAndDownloadPage.uploadFile(file);
        uploadAndDownloadPage.getUploadedFilePath().shouldHave(text("C:\\fakepath\\" + file));
    }
}
