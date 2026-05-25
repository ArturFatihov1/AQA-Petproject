package tests.demoqa.pages.widgetsPage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class TabsPage {
    private final SelenideElement tabWhat = $("#demo-tab-what"),
            bodyWhat = $("#demo-tabpane-what"),
            tabOrigin = $("#demo-tab-origin"),
            bodyOrigin = $("#demo-tabpane-origin"),
            tabUse = $("#demo-tab-use"),
            bodyUse = $("#demo-tabpane-use");

    @Step("Открыть вкладку 'What'")
    public TabsPage openTabWhat() {
        tabWhat.click();
        return this;
    }

    @Step("Открыть вкладку 'Origin'")
    public TabsPage openTabOrigin() {
        tabOrigin.click();
        return this;
    }

    @Step("Открыть вкладку 'Use'")
    public TabsPage openTabUse() {
        tabUse.click();
        return this;
    }
}