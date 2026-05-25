package tests.demoqa.pages.elementsPage;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class UploadAndDownloadPage {
    private final SelenideElement download = $("#downloadButton"),
            uploadFile = $("#uploadFile"),
            uploadedFilePath = $("#uploadedFilePath");

    public File download() {
        Configuration.fileDownload = FileDownloadMode.FOLDER;

        return download.download();
    }

    public void uploadFile(String file) {
        uploadFile.uploadFromClasspath(file);
    }
}
