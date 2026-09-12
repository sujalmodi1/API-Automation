package api;

import constants.ApiEndpoints;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.UserRequest;
import models.UserResponse;

public class UserApi {
    
    private RequestSpecification requestSpec;

    public UserApi(RequestSpecification requestSpec) {
        this.requestSpec = requestSpec;
    }

    public UserResponse createUser(UserRequest userRequest) {

    Response response = given()
            .spec(requestSpec)
            .body(userRequest)
        .when()
            .post(ApiEndpoints.CREATE_USER);

    return response.as(UserResponse.class);
}

    public Response createUserWithEmptyBody() {
        
        return given()
                .spec(requestSpec)
                .body("")
            .when()
                .post(ApiEndpoints.CREATE_USER);
    }

    public Response getUser(int userId) {
    
        return given()
                .spec(requestSpec)
            .when()
                .get(ApiEndpoints.GET_USER + userId);
    }

    public Response updateUser(int userId, String requestBody) {

        return given()
                .spec(requestSpec)
                .body(requestBody)
            .when()
                .put(ApiEndpoints.UPDATE_USER + userId);
    }

    public Response deleteUser(int userId) {

        return given()
                .spec(requestSpec)
            .when()
                .delete(ApiEndpoints.DELETE_USER + userId);
    }
}
