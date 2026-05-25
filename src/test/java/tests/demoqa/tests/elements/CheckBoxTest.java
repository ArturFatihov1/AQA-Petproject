package tests.demoqa.tests.elements;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.demoqa.pages.elementsPage.CheckBoxPage;
import tests.demoqa.tests.base.BaseUiTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

@Epic("DemoQA test ui")
@Feature("Elements")
@Story("CheckBox")
public class CheckBoxTest extends BaseUiTest {

    CheckBoxPage checkBoxPage = new CheckBoxPage();

    @AfterAll
    static void close() {
        Selenide.closeWebDriver();
    }

    @BeforeEach
    public void openPage() {
        Selenide.open("checkbox");
    }

    @Test
    @DisplayName("Выбор чекбокса Home и проверка отображения всех элементов")
    @Description("При выборе корневого элемента Home должны отобразиться все вложенные элементы в блоке результатов.")
    @Severity(SeverityLevel.CRITICAL)
    public void selectedHomeTest() {
        checkBoxPage.openSwitcher().selectHome();

        checkBoxPage.getResult().shouldHave(
                text("Home"),
                text("desktop"),
                text("documents"),
                text("downloads"),
                text("notes"),
                text("general")
        );
    }

    @Test
    @DisplayName("Открытие дерева элементов через свитчер")
    @Severity(SeverityLevel.NORMAL)
    public void switcherHomeOpenTest() {
        checkBoxPage.openSwitcher();
        checkBoxPage.getHome().shouldBe(visible);
        checkBoxPage.getDesktop().shouldBe(visible);
        checkBoxPage.getDocuments().shouldBe(visible);
        checkBoxPage.getDownloads().shouldBe(visible);
    }

    @Test
    @DisplayName("Выбор чекбокса Notes внутри Desktop")
    @Severity(SeverityLevel.NORMAL)
    public void switcherDesktopOpenTest() {
        checkBoxPage.openSwitcher().openDesktopSwitcher().selectNotes();
        checkBoxPage.getResult().shouldHave(text("You have selected :"), text("notes"));
    }

    @Test
    @DisplayName("Проверка отсутствия результата при отсутствии действий")
    @Severity(SeverityLevel.TRIVIAL)
    public void emptyResultTest() {
        checkBoxPage.getResult().shouldNotBe(visible);
    }

    @Test
    @DisplayName("Проверка снятия выбора с чекбокса Notes")
    @Severity(SeverityLevel.NORMAL)
    public void unSelectedCheckBox() {
        checkBoxPage.openSwitcher().openDesktopSwitcher().selectNotes();

        checkBoxPage.getResult().shouldHave(text("You have selected :"), text("notes"));

        checkBoxPage.selectNotes();
        checkBoxPage.getResult().shouldNotBe(visible);
    }
}
