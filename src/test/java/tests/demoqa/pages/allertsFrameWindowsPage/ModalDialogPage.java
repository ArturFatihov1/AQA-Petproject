package tests.demoqa.pages.allertsFrameWindowsPage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class ModalDialogPage {
    private final SelenideElement showSmallModal = $("#showSmallModal"),
            showLargeModal = $("#showLargeModal"),
            modalBody = $(".modal-body"),
            smallModalHeader = $("#example-modal-sizes-title-sm"),
            largeModalHeader = $("#example-modal-sizes-title-lg");

    @Step("Открыть маленькое модальное окно")
    public void clickSmallModal() {
        showSmallModal.click();
    }

    @Step("Открыть большое модальное окно")
    public void clickLargeModal() {
        showLargeModal.click();
    }
}
