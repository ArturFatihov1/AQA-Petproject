package tests.demoqa.pages.elementsPage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@Data
@NoArgsConstructor
public class WebTablesPage {
    private final SelenideElement addNewRecordButton = $("#addNewRecordButton"),
            searchBox = $("#searchBox"),
            nextButton = $x("//button[text()='Next']"),
            previousButton = $x("//button[text()='Previous']"),
            lastButton = $x("//button[text()='Last']"),
            firstButton = $x("//button[text()='First']"),
            selectButton = $("select"),
            navigationBtnResult = $("strong"),
            tbody = $("tbody");

    private final SelenideElement firstName = $("#firstName"),
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
            age = $("#age"),
            salary = $("#salary"),
            department = $("#department"),
            submit = $("#submit");
    private final ElementsCollection rows = $$("tbody tr");

    @Step("Ввести имя: {text}")
    public WebTablesPage setFirstName(String text) {
        firstName.setValue(text);
        return this;
    }

    @Step("Ввести фамилию: {text}")
    public WebTablesPage setLastName(String text) {
        lastName.setValue(text);
        return this;
    }

    @Step("Ввести email: {text}")
    public WebTablesPage setEmail(String text) {
        userEmail.setValue(text);
        return this;
    }

    @Step("Ввести возраст: {text}")
    public WebTablesPage setAge(String text) {
        age.setValue(text);
        return this;
    }

    @Step("Ввести зарплату: {salary}")
    public WebTablesPage setSalary(Integer text) {
        salary.setValue(String.valueOf(text));
        return this;
    }

    @Step("Ввести отдел: {text}")
    public WebTablesPage setDeportment(String text) {
        department.setValue(text);
        return this;
    }

    @Step("Нажать кнопку Submit")
    public void submit() {
        submit.click();
    }

    @Step("Нажать кнопку Add New Record")
    public void addNewRecordButton() {
        addNewRecordButton.click();
    }

    @Step("Поиск по запросу: {query}")
    public void search(String query) {
        searchBox.setValue(query);
    }


    public int getLastRowIndex() {
        return rows.size() - 1;
    }

    public String getCellValue(int rowIndex, int colIndex) {
        return rows.get(rowIndex).$("td", colIndex).getText();
    }

    @Step("Редактировать запись с текстом: {searchText}")
    public WebTablesPage editRecordByText(String searchText) {
        SelenideElement targetRow = rows.findBy(text(searchText));
        targetRow.$("#edit-record-" + rows.size()).click();
        return this;
    }

    @Step("Удалить запись с текстом: {searchText}")
    public WebTablesPage deleteRecordByText(String searchText) {
        SelenideElement targetRow = rows.findBy(text(searchText));
        targetRow.$("#delete-record-" + rows.size()).click();
        return this;
    }

}

