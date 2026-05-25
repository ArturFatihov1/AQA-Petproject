package tests.demoqa.pages.allertsFrameWindowsPage;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class BrowserWindowsPage {
    private final SelenideElement tabButton = $("#tabButton"),
            windowButton = $("#windowButton"),
            messageWindowButton = $("#messageWindowButton"),
            body = $("body");

    public void newTab() {
        tabButton.click();
    }

    public void newWindow() {
        windowButton.click();
    }

    public void messageWindows() {
        messageWindowButton.click();
    }
}
