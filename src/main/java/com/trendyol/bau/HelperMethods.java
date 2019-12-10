package com.trendyol.bau;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

/**
 * Created by taylan.derinbay on 10.12.2019
 */
public class HelperMethods {

    public ValidatableResponse getRequest(String movieName) {
        return given()
                .param("s", movieName)
                .param("apikey", "ba9c2f13")
                .when()
                .get("/")
                .then();
    }

}
