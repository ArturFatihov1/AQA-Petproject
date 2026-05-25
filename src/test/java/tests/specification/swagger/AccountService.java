package tests.specification.swagger;


import io.restassured.response.Response;
import tests.specification.RestClient;
import tests.specification.dto.user.AuthResponse;
import tests.specification.dto.user.TokenDto;
import tests.specification.dto.user.UserDto;

public class AccountService {
    private final RestClient restClient;

    public AccountService() {
        this.restClient = new RestClient("https://demoqa.com/");
    }

    public boolean authorize(String userName, String password) {
        AuthResponse user = new AuthResponse(userName, password);
        Response response = restClient.post("Account/v1/Authorized", user);
        return response.as(Boolean.class);
    }

    public TokenDto generateToken(String userName, String password) {
        AuthResponse user = new AuthResponse(userName, password);
        return restClient.post("Account/v1/GenerateToken", user, TokenDto.class);
    }

    public UserDto createUser(String userName, String password) {
        AuthResponse user = new AuthResponse(userName, password);
        return restClient.post("Account/v1/User", user, UserDto.class);
    }

    public Response deleteUser(String userId, String token) {
        return restClient.delete("Account/v1/User/" + userId, token);
    }

    public UserDto getUser(String userId, String token) {
        return restClient.get("Account/v1/User/" + userId, token, UserDto.class);
    }
}