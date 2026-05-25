package tests.demoqa.pages.elementsPage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static com.codeborne.selenide.Selenide.$;

@Getter
@NoArgsConstructor
public class TextBoxPage {
    private final SelenideElement nameInput = $("#userName"),
            emailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submit = $("#submit"),
            outputName = $("#output #name"),
            outputEmail = $("#output #email"),
            outputCurrentAddress = $("#output #currentAddress"),
            outputPermanentAddress = $("#output #permanentAddress"),
            output = $("#output");

    @Step("fill name")
    public TextBoxPage setName(String text) {
        nameInput.setValue(text);
        return this;
    }

    @Step("fill email")
    public TextBoxPage setEmail(String text) {
        emailInput.setValue(text);
        return this;
    }

    @Step("fill current address")
    public TextBoxPage setCurrentAddress(String text) {
        currentAddressInput.setValue(text);
        return this;
    }

    @Step("fill permanentAddress")
    public TextBoxPage setPermanentAddress(String text) {
        permanentAddressInput.setValue(text);
        return this;
    }

    @Step("click submit button")
    public void submit() {
        submit.click();
    }
}
