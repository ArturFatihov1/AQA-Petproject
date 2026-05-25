package tests.demoqa.pages.interactionPages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class SelectablePage {
    private final SelenideElement tabList = $("#demo-tab-list"),
            tabGrid = $("#demo-tab-grid");
    private final ElementsCollection listItems = $$(".list-group-item"),
            listItemsGrid = $$("#gridContainer li");

    public SelenideElement getItemByIndex(int index) {
        return listItems.get(index);
    }

    public SelenideElement getItemByIndexGrid(int index) {
        return listItemsGrid.get(index);
    }

    @Step("Выбрать элемент списка под индексом {index}")
    public void clickElement(int index) {
        getItemByIndex(index).click();
    }

    @Step("Выбрать элемент сетки под индексом {index}")
    public void clickElementGrid(int index) {
        getItemByIndexGrid(index).click();
    }

    @Step("Открыть вкладку Grid")
    public void openGridTab() {
        tabGrid.click();
    }
}
