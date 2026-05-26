package tests.demoqa.tests.widgets;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.demoqa.pages.widgetsPage.ProgressBarPage;
import tests.demoqa.tests.BaseUiTest;

import static com.codeborne.selenide.Condition.text;

@Epic("DemoQA test ui")
@Feature("Widgets")
@Story("Progress Bar")
@DisplayName("Тестирование виджета Progress Bar")
public class ProgressBarTest extends BaseUiTest {
    ProgressBarPage progressBarPage = new ProgressBarPage();

    @AfterAll
    static void close() {
        Selenide.closeWebDriver();
    }

    @BeforeEach
    public void openPage() {
        Selenide.open("progress-bar");
    }

    @Test
    @DisplayName("Проверка достижения 100% прогресса")
    @Severity(SeverityLevel.NORMAL)
    public void fullProgressTest() {
        progressBarPage.clickStartStop();
        progressBarPage.waitForProgress("100%", 12);
        progressBarPage.getResetButton().shouldHave(text("Reset"));
    }
}