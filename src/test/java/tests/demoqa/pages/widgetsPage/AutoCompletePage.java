package tests.demoqa.pages.widgetsPage;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class AutoCompletePage {
    private final SelenideElement autoCompleteMultipleInput = $("#autoCompleteMultipleInput"),
            autoCompleteSingleInput = $("#autoCompleteSingleInput"),
            blueRemove = $("[aria-label=\"Remove Blue\"]"),
            blackRemove = $("[aria-label=\"Remove Black\"]"),
            removeAll = $(".auto-complete__indicator"),
            resultMultiple = $x("//div[contains(@class,\"auto-complete__value-container\")][1]"),
            resultSingle = $x("//div[contains(@class,'auto-complete__single-value')]");

    public void setAutoCompleteMultipleInput(String text) {
        autoCompleteMultipleInput.setValue(text).pressEnter();
    }

    public void setAutoCompleteSingleInput(String text) {
        autoCompleteSingleInput.setValue(text).pressEnter();
    }

    public void removeAll() {
        removeAll.click();
    }

    public void removeBlack() {
        blackRemove.click();
    }

    public void removeBlue() {
        blueRemove.click();
    }
}
