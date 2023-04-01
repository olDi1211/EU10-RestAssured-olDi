package com.cydeo.Day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpratanNegativeGetTest {


    //BeforeAll is an annotation equals to @BeforeClass in TestNg, we use with static method name
    @BeforeAll
    public static void init() {
        baseURI = "http://35.168.1.98:8000";
    }

     /*TASK
    Given Accept type application/xml
    When user send GET request to /api/spartans/10 end point
    Then status code must be 406
    And response Content Type must be application/xml;charset=UTF-8
    */

    @DisplayName("GET request to /api/spartans/10")
    @Test
    public void test1(){

        Response response = given().accept(ContentType.XML).
                when().get("/api/spartans/10");

        //verify status code is 406
        assertEquals(406,response.getStatusCode());

        //verify response Content type
        assertEquals("application/xml;charset=UTF-8",response.getContentType());

    }



}
