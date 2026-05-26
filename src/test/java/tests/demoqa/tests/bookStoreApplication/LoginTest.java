package tests.demoqa.tests.bookStoreApplication;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import net.datafaker.Faker;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.demoqa.pages.bookStoreApplicationPage.LoginPage;
import tests.demoqa.tests.BaseUiTest;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;

@Epic("DemoQA test ui")
@Feature("Book Store Application")
@Story("Login & Registration")
@DisplayName("Тестирование входа и регистрации пользователя")
public class LoginTest extends BaseUiTest {

    LoginPage loginPage = new LoginPage();
    Faker faker = new Faker();

    @AfterAll
    static void close() {
        Selenide.closeWebDriver();
    }

    @BeforeEach
    void open() {
        Selenide.open("login");
    }

    @Test
    @DisplayName("Проверка входа с неверными учетными данными")
    @Severity(SeverityLevel.NORMAL)
    public void loginNotUserTest() {
        String userName = faker.credentials().username();
        String password = faker.credentials().password();

        loginPage.setUserName(userName);
        loginPage.setPassword(password);
        loginPage.clickLogin();

        loginPage.getOutput().shouldHave(text("Invalid username or password!"), Duration.ofSeconds(4));
    }

    @Test
    @DisplayName("Проверка процесса регистрации нового пользователя")
    @Severity(SeverityLevel.NORMAL)
    public void registerNewUserTest() {
        loginPage.clickNewUser();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userName = faker.credentials().username();
        String password = faker.credentials().password();

        loginPage.setUserName(userName);
        loginPage.setPassword(password);
        loginPage.setFirstname(firstName);
        loginPage.setLastName(lastName);

        loginPage.clickRegister();

        loginPage.getOutput().shouldHave(text("Please verify reCaptcha to register!"), Duration.ofSeconds(4));
    }
}