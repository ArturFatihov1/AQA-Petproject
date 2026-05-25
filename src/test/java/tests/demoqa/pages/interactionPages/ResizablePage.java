package tests.demoqa.pages.interactionPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;

@Getter
public class ResizablePage {
    private final SelenideElement resizeableBox = $x("//div[@id='resizableBoxWithRestriction']//span"),
            resizeableBoxResult = $x("//div[@id='resizableBoxWithRestriction']"),
            resizeable = $x("//div[@id='resizable']//span"),
            resizeableResult = $x("//div[@id='resizable']");

    @Step("Изменить размер элемента смещением на {xOffset} по X и {yOffset} по Y")
    public ResizablePage moveElementByOffSet(int xOffset, int yOffset, SelenideElement element) {
        element.shouldBe(Condition.visible);
        actions()
                .moveToElement(element)
                .pause(200)
                .clickAndHold(element)
                .moveByOffset(xOffset, yOffset)
                .release().perform();
        return this;
    }
}
