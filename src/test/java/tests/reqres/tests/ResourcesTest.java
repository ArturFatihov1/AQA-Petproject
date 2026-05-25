package tests.reqres.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import tests.reqres.pojo.resources.PersonInfo;
import tests.reqres.pojo.resources.ResourcesRoot;
import tests.reqres.tests.baseApiTest.BaseApiTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResourcesTest extends BaseApiTest {

    @Test
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
