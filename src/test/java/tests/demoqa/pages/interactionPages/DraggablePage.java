package tests.demoqa.pages.interactionPages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.*;

@Getter
public class DraggablePage {

    private final SelenideElement axisRestricted = $x("//button[text()='Axis Restricted']"),
            containerRestricted = $x("//button[text()='Container Restricted']"),
            cursorStyle = $x("//button[text()='Cursor Style']");

    private final SelenideElement dragMe = $x("//div[@id='dragBox']"),
            onlyX = $x("//div[@id='restrictedX']"),
            onlyY = $x("//div[@id='restrictedY']"),
            containingInBox = $x("//div[@id='containmentWrapper']//div[contains(text(),'contained within the box')]"),
            box = $("#containmentWrapper"),
            containingInParent = $x("//span[contains(text(),'contained within my parent')]"),
            parent = $x("//span[contains(text(),'contained within my parent')]/.."),
            cursorCenter = $x("//div[@id='cursorCenter']"),
            cursorTopLeft = $x("//div[@id='cursorTopLeft']"),
            cursorBottom = $x("//div[@id='cursorBottom']");

    @Step("Перетащить элемент на {xOffset}px по X и {yOffset}px по Y")
    public DraggablePage moveElementByOffSet(int xOffset, int yOffset, SelenideElement element) {
        actions()
                .moveToElement(element)
                .pause(200)
                .clickAndHold(element)
                .moveByOffset(xOffset, yOffset)
                .release().perform();
        return this;
    }

    @Step("Перетащить элемент в координаты ({xCoordinate}, {yCoordinate})")
    public DraggablePage moveElementToLocation(int xCoordinate, int yCoordinate, SelenideElement element) {
        actions()
                .moveToElement(element)
                .pause(200)
                .clickAndHold(element)
                .moveToLocation(xCoordinate, yCoordinate)
                .release().perform();
        return this;
    }

    @Step("Перейти во вкладку 'Axis Restricted'")
    public DraggablePage openAxisRestricted() {
        axisRestricted.click();
        return this;
    }

    @Step("Перейти во вкладку 'Container Restricted'")
    public DraggablePage openContainerRestricted() {
        containerRestricted.click();
        return this;
    }

    @Step("Перейти во вкладку 'Cursor Style'")
    public DraggablePage openCursorStyle() {
        cursorStyle.click();
        return this;
    }

    public String getDragMeEndPosition() {
        return dragMe.getAttribute("style");
    }

    public String getOnlyXEndPosition() {
        return onlyX.getAttribute("style");
    }

    public String getOnlyYEndPosition() {
        return onlyY.getAttribute("style");
    }

}