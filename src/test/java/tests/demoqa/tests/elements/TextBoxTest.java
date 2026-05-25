package tests.demoqa.tests.elements;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import net.datafaker.Faker;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.demoqa.pages.elementsPage.TextBoxPage;
import tests.demoqa.tests.BaseUiTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

@Epic("DemoQA test ui")
@Feature("Elements")
@Story("Text box")
public class TextBoxTest extends BaseUiTest {

    TextBoxPage textBoxPage = new TextBoxPage();
    Faker faker = new Faker();

    @AfterAll
    static void close() {
        Selenide.closeWebDriver();
    }

    @BeforeEach
    public void openPage() {
        Selenide.open("text-box");
    }

    @Test
    @DisplayName("Успешное заполнение всех полей формы")
    @Description("Заполнение всех полей валидными данными и проверка корректности отображения в блоке вывода.")
    @Severity(SeverityLevel.CRITICAL)
    public void fullFormTest() {
        String name = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String currentAddress = faker.address().fullAddress();
        String permanentAddress = faker.address().fullAddress();
        textBoxPage.setName(name)
                .setEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress);

        textBoxPage.submit();

        textBoxPage.getOutputName().shouldHave(text(name));
        textBoxPage.getOutputEmail().shouldHave(text(email));
        textBoxPage.getOutputCurrentAddress().shouldHave(text(currentAddress));
        textBoxPage.getOutputPermanentAddress().shouldHave(text(permanentAddress));
    }

    @Test
    @DisplayName("Заполнение формы без одного поля")
    @Severity(SeverityLevel.NORMAL)
    public void notFullFormTest() {
        String name = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String currentAddress = faker.address().fullAddress();
        textBoxPage.setName(name)
                .setEmail(email)
                .setCurrentAddress(currentAddress);

        textBoxPage.submit();

        textBoxPage.getOutputName().shouldHave(text(name));
        textBoxPage.getOutputEmail().shouldHave(text(email));
        textBoxPage.getOutputCurrentAddress().shouldHave(text(currentAddress));
        textBoxPage.getOutputPermanentAddress().shouldNotBe(visible);
    }

    @Test
    @DisplayName("Проверка валидации некорректного email")
    @Severity(SeverityLevel.NORMAL)
    public void errorEmailTest() {
        textBoxPage.setEmail("artur.fatihov23@mail");
        textBoxPage.submit();
        textBoxPage.getOutputEmail().shouldNotBe(visible);
    }

    @Test
    @DisplayName("Отправка пустой формы")
    @Severity(SeverityLevel.TRIVIAL)
    public void submitEmptyFormTest() {
        textBoxPage.submit();
        textBoxPage.getOutput().shouldNotBe(visible);
    }
}
