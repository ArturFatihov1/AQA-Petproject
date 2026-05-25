package tests.demoqa.pages.bookStoreApplicationPage;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Selenide.$;

@Slf4j
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

    public void setUserName(String text) {
        userName.setValue(text);
    }

    public void setPassword(String text) {
        password.setValue(text);
    }

    public void setFirstname(String text) {
        firstname.setValue(text);
    }

    public void setLastName(String text) {
        lastname.setValue(text);
    }

    public void clickLogin() {
        login.click();
    }

    public void clickNewUser() {
        newUser.click();
    }

    public void clickBackToLogin() {
        backToLogin.click();
    }

    public void clickRegister() {
        register.click();
    }

}
