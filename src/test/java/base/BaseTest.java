package base;

import org.testng.annotations.BeforeClass;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import utils.ConfigReader;

public class BaseTest {
    
    protected RequestSpecification requestSpec;

    @BeforeClass(alwaysRun = true)
    public void setup() {

        String baseUrl = ConfigReader.getProperty("baseUrl");

        requestSpec = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setContentType("application/json")
                .build();
    }
}
