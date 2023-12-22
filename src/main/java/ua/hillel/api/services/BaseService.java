package ua.hillel.api.services;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseService {
    public static final String BASE_URL = "https://restful-booker.herokuapp.com";

    private RequestSpecification buildRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setContentType("application/json")
                .setAccept("application/json")
//                .addFilter(new RequestLoggingFilter())
//                .addFilter(new ResponseLoggingFilter())
//                .addFilter(new ErrorLoggingFilter())
//                .addFilter(new AllureRestAssured())
                .build();
    }

    protected RequestSpecification setRequestSpec() {
        return RestAssured.given().spec(buildRequestSpec());
    }
}
