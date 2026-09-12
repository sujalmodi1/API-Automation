package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse {
    
    private int id;
    private String firstName;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }
}
