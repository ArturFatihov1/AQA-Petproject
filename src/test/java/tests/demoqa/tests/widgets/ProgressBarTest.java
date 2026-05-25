package tests.demoqa.tests.widgets;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.demoqa.pages.widgetsPage.ProgressBarPage;
import tests.demoqa.tests.base.BaseUiTest;

import static com.codeborne.selenide.Condition.text;

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
    public void fullProgressTest() {
        progressBarPage.clickStartStop();

        progressBarPage.waitForProgress("100%", 12);

        progressBarPage.getResetButton().shouldHave(text("Reset"));
    }
}
