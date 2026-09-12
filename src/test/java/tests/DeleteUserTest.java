package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import api.UserApi;
import base.BaseTest;
import data.UserTestData;
import io.restassured.response.Response;
import utils.ResponseValidator;

public class DeleteUserTest extends BaseTest {
    
    private UserApi userApi;
    
    @BeforeMethod(alwaysRun = true)
    public void setupApi() {
        userApi = new UserApi(requestSpec);
    }

    @Test(groups = "regression")
    public void deleteUser() {

        Response response = userApi.deleteUser(UserTestData.deleteUserId());

        System.out.println(response.asPrettyString());

        ResponseValidator.validateStatusCode(response, 200);
        
        boolean isDeleted = response.jsonPath().getBoolean("isDeleted");
        
        Assert.assertTrue(isDeleted);
    }

}
