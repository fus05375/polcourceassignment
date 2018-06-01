package com.example.polcourceassignment.test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;

public class NoteControllerTest {



    @Test
    public void getAllTrue(){
        RestAssured.baseURI = "http://localhost:8080";

        given().when().
                get("/notes/all").
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON);
    }

    @Test
    public void createNoteTrue(){
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
    public void deleteNoteTrue(){
        RestAssured.baseURI = "http://localhost:8080";

        given().when().
                get("/notes/delete/3").
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON);
    }

    @Test
    public void updateNoteTrue(){
        RestAssured.baseURI = "http://localhost:8080";

        given().contentType(ContentType.JSON).body("{" +
                "        \"title\": \"Alaaaaa\"," +
                "        \"content\": \"Ma Kotaaaa\"" +
                "    }").
                when().
                put("/notes/update/1").
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON);

    }

    @Test
    public void updateNoteAddTagTrue(){
        RestAssured.baseURI = "http://localhost:8080";

        given().
                when().
                put("/notes/update/1/addTag/1").
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON);

    }

    @Test
    public void updateNoteDelTagTrue(){
        RestAssured.baseURI = "http://localhost:8080";

        given().
                when().
                get("/notes/update/1/delTag/1").
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON);

    }


}
