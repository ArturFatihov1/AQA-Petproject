package tests.demoqa.pages.widgetsPage;

import com.codeborne.selenide.SelenideElement;
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

    // Замени в Page Object эту строку на:
    private final SelenideElement multiSelectField = $x("//div[contains(., 'Multiselect drop down')]/following-sibling::div//div[contains(@class, 'indicatorContainer')]");

    private final SelenideElement activeMenuContainer = $("[class$='-menu']");

    public SelectMenuPage selectValue(String optionText) {
        selectValueField.click();
        activeMenuContainer.$(byText(optionText)).click();
        return this;
    }

    public SelectMenuPage selectOne(String optionText) {
        selectOneField.click();
        activeMenuContainer.$(byText(optionText)).click();
        return this;
    }

    public SelectMenuPage oldSelect(String value) {
        oldSelectMenu.selectOptionByValue(value);
        return this;
    }

    public SelectMenuPage standardMultiSelect(String value) {
        standardMultiSelect.selectOptionByValue(value.toLowerCase());
        return this;
    }

    public SelectMenuPage multiSelectOption(String color) {
        multiSelectField.click();
        activeMenuContainer.$(byText(color)).click();
        $("h1").click();
        return this;
    }

    public SelectMenuPage multiSelectRemoveOption(String color) {
        $x(String.format("//div[text()='%s']/following-sibling::div", color)).click();
        return this;
    }

    public SelectMenuPage multiSelectRemoveAll() {
        multiSelectField.$("svg path[d^='M14.348']").parent().parent().click();
        return this;
    }

    public SelenideElement getOldSelectResult() {
        return oldSelectMenu.getSelectedOption();
    }

    public SelenideElement getStandardMultiSelectResult() {
        return standardMultiSelect.getSelectedOption();
    }
}