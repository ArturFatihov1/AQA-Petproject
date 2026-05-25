package tests.demoqa.pages.bookStoreApplicationPage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class LoginPage {
    private final SelenideElement userName = $("#userName"),
            password = $("#password"),
            login = $("#login"),
            newUser = $("#newUser");

    private final SelenideElement firstname = $("#firstname"),
            lastname = $("#lastname"),
            register = $("#register"),
            backToLogin = $("#gotologin"),
            output = $("#output");

    @Step("Ввести имя пользователя: {text}")
    public void setUserName(String text) {
        userName.setValue(text);
    }

    @Step("Ввести пароль: {text}")
    public void setPassword(String text) {
        password.setValue(text);
    }

    @Step("Ввести имя: {text}")
    public void setFirstname(String text) {
        firstname.setValue(text);
    }

    @Step("Ввести фамилию: {text}")
    public void setLastName(String text) {
        lastname.setValue(text);
    }

    @Step("Нажать кнопку Login")
    public void clickLogin() {
        login.click();
    }

    @Step("Нажать кнопку New User")
    public void clickNewUser() {
        newUser.click();
    }

    public void clickBackToLogin() {
        backToLogin.click();
    }

    @Step("Нажать кнопку Register")
    public void clickRegister() {
        register.click();
    }
}