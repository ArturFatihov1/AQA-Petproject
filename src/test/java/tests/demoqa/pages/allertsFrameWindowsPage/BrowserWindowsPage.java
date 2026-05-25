package tests.demoqa.pages.allertsFrameWindowsPage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class BrowserWindowsPage {
    private final SelenideElement tabButton = $("#tabButton"),
            windowButton = $("#windowButton"),
            messageWindowButton = $("#messageWindowButton"),
            body = $("body");

    @Step("Нажать на кнопку открытия новой вкладки")
    public void newTab() {
        tabButton.click();
    }

    @Step("Нажать на кнопку открытия нового окна")
    public void newWindow() {
        windowButton.click();
    }

    @Step("Нажать на кнопку открытия окна с сообщением")
    public void messageWindows() {
        messageWindowButton.click();
    }
}
