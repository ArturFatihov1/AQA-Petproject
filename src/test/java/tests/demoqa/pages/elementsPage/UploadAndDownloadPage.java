package tests.demoqa.pages.elementsPage;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class UploadAndDownloadPage {
    private final SelenideElement download = $("#downloadButton"),
            uploadFile = $("#uploadFile"),
            uploadedFilePath = $("#uploadedFilePath");

    @Step("Скачать файл со страницы")
    public File download() {
        Configuration.fileDownload = FileDownloadMode.FOLDER;
        return download.download();
    }

    @Step("Загрузить файл из ресурсов: {file}")
    public void uploadFile(String file) {
        uploadFile.uploadFromClasspath(file);
    }
}