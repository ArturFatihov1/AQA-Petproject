package tests.demoqa.pages.widgetsPage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class SelectMenuPage {
    private final SelenideElement selectValueField = $("#withOptGroup"),
            selectOneField = $("#selectOne"),
            oldSelectMenu = $("#oldSelectMenu"),
            standardMultiSelect = $("#cars");

    private final SelenideElement multiSelectField = $x("//div[contains(., 'Multiselect drop down')]/following-sibling::div//div[contains(@class, 'indicatorContainer')]");

    private final SelenideElement activeMenuContainer = $("[class$='-menu']");

    @Step("Выбрать значение из выпадающего списка: {optionText}")
    public SelectMenuPage selectValue(String optionText) {
        selectValueField.click();
        activeMenuContainer.$(byText(optionText)).click();
        return this;
    }

    @Step("Выбрать титул: {optionText}")
    public SelectMenuPage selectOne(String optionText) {
        selectOneField.click();
        activeMenuContainer.$(byText(optionText)).click();
        return this;
    }

    @Step("Выбрать значение из классического списка (Old Select): {value}")
    public SelectMenuPage oldSelect(String value) {
        oldSelectMenu.selectOptionByValue(value);
        return this;
    }

    @Step("Выбрать автомобиль из мульти-селекта: {value}")
    public SelectMenuPage standardMultiSelect(String value) {
        standardMultiSelect.selectOptionByValue(value.toLowerCase());
        return this;
    }

    @Step("Добавить цвет в мульти-селект: {color}")
    public SelectMenuPage multiSelectOption(String color) {
        multiSelectField.click();
        activeMenuContainer.$(byText(color)).click();
        $("h1").click();
        return this;
    }

    @Step("Удалить цвет из мульти-селекта: {color}")
    public SelectMenuPage multiSelectRemoveOption(String color) {
        $x(String.format("//div[text()='%s']/following-sibling::div", color)).click();
        return this;
    }

    @Step("Удалить все цвета из мульти-селекта")
    public SelectMenuPage multiSelectRemoveAll() {
        multiSelectField.$("svg path[d^='M14.348']").parent().parent().click();
        return this;
    }
}