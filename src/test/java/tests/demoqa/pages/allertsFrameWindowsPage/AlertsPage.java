package tests.demoqa.pages.allertsFrameWindowsPage;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class AlertsPage {
    private final SelenideElement alertButton = $("#alertButton"),
            timerAlertButton = $("#timerAlertButton"),
            confirmButton = $("#confirmButton"),
            promptButton = $("#promtButton"),
            confirmResult = $("#confirmResult"),
            promptResult = $("#promptResult");

    public void clickAlert() {
        alertButton.click();
    }

    public void clickTimerAlert() {
        timerAlertButton.click();
    }

    public void clickConfirm() {
        confirmButton.click();
    }

    public void clickPrompt() {
        promptButton.click();
    }
}
