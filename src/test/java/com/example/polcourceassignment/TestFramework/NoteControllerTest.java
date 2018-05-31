package com.example.polcourceassignment.TestFramework;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;


import static io.restassured.RestAssured.given;

public class NoteControllerTest {

    @Test
    public void getAll(){
        RestAssured.baseURI = "http://localhost:8080";

        given().when().
                get("/notes/all").
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON);
    }

    @Test
    public void createNote(){
        RestAssured.baseURI = "http://localhost:8080";

        given().contentType(ContentType.JSON).body("{" +
                "        \"title\": \"Alaaaaa\"," +
                "        \"content\": \"post\"" +
                "    }").
                when().
                post("/notes/create").
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON);
    }

    @Test
    public void deleteNote(){
        RestAssured.baseURI = "http://localhost:8080";

        given().when().
                get("/notes/delete/1").
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON);
    }
}
