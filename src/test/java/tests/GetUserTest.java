package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import api.UserApi;
import base.BaseTest;
import data.UserTestData;
import io.restassured.response.Response;
import utils.ResponseValidator;

public class GetUserTest extends BaseTest {

    private UserApi userApi;

    @BeforeMethod(alwaysRun = true)
    public void setupApi() {
        userApi = new UserApi(requestSpec);
    }

    @Test(groups = "regression")
    public void getUser() {
        
        Response response = userApi.getUser(UserTestData.getUserId());
        
        System.out.println(response.asPrettyString());
        
        ResponseValidator.validateStatusCode(response, 200);
    }

    
}
