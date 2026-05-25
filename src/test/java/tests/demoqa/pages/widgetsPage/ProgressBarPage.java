package tests.demoqa.pages.widgetsPage;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class ProgressBarPage {
    private final SelenideElement startStop = $("#startStopButton"),
            progressBar = $("#progressBar"),
            resetButton = $("#resetButton");

    public void clickStartStop() {
        startStop.click();
    }

    public void waitForProgress(String expectedPercentage, int timeoutSeconds) {
        progressBar.shouldHave(text(expectedPercentage), Duration.ofSeconds(timeoutSeconds));
    }
}
