package tests.demoqa.pages.allertsFrameWindowsPage;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class ModalDialogPage {
    private final SelenideElement showSmallModal = $("#showSmallModal"),
            showLargeModal = $("#showLargeModal"),
            modalBody = $(".modal-body"),
            smallModalHeader = $("#example-modal-sizes-title-sm"),
            largeModalHeader = $("#example-modal-sizes-title-lg");

    public void clickSmallModal() {
        showSmallModal.click();
    }

    public void clickLargeModal() {
        showLargeModal.click();
    }
}
