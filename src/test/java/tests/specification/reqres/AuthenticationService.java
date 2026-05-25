package tests.specification.reqres;

import io.restassured.response.Response;
import tests.reqres.pojo.user.RegisterUser;
import tests.specification.RestClient;

public class AuthenticationService {
    private final String API_KEY = ConfigReader.getApiKey();

    private final RestClient restClient;

    public AuthenticationService() {
        this.restClient = new RestClient("https://reqres.in/", API_KEY);
    }

    public Response registerUser(String email, String password) {
        RegisterUser body = new RegisterUser(email, password);
        return restClient.post("api/register", body);
    }

    public Response loginUser(String name, String password) {
        RegisterUser body = new RegisterUser(name, password);
        return restClient.post("api/login", body);
    }
}
