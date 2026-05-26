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
import tests.demoqa.pages.allertsFrameWindowsPage.FramesPage;
import tests.demoqa.tests.BaseUiTest;

import static com.codeborne.selenide.Selenide.switchTo;

@Epic("DemoQA ui test")
@Feature("Alerts, Frame & Windows")
@DisplayName("Тестирование работы с фреймами")
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
    @DisplayName("Проверка взаимодействия с первым фреймом")
    @Severity(SeverityLevel.NORMAL)
    public void firstFrameTest() {
        switchTo().frame(0);
        framesPage.checkHeading("This is a sample page");

        switchTo().defaultContent();
        framesPage.checkFramesPageTitle("Frames");
    }

    @Test
    @DisplayName("Проверка взаимодействия со вторым фреймом")
    @Severity(SeverityLevel.NORMAL)
    public void secondFrameTest() {
        switchTo().frame(1);
        framesPage.checkHeading("This is a sample page");

        switchTo().defaultContent();
        framesPage.checkFramesPageTitle("Frames");
    }
}
