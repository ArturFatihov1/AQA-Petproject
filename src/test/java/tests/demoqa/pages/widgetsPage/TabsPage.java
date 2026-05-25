package tests.demoqa.pages.widgetsPage;

import com.codeborne.selenide.SelenideElement;
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

    public TabsPage openTabWhat() {
        tabWhat.click();
        return this;
    }

    public TabsPage openTabOrigin() {
        tabOrigin.click();
        return this;
    }

    public TabsPage openTabUse() {
        tabUse.click();
        return this;
    }

}
