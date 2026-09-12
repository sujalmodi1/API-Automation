package data;

import models.UserRequest;

public class UserTestData {

    public static UserRequest createUserRequest() {
    
        return new UserRequest(
            "Sujal",
            "QA Automation Engineer"    
            
        );
    }

    public static String updateUserRequest() {

        return """
                {
                    "firstName": "Sujal"}
                """;
    }

    public static int getUserId() {
        return 1;
    }

    public static int getInvalidUserId() {
        return 99999;
    }

    public static int deleteUserId() {
        return 1;
    }

}
