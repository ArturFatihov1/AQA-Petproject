package tests.demoqa.pages.widgetsPage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class ProgressBarPage {
    private final SelenideElement startStop = $("#startStopButton"),
            progressBar = $("#progressBar"),
            resetButton = $("#resetButton");

    @Step("Нажать кнопку Start/Stop")
    public void clickStartStop() {
        startStop.click();
    }

    @Step("Ожидание прогресса {expectedPercentage}% в течение {timeoutSeconds} секунд")
    public void waitForProgress(String expectedPercentage, int timeoutSeconds) {
        progressBar.shouldHave(text(expectedPercentage), Duration.ofSeconds(timeoutSeconds));
    }
}