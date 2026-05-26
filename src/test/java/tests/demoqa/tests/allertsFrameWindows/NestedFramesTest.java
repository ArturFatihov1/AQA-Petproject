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
import tests.demoqa.pages.allertsFrameWindowsPage.NestedFramesPage;
import tests.demoqa.tests.BaseUiTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.switchTo;

@Epic("DemoQA test ui")
@Feature("Alerts, Frame & Windows")
@DisplayName("Тестирование работы с вложенными фреймами")
public class NestedFramesTest extends BaseUiTest {
    NestedFramesPage nestedFramesPage = new NestedFramesPage();

    @AfterAll
    static void close() {
        Selenide.closeWebDriver();
    }

    @BeforeEach
    public void openPage() {
        Selenide.open("nestedframes");
    }

    @Test
    @DisplayName("Проверка навигации по вложенным фреймам (Parent -> Child)")
    @Severity(SeverityLevel.NORMAL)
    public void nestedFramesTest() {
        switchTo().frame(0);
        nestedFramesPage.getTextInFrame().shouldHave(text("Parent frame"));

        switchTo().frame(0);
        nestedFramesPage.getTextInFrame().shouldHave(text("Child Iframe"));

        switchTo().parentFrame();
        nestedFramesPage.getTextInFrame().shouldHave(text("Parent frame"));

        switchTo().defaultContent();
        nestedFramesPage.getTextOutFrame().shouldHave(text("Nested Frames"));
    }
}
