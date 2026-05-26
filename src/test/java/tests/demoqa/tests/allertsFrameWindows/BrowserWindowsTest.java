package tests.demoqa.tests.allertsFrameWindows;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WindowType;
import tests.demoqa.pages.allertsFrameWindowsPage.BrowserWindowsPage;
import tests.demoqa.tests.BaseUiTest;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

@Epic("DemoQA test ui")
@Feature("Alerts, Frame & Windows")
@DisplayName("Тестирование работы с окнами и вкладками браузера")
public class BrowserWindowsTest extends BaseUiTest {
    BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage();

    @AfterAll
    static void close() {
        Selenide.closeWebDriver();
    }

    @BeforeEach
    public void openPage() {
        Selenide.open("browser-windows");
    }

    @Test
    @DisplayName("Проверка открытия новой вкладки")
    @Severity(SeverityLevel.NORMAL)
    public void clickNewTabTest() {
        browserWindowsPage.newTab();
        switchTo().window(1);
        webdriver().shouldHave(url("https://demoqa.com/sample"));
    }

    @Test
    @DisplayName("Проверка открытия нового окна браузера")
    @Severity(SeverityLevel.NORMAL)
    public void clickNewWindowsTest() {
        browserWindowsPage.newWindow();
        switchTo().newWindow(WindowType.WINDOW);
        webdriver().shouldHave(url("about:blank"));
    }

    @Disabled
    @Test
    @DisplayName("Проверка окна с сообщением")
    @Severity(SeverityLevel.MINOR)
    public void clickNewWindowMessageTest() {
        browserWindowsPage.messageWindows();
        switchTo().window(1);
        browserWindowsPage.getBody().shouldHave(text("Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization."), Duration.ofSeconds(10));
    }
}
