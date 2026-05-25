package tests.demoqa.pages.elementsPage;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

@Getter
@NoArgsConstructor
public class ButtonsPage {
    private final SelenideElement doubleClick = $("#doubleClickBtn"),
            rightClick = $("#rightClickBtn"),
            click = $(byText("Click Me")),
            doubleClickMessage = $("#doubleClickMessage"),
            rightClickMessage = $("#rightClickMessage"),
            clickMessage = $("#dynamicClickMessage");

    public void doubleClick() {
        doubleClick.shouldBe(visible);
        doubleClick.doubleClick();
    }

    public void rightClick() {
        rightClick.shouldBe(visible);
        rightClick.contextClick();
    }

    public void click() {
        click.shouldBe(visible);
        click.click();
    }
}
