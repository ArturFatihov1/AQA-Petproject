package tests.demoqa.tests.interactions;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.RetryingTest;
import org.openqa.selenium.Point;
import tests.demoqa.pages.interactionPages.DroppablePage;
import tests.demoqa.tests.BaseUiTest;

import static com.codeborne.selenide.Condition.text;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@Epic("DemoQA test ui")
@Feature("Interactions")
@Story("Droppable")
@DisplayName("Тестирование механизма Drag and Drop")
@Flaky
public class DroppableTest extends BaseUiTest {
    DroppablePage droppablePage = new DroppablePage();

    @Test
    @DisplayName("Простая проверка Drop")
    @Severity(SeverityLevel.NORMAL)
    public void simpleDroppableTest() {
        droppablePage.moveElementToElement(droppablePage.getDragMe(), droppablePage.getDroppableSimple());
        droppablePage.getDroppableSimple().shouldHave(text("Dropped!"));
    }

    @Test
    @DisplayName("Проверка Drop с фильтрацией (Accept)")
    @Severity(SeverityLevel.NORMAL)
    public void acceptDroppableTest() {
        droppablePage.clickAccept();
        droppablePage.moveElementToElement(droppablePage.getNotAcceptable(), droppablePage.getDroppable());
        droppablePage.getDroppable().shouldHave(text("Drop here"));

        droppablePage.moveElementToElement(droppablePage.getAcceptable(), droppablePage.getDroppable());
        droppablePage.getDroppable().shouldHave(text("Dropped!"));
    }

    @RetryingTest(3)
    @Test
    @DisplayName("Проверка распространения событий (Greedy/Not Greedy)")
    @Severity(SeverityLevel.NORMAL)
    public void preventDroppableInnerTest() {
        droppablePage.clickPrevent();
        droppablePage.moveElementToElement(droppablePage.getDragBox(), droppablePage.getNotGreedy());
        droppablePage.getNotGreedyResult().shouldNotHave(text("Outer droppable"));

        droppablePage.moveElementToElement(droppablePage.getDragBox(), droppablePage.getGreedy());
        droppablePage.getGreedyResult().shouldHave(text("Outer droppable"));
    }

    @RetryingTest(3)
    @Test
    @DisplayName("Проверка возврата элемента на место (Revert)")
    @Severity(SeverityLevel.NORMAL)
    public void revertDroppableInnerTest() {
        droppablePage.clickRevert();
        Point revStartLocation = droppablePage.getRevertable().getLocation();
        Point notRevStartLocation = droppablePage.getNotRevertable().getLocation();

        droppablePage.moveElementToElement(droppablePage.getRevertable(), droppablePage.getDropHereRevert());
        droppablePage.moveElementToElement(droppablePage.getNotRevertable(), droppablePage.getDropHereRevert());

        Selenide.sleep(500);

        Point revEndLocation = droppablePage.getRevertable().getLocation();
        Point notRevEndLocation = droppablePage.getNotRevertable().getLocation();

        assertEquals(revStartLocation, revEndLocation, "Элемент должен вернуться на исходную позицию");
        assertNotEquals(notRevStartLocation, notRevEndLocation, "Элемент не должен возвращаться");
    }
}