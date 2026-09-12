package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import api.UserApi;
import base.BaseTest;
import data.UserTestData;
import io.restassured.response.Response;
import utils.ResponseValidator;

public class UpdateUserTest extends BaseTest {

    private UserApi userApi;

    @BeforeMethod(alwaysRun = true)
    public void setupApi() {
        userApi = new UserApi(requestSpec);
    }

    @Test(groups = "regression")
    public void updateUser() {
        
        String requestBody = UserTestData.updateUserRequest();
        
        Response response = userApi.updateUser(2, requestBody);

        System.out.println(response.asPrettyString());

        ResponseValidator.validateStatusCode(response, 200);

        String firstName = response.jsonPath().getString("firstName");

        Assert.assertEquals(firstName, "Sujal");
    }
}

