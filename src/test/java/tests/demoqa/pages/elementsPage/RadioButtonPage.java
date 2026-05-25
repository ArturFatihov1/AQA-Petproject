package tests.demoqa.pages.elementsPage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static com.codeborne.selenide.Selenide.$;

@Getter
@NoArgsConstructor
public class RadioButtonPage {
    private final SelenideElement yesRadio = $("#yesRadio"),
            impressiveRadio = $("#impressiveRadio"),
            noRadio = $("#noRadio"),
            result = $(".mt-3");

    @Step("Выбрать переключатель 'Yes'")
    public void selectYes() {
        yesRadio.click();
    }

    @Step("Выбрать переключатель 'Impressive'")
    public void selectImpressiveRadio() {
        impressiveRadio.click();
    }
}
