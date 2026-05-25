package tests.demoqa.tests.forms;

import com.codeborne.selenide.Selenide;
import net.datafaker.Faker;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.demoqa.data.PracticeFormData;
import tests.demoqa.pages.formsPage.PracticeFormPage;
import tests.demoqa.tests.base.BaseUiTest;

public class PracticeFormTest extends BaseUiTest {
    PracticeFormPage practiceFormPage = new PracticeFormPage();
    PracticeFormData practiceFormData = new PracticeFormData();
    Faker faker = new Faker();

    @AfterAll
    static void close() {
        Selenide.closeWebDriver();
    }

    @BeforeEach
    public void openPage() {
        Selenide.open("automation-practice-form");

    }

    @Test
    public void fillPracticeFormTest() {
        practiceFormData = new PracticeFormData(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress(),
                faker.gender().binaryTypes(),
                faker.number().digits(10),
                faker.educator().course(),
                faker.address().fullAddress()
        );
        practiceFormPage
                .setFirstName(practiceFormData.getFirstName())
                .setLastName(practiceFormData.getLastName())
                .setEmail(practiceFormData.getEmail())
                .selectGender()
                .setMobile(practiceFormData.getMobile())
                .setSubjects(practiceFormData.getSubjects())
                .uploadPicture("testFile.txt")
                .setAddress(practiceFormData.getAddress());

        practiceFormPage.submit();
    }

}
