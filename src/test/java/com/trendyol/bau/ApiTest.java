package com.trendyol.bau;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

/**
 * Created by taylan.derinbay on 10.12.2019
 */
public class ApiTest extends HelperMethods {

    @Test
    public void apiTest() {
        RestAssured.baseURI = "http://omdbapi.com";
        ValidatableResponse response = getRequest("matrix");
        response.extract().response().prettyPrint();

        String totalResult = response.extract().path("totalResults");
        assertEquals(totalResult, "90");
    }

    /**
     * 1- Harry potter filmini ara
     * 2- ilk filmin imdbId'sini cek
     * 3- bu imdbId ile arama yap
     */

    @Test
    public void searchMovie() {
        ValidatableResponse response = given()
                .param("s", "harry potter")
                .param("apikey", "ba9c2f13")
                .when()
                .get("http://omdbapi.com")
                .then();

        response.extract().response().prettyPrint();
        String imdbId = response.extract().path("Search.imdbID[0]");
        System.out.println(imdbId);

        String movieName = given()
                .param("i", imdbId)
                .param("apikey", "ba9c2f13")
                .when()
                .get("http://omdbapi.com")
                .path("Title");

        System.out.println(movieName);
    }

    @Test
    public void loginN11() {
        ValidatableResponse response = given()
                .body("email=testbau%40mailinator.com&password=123qwe&")
                .when()
                .get("https://www.n11.com/giris-yap")
                .then();

        response.extract().response().prettyPrint();

    }
}
