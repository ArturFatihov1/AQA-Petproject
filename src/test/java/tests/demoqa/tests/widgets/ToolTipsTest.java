package tests.demoqa.tests.widgets;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junitpioneer.jupiter.RetryingTest;
import tests.demoqa.pages.widgetsPage.ToolTipsPage;
import tests.demoqa.tests.base.BaseUiTest;

import static com.codeborne.selenide.Condition.text;

public class ToolTipsTest extends BaseUiTest {

    ToolTipsPage toolTipsPage = new ToolTipsPage();

    @AfterAll
    static void close() {
        Selenide.closeWebDriver();
    }

    @BeforeEach
    public void openPage() {
        Selenide.open("tool-tips");
    }

    @RetryingTest(3)
    void toolTipsTest() {

        toolTipsPage.hoverButton()
                .getResult()
                .shouldHave(text("You hovered over the Button"));

        toolTipsPage.hoverField()
                .getResult()
                .shouldHave(text("You hovered over the text field"));

        toolTipsPage.hoverText()
                .getResult()
                .shouldHave(text("You hovered over the Contrary"));

        toolTipsPage.hoverDigit()
                .getResult()
                .shouldHave(text("You hovered over the 1.10.32"));
    }
}
