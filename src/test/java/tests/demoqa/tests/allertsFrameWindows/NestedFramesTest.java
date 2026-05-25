package tests.demoqa.tests.allertsFrameWindows;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.demoqa.pages.allertsFrameWindowsPage.NestedFramesPage;
import tests.demoqa.tests.base.BaseUiTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.switchTo;

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
