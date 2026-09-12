package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import api.UserApi;
import base.BaseTest;
import data.UserTestData;
import io.restassured.response.Response;
import utils.ResponseValidator;

public class GetInvalidUserTest extends BaseTest {
    
    private UserApi userApi;

    @BeforeMethod(alwaysRun = true)
    public void setupApi() {
        userApi = new UserApi(requestSpec);
    }

    @Test(groups = "negative")
    public void getInvalidUser() {
        
        Response response = userApi.getUser(UserTestData.getInvalidUserId());

        System.out.println(response.asPrettyString());

        ResponseValidator.validateStatusCode(response, 404);
    }

}
