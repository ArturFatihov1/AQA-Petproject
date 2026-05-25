package tests.demoqa.pages.interactionPages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Getter
public class DroppablePage {
    private final SelenideElement dragMe = $x("//div[@id='draggable']"),
            droppableSimple = $("#droppable");

    private final SelenideElement acceptable = $("#acceptable"),
            droppable = $("#droppableExample-tabpane-accept .drop-box"),
            acceptButton = $("#droppableExample-tab-accept"),
            notAcceptable = $(byText("Not Acceptable"));

    private final SelenideElement preventPropagation = $("#droppableExample-tab-preventPropogation"),
            dragBox = $x("//div[@id='dragBox']"),
            notGreedy = $x("//div[@id='notGreedyInnerDropBox']"),
            greedy = $x("//div[@id='greedyDropBoxInner']"),
            notGreedyResult = $x("//div[@id='notGreedyDropBox']//p"),
            greedyResult = $x("//div[@id='greedyDropBox']//p");

    private final SelenideElement revert = $("#droppableExample-tab-revertable"),
            revertable = $x("//div[@id='revertable']"),
            notRevertable = $x("//div[@id='notRevertable']"),
            dropHereRevert = $x("//div[@id='revertableDropContainer']//div[@id='droppable']");


    public void clickAccept() {
        acceptButton.click();
    }

    public void clickPrevent() {
        preventPropagation.click();
    }

    public void clickRevert() {
        revert.click();
    }

    public DroppablePage moveElementToElement(SelenideElement moveIt, SelenideElement toIt) {
        moveIt.shouldBe(visible);
        toIt.shouldBe(visible);
        actions()
                .moveToElement(moveIt)
                .pause(200)
                .clickAndHold(moveIt)
                .moveToElement(toIt)
                .release().perform();
        return this;
    }

    public DroppablePage moveElementToLocation(int xCoordinate, int yCoordinate, SelenideElement element) {
        actions()
                .moveToElement(element)
                .pause(200)
                .clickAndHold(element)
                .moveToLocation(xCoordinate, yCoordinate)
                .release()
                .perform();
        return this;
    }
}
