package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import api.UserApi;
import base.BaseTest;
import data.UserTestData;
import models.UserRequest;
import models.UserResponse;

public class CreateUserTest extends BaseTest {
    private UserApi userApi;

    @BeforeMethod(alwaysRun = true)
    public void setupApi() {
        userApi = new UserApi(requestSpec);
    }

    @Test(groups = "smoke")
    public void createUser() {

        UserRequest userRequest = UserTestData.createUserRequest();

        UserResponse userResponse = userApi.createUser(userRequest);

        String id = String.valueOf(userResponse.getId());
        String firstName = userResponse.getFirstName();

        System.out.println("ID: " + id);
        System.out.println("First Name: " + firstName);

        Assert.assertNotNull(id);
    }
}