package tests.specification.reqres;

import io.restassured.response.Response;
import tests.reqres.pojo.user.User;
import tests.specification.RestClient;
import tests.specification.dto.user.UserPut;

public class UserService {
    private final String API_KEY = ConfigReader.getApiKey();

    private final RestClient restClient;

    public UserService() {
        this.restClient = new RestClient("https://reqres.in/", API_KEY);
    }

    public Response getUsers() {
        return restClient.get("api/users?page=2");
    }

    public Response getUser(String id) {
        return restClient.get("/api/users/" + id);
    }

    public Response postUser(String name) {
        User user = new User(name);
        return restClient.post("/api/users", user);
    }

    public Response putUser(String name, String job) {
        UserPut body = new UserPut(name, job);
        return restClient.put("/api/users/2", body);
    }

    public Response deleteUser(String id) {
        return restClient.delete("/api/users/" + id);
    }
}
