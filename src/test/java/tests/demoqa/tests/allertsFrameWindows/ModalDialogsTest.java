package tests.demoqa.tests.allertsFrameWindows;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.demoqa.pages.allertsFrameWindowsPage.ModalDialogPage;
import tests.demoqa.tests.BaseUiTest;

import static com.codeborne.selenide.Condition.text;

@Epic("DemoQA test ui")
@Feature("Alerts, Frame & Windows")
@DisplayName("Тестирование работы с модальными окнами")
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
    @DisplayName("Проверка отображения содержимого маленького модального окна")
    @Severity(SeverityLevel.NORMAL)
    public void smallModalTest() {
        modalDialogPage.clickSmallModal();

        modalDialogPage.getSmallModalHeader().shouldHave(text("Small Modal"));
        modalDialogPage.getModalBody().shouldHave(text("This is a small modal. It has very less content"));
    }

    @Test
    @DisplayName("Проверка отображения содержимого большого модального окна")
    @Severity(SeverityLevel.NORMAL)
    public void largeModalTest() {
        modalDialogPage.clickLargeModal();

        modalDialogPage.getLargeModalHeader().shouldHave(text("Large Modal"));
        modalDialogPage.getModalBody().shouldHave(text("Lorem Ipsum"));
    }
}
