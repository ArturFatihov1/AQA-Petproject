package tests.demoqa.tests.elements;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.demoqa.pages.elementsPage.UploadAndDownloadPage;
import tests.demoqa.tests.base.BaseUiTest;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("DemoQA test ui")
@Feature("Elements")
@Story("Upload and Download")
@DisplayName("Тестирование операций с файлами")
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
    @DisplayName("Проверка скачивания файла")
    @Severity(SeverityLevel.NORMAL)
    public void downloadFileTest() {
        File file = uploadAndDownloadPage.download();
        assertTrue(file.exists(), "Файл должен быть скачан");
        assertEquals("sampleFile.jpeg", file.getName());
    }

    @Test
    @DisplayName("Проверка загрузки файла на сервер")
    @Severity(SeverityLevel.NORMAL)
    public void uploadFileTest() {
        String fileName = "testFile.txt";
        uploadAndDownloadPage.uploadFile(fileName);
        uploadAndDownloadPage.getUploadedFilePath().shouldHave(text("C:\\fakepath\\" + fileName));
    }
}