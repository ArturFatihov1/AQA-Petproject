package tests.demoqa.pages.allertsFrameWindowsPage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
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

    @Step("Нажать на кнопку вызова простого Alert")
    public void clickAlert() {
        alertButton.click();
    }

    @Step("Нажать на кнопку вызова Alert с таймером")
    public void clickTimerAlert() {
        timerAlertButton.click();
    }

    @Step("Нажать на кнопку вызова Confirm Alert")
    public void clickConfirm() {
        confirmButton.click();
    }

    @Step("Нажать на кнопку вызова Prompt Alert")
    public void clickPrompt() {
        promptButton.click();
    }
}
