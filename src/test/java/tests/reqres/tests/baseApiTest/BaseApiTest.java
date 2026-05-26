package tests.reqres.tests.baseApiTest;

import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import tests.specification.reqres.AuthenticationService;
import tests.specification.reqres.ResourcesService;
import tests.specification.reqres.UserService;

@Execution(ExecutionMode.CONCURRENT)
public abstract class BaseApiTest {
    protected static final String BASE_URL = "https://reqres.in/";
    protected static final UserService userService = new UserService(BASE_URL);
    protected static final ResourcesService resourcesService = new ResourcesService(BASE_URL);
    protected static final AuthenticationService authenticationService = new AuthenticationService(BASE_URL);
}