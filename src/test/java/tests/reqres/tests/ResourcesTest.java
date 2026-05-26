package tests.reqres.tests;

import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.reqres.pojo.resources.PersonInfo;
import tests.reqres.pojo.resources.ResourcesRoot;
import tests.reqres.tests.baseApiTest.BaseApiTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Работа с ресурсами (Resources)")
@Owner("Artur Fatihov")
public class ResourcesTest extends BaseApiTest {

    @Test
    @DisplayName("Получение списка ресурсов (страница 1)")
    @Story("Чтение данных")
    @Severity(SeverityLevel.NORMAL)
    public void getListResourcesTest() {
        Response response = resourcesService.getResources();

        assertEquals(200, response.statusCode());

        ResourcesRoot resources = response.as(ResourcesRoot.class);

        assertThat(resources.page()).isEqualTo(1);
        assertThat(resources.perPage()).isEqualTo(6);

        assertThat(resources.data())
                .isNotEmpty()
                .hasSize(6)
                .extracting(PersonInfo::name)
                .contains("cerulean", "true red");
    }

    @Test
    @DisplayName("Получение списка продуктов (страница 2)")
    @Story("Чтение данных")
    @Severity(SeverityLevel.NORMAL)
    public void getListProductsTest() {
        Response response = resourcesService.getProducts("2");

        assertEquals(200, response.statusCode());

        ResourcesRoot resources = response.as(ResourcesRoot.class);

        assertThat(resources.page()).isEqualTo(2);
        assertThat(resources.perPage()).isEqualTo(6);

        assertThat(resources.data())
                .isNotEmpty()
                .hasSize(6)
                .extracting(PersonInfo::name)
                .contains("sand dollar", "blue iris");
    }
}