package tests.demoqa.tests.interactions;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.demoqa.pages.interactionPages.SortablePage;
import tests.demoqa.tests.BaseUiTest;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

@Epic("DemoQA test ui")
@Feature("Interactions")
@Story("Sortable")
@DisplayName("Тестирование сортировки элементов (Sortable)")
public class SortableTest extends BaseUiTest {

    SortablePage sortablePage = new SortablePage();

    @AfterAll
    static void close() {
        closeWebDriver();
    }

    @BeforeEach
    void openPage() {
        open("sortable");
    }

    @Test
    @DisplayName("Проверка сортировки элементов в списке")
    @Severity(SeverityLevel.NORMAL)
    public void tabListMoveOneToTwoTest() {
        sortablePage.moveElement(sortablePage.getOneElement(), sortablePage.getTwoElement());
    }

    @Test
    @DisplayName("Проверка сортировки элементов в сетке (Grid)")
    @Severity(SeverityLevel.NORMAL)
    public void tabGridMoveOneToTwoTest() {
        sortablePage.openGridTab();
        sortablePage.moveElement(sortablePage.getOneGridElement(), sortablePage.getTwoGridElement());
    }
}