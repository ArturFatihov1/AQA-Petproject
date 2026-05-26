package tests.specification.reqres;

import io.restassured.response.Response;
import tests.specification.RestClient;

public class ResourcesService {
    private final String API_KEY = ConfigReader.getApiKey();
    private final RestClient restClient;

    public ResourcesService(String baseUrl) {
        this.restClient = new RestClient(baseUrl, API_KEY);
    }

    public Response getResources() {
        return restClient.get("api/unknown");
    }

    public Response getProducts(String page) {
        return restClient.get("/api/products?page=" + page);
    }
}
