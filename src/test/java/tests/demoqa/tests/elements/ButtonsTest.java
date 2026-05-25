package tests.demoqa.tests.elements;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.RetryingTest;
import tests.demoqa.pages.elementsPage.ButtonsPage;
import tests.demoqa.tests.BaseUiTest;

import static com.codeborne.selenide.Condition.text;

@Epic("DemoQA ui test")
@Feature("Elements")
@DisplayName("Тестирование различных типов нажатий на кнопки")
@Flaky
public class ButtonsTest extends BaseUiTest {
    ButtonsPage buttonsPage = new ButtonsPage();

    @AfterAll
    static void close() {
        Selenide.closeWebDriver();
    }

    @BeforeEach
    public void openPage() {
        Selenide.open("buttons");
    }

    @RetryingTest(3)
    @Test
    @DisplayName("Проверка двойного клика")
    @Severity(SeverityLevel.NORMAL)
    public void doubleClickTest() {
        buttonsPage.doubleClick();
        buttonsPage.getDoubleClickMessage().shouldHave(text("You have done a double click"));
    }

    @RetryingTest(3)
    @Test
    @DisplayName("Проверка правого клика")
    @Severity(SeverityLevel.NORMAL)
    public void rightClickTest() {
        buttonsPage.rightClick();
        buttonsPage.getRightClickMessage().shouldHave(text("You have done a right click"));
    }

    @Test
    @DisplayName("Проверка динамического клика")
    @Severity(SeverityLevel.NORMAL)
    public void clickTest() {
        buttonsPage.click();
        buttonsPage.getClickMessage().shouldHave(text("You have done a dynamic click"));
    }

}
