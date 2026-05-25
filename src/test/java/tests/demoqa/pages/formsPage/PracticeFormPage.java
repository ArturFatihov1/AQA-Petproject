package tests.demoqa.pages.formsPage;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
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

    @Step("Ввести имя: {text}")
    public PracticeFormPage setFirstName(String text) {
        firstName.setValue(text);
        return this;
    }

    @Step("Ввести фамилию: {text}")
    public PracticeFormPage setLastName(String text) {
        lastName.setValue(text);
        return this;
    }

    @Step("Ввести email: {text}")
    public PracticeFormPage setEmail(String text) {
        userEmail.setValue(text);
        return this;
    }

    @Step("Выбрать пол (Male)")
    public PracticeFormPage selectGender() {
        genderRadioMale.parent().click(); // Клик по родителю-лейблу
        return this;
    }

    @Step("Ввести номер телефона: {text}")
    public PracticeFormPage setMobile(String text) {
        userNumber.setValue(text);
        return this;
    }

    @Step("Выбрать предметы: {text}")
    public PracticeFormPage setSubjects(String text) {
        subjects.setValue(text).pressEnter();
        return this;
    }

    @Step("Ввести адрес: {text}")
    public PracticeFormPage setAddress(String text) {
        currentAddress.setValue(text);
        return this;
    }

    @Step("Загрузить изображение: {file}")
    public PracticeFormPage uploadPicture(String file) {
        uploadPicture.uploadFromClasspath(file);
        return this;
    }

    @Step("Выбрать штат")
    public PracticeFormPage selectState() {
        stateDropdown.scrollIntoView(true).click();
        stateInput.setValue("NCR").pressEnter();
        return this;
    }

    @Step("Выбрать город")
    public PracticeFormPage selectCity() {
        cityDropdown.scrollIntoView(true).click();
        cityInput.setValue("Delhi").pressEnter();
        return this;
    }

    @Step("Нажать кнопку Submit")
    public void submit() {
        submit.scrollIntoView("{behavior: 'instant', block: 'center'}").click(ClickOptions.usingJavaScript());
    }
}
