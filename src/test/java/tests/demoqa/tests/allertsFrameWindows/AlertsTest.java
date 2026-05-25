package tests.demoqa.tests.allertsFrameWindows;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import tests.demoqa.pages.allertsFrameWindowsPage.AlertsPage;
import tests.demoqa.tests.base.BaseUiTest;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.switchTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlertsTest extends BaseUiTest {
    AlertsPage alertsPage = new AlertsPage();

    @AfterAll
    static void close() {
        Selenide.closeWebDriver();
    }

    @BeforeEach
    public void openPage() {
        Selenide.open("alerts");
    }

    @Test
    public void clickAlertButtonTest() {
        alertsPage.clickAlert();
        Alert alert = switchTo().alert();
        assertEquals("You clicked a button", alert.getText());
        alert.accept();
    }

    @Test
    public void clickTimerAlertTest() {
        alertsPage.clickTimerAlert();
        Alert alert = switchTo().alert(Duration.ofSeconds(6));
        assertEquals("This alert appeared after 5 seconds", alert.getText());
        alert.accept();
    }

    @Test
    public void clickConfirmAlertTest() {
        alertsPage.clickConfirm();
        Alert alert = switchTo().alert();
        assertEquals("Do you confirm action?", alert.getText());
        alert.accept();
        alertsPage.getConfirmResult().shouldHave(text("You selected Ok"));
    }

    @Test
    public void promptAlertTest() {
        alertsPage.clickPrompt();
        Alert alert = switchTo().alert();
        String prompt = "Hello world";
        alert.sendKeys(prompt);
        alert.accept();
        alertsPage.getPromptResult().shouldHave(text("You entered"), text(prompt));
    }
}
