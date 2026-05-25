package tests.demoqa.pages.interactionPages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

@Getter
public class SortablePage {
    private final SelenideElement tabList = $("#demo-tab-list"),
            oneElement = $("[data-handler-id=\"T0\"]"),
            twoElement = $("[data-handler-id=\"T2\"]");

    private final SelenideElement tabGrid = $("#demo-tab-grid"),
            oneGridElement = $("[data-handler-id=\"T12\"]"),
            twoGridElement = $("[data-handler-id=\"T14\"]");

    @Step("Открыть вкладку Grid")
    public void openGridTab() {
        tabGrid.click();
    }

    @Step("Переместить элемент на позицию другого элемента")
    public SortablePage moveElement(SelenideElement moveIt, SelenideElement toIt) {
        actions()
                .clickAndHold(moveIt)
                .moveToElement(toIt)
                .release()
                .perform();
        return this;
    }
}