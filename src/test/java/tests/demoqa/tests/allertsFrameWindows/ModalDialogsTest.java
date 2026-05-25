package tests.demoqa.tests.allertsFrameWindows;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.demoqa.pages.allertsFrameWindowsPage.ModalDialogPage;
import tests.demoqa.tests.base.BaseUiTest;

import static com.codeborne.selenide.Condition.text;

public class ModalDialogsTest extends BaseUiTest {
    ModalDialogPage modalDialogPage = new ModalDialogPage();

    @AfterAll
    static void close() {
        Selenide.closeWebDriver();
    }

    @BeforeEach
    public void openPage() {
        Selenide.open("modal-dialogs");
    }

    @Test
    public void smallModalTest() {
        modalDialogPage.clickSmallModal();

        modalDialogPage.getSmallModalHeader().shouldHave(text("Small Modal"));
        modalDialogPage.getModalBody().shouldHave(text("This is a small modal. It has very less content"));
    }

    @Test
    public void largeModalTest() {
        modalDialogPage.clickLargeModal();

        modalDialogPage.getLargeModalHeader().shouldHave(text("Large Modal"));
        modalDialogPage.getModalBody().shouldHave(text("Lorem Ipsum"));
    }
}
