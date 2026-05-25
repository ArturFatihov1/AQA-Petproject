package tests.demoqa.pages.formsPage;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static com.codeborne.selenide.Selenide.$;

@Getter
@NoArgsConstructor
public class PracticeFormPage {
    private final SelenideElement firstName = $("#firstName"),
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
            genderRadioMale = $("#gender-radio-1"),
            userNumber = $("#userNumber"),
            subjects = $("#subjectsInput"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            stateDropdown = $("#state"),
            cityDropdown = $("#city"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submit = $("#submit");

    public PracticeFormPage setFirstName(String text) {
        firstName.setValue(text);
        return this;
    }

    public PracticeFormPage setLastName(String text) {
        lastName.setValue(text);
        return this;
    }

    public PracticeFormPage setEmail(String text) {
        userEmail.setValue(text);
        return this;
    }

    public PracticeFormPage selectGender() {
        genderRadioMale.click();
        return this;
    }

    public PracticeFormPage setMobile(String text) {
        userNumber.setValue(text);
        return this;
    }

    public PracticeFormPage setSubjects(String text) {
        subjects.setValue(text).pressEnter();
        return this;
    }

    public PracticeFormPage setAddress(String text) {
        currentAddress.setValue(text);
        return this;
    }

    public PracticeFormPage uploadPicture(String file) {
        uploadPicture.uploadFromClasspath(file);
        return this;
    }

    public PracticeFormPage selectState() {
        stateDropdown.scrollIntoView(true).click();

        stateInput.setValue("NCR").pressEnter();
        return this;
    }

    public PracticeFormPage selectCity() {
        cityDropdown.scrollIntoView(true).click();

        cityInput.setValue("Delhi").pressEnter();
        return this;
    }

    public void submit() {
        submit.scrollIntoView("{behavior: 'instant', block: 'center'}").click(com.codeborne.selenide.ClickOptions.usingJavaScript());
    }
}
