package tests.demoqa.tests.allertsFrameWindows;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.demoqa.pages.allertsFrameWindowsPage.FramesPage;
import tests.demoqa.tests.base.BaseUiTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.switchTo;

public class FramesTest extends BaseUiTest {
    FramesPage framesPage = new FramesPage();

    @AfterAll
    static void close() {
        Selenide.closeWebDriver();
    }

    @BeforeEach
    public void openPage() {
        Selenide.open("frames");
    }

    @Test
    public void firstFrameTest() {
        switchTo().frame(0);
        framesPage.getSampleHeading().shouldHave(text("This is a sample page"));

        switchTo().defaultContent();
        framesPage.getFrames().shouldHave(text("Frames"));
    }

    @Test
    public void secondFrameTest() {
        switchTo().frame(1);
        framesPage.getSampleHeading().shouldHave(text("This is a sample page"));

        switchTo().defaultContent();
        framesPage.getFrames().shouldHave(text("Frames"));
    }
}
