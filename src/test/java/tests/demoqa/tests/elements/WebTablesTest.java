package tests.demoqa.tests.elements;

import com.codeborne.selenide.Selenide;
import net.datafaker.Faker;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.demoqa.data.WebTablesData;
import tests.demoqa.pages.elementsPage.WebTablesPage;
import tests.demoqa.tests.base.BaseUiTest;

public class WebTablesTest extends BaseUiTest {

    WebTablesPage webTablesPage = new WebTablesPage();
    WebTablesData webTablesData = new WebTablesData();
    Faker faker = new Faker();

    @AfterAll
    static void close() {
        Selenide.closeWebDriver();
    }

    @BeforeEach
    public void openPage() {
        Selenide.open("webtables");
        addNewRecordTest();
    }

    public void addNewRecordTest() {
        webTablesPage.addNewRecordButton();

        webTablesData = new WebTablesData(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.number().digits(2),
                faker.internet().emailAddress(),
                faker.number().positive(),
                faker.company().industry()
        );
        webTablesPage
                .setFirstName(webTablesData.getFirstName())
                .setLastName(webTablesData.getLastName())
                .setEmail(webTablesData.getEmail())
                .setAge(webTablesData.getAge())
                .setSalary(webTablesData.getSalary())
                .setDeportment(webTablesData.getDepartment());

        webTablesPage.submit();

    }

    @Test
    public void recordAddedTest() {
        int lastRow = webTablesPage.getLastRowIndex();

        String actualFirstName = webTablesPage.getCellValue(lastRow, 0);
        String actualLastName = webTablesPage.getCellValue(lastRow, 1);
        String actualAge = webTablesPage.getCellValue(lastRow, 2);
        String actualEmail = webTablesPage.getCellValue(lastRow, 3);

        Assertions.assertEquals(webTablesData.getFirstName(), actualFirstName);
        Assertions.assertEquals(webTablesData.getLastName(), actualLastName);
        Assertions.assertEquals(webTablesData.getAge(), actualAge);
        Assertions.assertEquals(webTablesData.getEmail(), actualEmail);
    }

    @Test
    public void editRecordTest() {
        webTablesPage.editRecordByText(webTablesData.getEmail());

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        webTablesPage
                .setFirstName(firstName)
                .setLastName(lastName);

        webTablesPage.submit();

        int lastRow = webTablesPage.getLastRowIndex();
        String actualFirstName = webTablesPage.getCellValue(lastRow, 0);
        String actualLastName = webTablesPage.getCellValue(lastRow, 1);

        Assertions.assertEquals(firstName, actualFirstName);
        Assertions.assertEquals(lastName, actualLastName);
    }

    @Test
    public void deleteRecordTest() {
        int oldSize = webTablesPage.getLastRowIndex();
        webTablesPage.deleteRecordByText(webTablesData.getEmail());
        int newSize = webTablesPage.getLastRowIndex();
        Assertions.assertEquals(oldSize, newSize + 1);
    }

    @Test
    public void searchRecordTest() {
        webTablesPage.search(webTablesData.getFirstName());
        int a = 0;
        int currentIndex = webTablesPage.getLastRowIndex();
        String actualFirstName = webTablesPage.getCellValue(currentIndex, 0);
        Assertions.assertEquals(webTablesData.getFirstName(), actualFirstName);
        int x = 1;
    }
}
