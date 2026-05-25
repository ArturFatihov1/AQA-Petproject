package tests.demoqa.tests.interactions;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.demoqa.pages.interactionPages.SelectablePage;
import tests.demoqa.tests.base.BaseUiTest;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class SelectableTest extends BaseUiTest {

    SelectablePage selectablePage = new SelectablePage();

    @AfterAll
    static void close() {
        closeWebDriver();
    }

    @BeforeEach
    void openPage() {
        open("selectable");
    }

    @Test
    public void selectElementsInListTest() {
        selectablePage.clickElement(0);
        selectablePage.clickElement(1);

        selectablePage.getItemByIndex(0).shouldHave(cssClass("active"));
        selectablePage.getItemByIndex(1).shouldHave(cssClass("active"));
    }

    @Test
    public void unSelectElementsInListTest() {
        selectablePage.clickElement(0);
        selectablePage.clickElement(1);

        selectablePage.getItemByIndex(0).shouldHave(cssClass("active"));
        selectablePage.getItemByIndex(1).shouldHave(cssClass("active"));

        selectablePage.clickElement(1);
        selectablePage.getItemByIndex(1).shouldNot(cssClass("active"));
    }

    @Test
    public void selectElementsInGridTest() {
        selectablePage.openGridTab();

        selectablePage.clickElementGrid(0);
        selectablePage.clickElementGrid(1);

        selectablePage.getItemByIndexGrid(0).shouldHave(cssClass("active"));
        selectablePage.getItemByIndexGrid(1).shouldHave(cssClass("active"));

        selectablePage.clickElementGrid(1);
        selectablePage.getItemByIndexGrid(1).shouldNot(cssClass("active"));
    }
}
