package tests.demoqa.pages.elementsPage;

import com.codeborne.selenide.SelenideElement;
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

    public void selectYes() {
        yesRadio.click();
    }

    public void selectImpressiveRadio() {
        impressiveRadio.click();
    }
}
