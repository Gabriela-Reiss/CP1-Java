package br.com.fiap.cars.api.demo.controller;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import io.restassured.RestAssured;


import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarroControllerTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
        RestAssured.basePath = "/api";
    }

    @Test
    void testGetAllCars() {
        given()
                .when()
                .get("/carros")
                .then()
                .statusCode(200)
                .body("$", hasSize(equalTo(10)));

    }

    @Test
    void testAddCar() {
        given()
                .contentType(ContentType.JSON)
            .body("{\"marca\": \"Toyota\", \"modelo\": \"Hilux\", \"ano\": \"2020\", \"potencia\": \"250\", \"tipo\": \"ELETRICO\", \"preco\": \"500000\", \"economia\": \"250\" }")
                .when()
                .post("/carros")
                .then()
                .statusCode(201)
                .body("id", equalTo(11))
                .body("marca", equalTo("Toyota"))
                .body("modelo", equalTo("Hilux"))
                .body("ano", equalTo(2020))
                .body("potencia", equalTo("250.0 HP"))
                .body("tipo", equalTo("ELETRICO"))
                .body("preco", equalTo(500000.0F))
                .body("economia", equalTo("250.0 km/kWh"));

    }

    @Test
    void testGetCarById() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/carros/" + 2L)
                .then()
                .statusCode(200)
                .body("id", equalTo(2))
                .body("marca", equalTo("Toyota"))
                .body("modelo", equalTo("Corolla"))
                .body("ano", equalTo(2021))
                .body("potencia", equalTo("200.0 HP"))
                .body("tipo", equalTo("HIBRIDO"))
                .body("preco", equalTo(110000.0F))
                .body("economia", equalTo("55.0 km/litro"));

    }
    @Test
    void testDeleteCar() {
        given()
                .when()
                .delete("/carros/" + 1L)
                .then()
                .statusCode(204);

    }

    @Test
    void testUpdateCar() {
        given()
        .contentType(ContentType.JSON)
                .body("{\"marca\": \"Renault\", \"modelo\": \"Kwid E-Tech\", \"ano\": \"2023\", \"potencia\": \"180\", \"tipo\": \"ELETRICO\", \"preco\": \"100000\", \"economia\": \"90\" }")
                .when()
                .put("/carros/" + 5L)
                .then()
                .statusCode(200)
                .body("id", equalTo(5))
                .body("marca", equalTo("Renault"))
                .body("modelo", equalTo("Kwid E-Tech"))
                .body("ano", equalTo(2023))
                .body("potencia", equalTo("180.0 HP"))
                .body("tipo", equalTo("ELETRICO"))
                .body("economia", equalTo("90.0 km/kWh"))
                .body("preco", equalTo(100000.0F));

    }

    @Test
    void testGetCarsByPotencia() {
        List<String> modelosEletricos = given()
                .when()
                .get("/carros/potencia")
                .then()
                .statusCode(200)
                .body("size()", equalTo(10))
                .extract()
                .jsonPath()
                .getList("modelo", String.class);

        List<String> modelosEsperados = List.of(
                "Model 3",
                "Toro",
                "Fusion",
                "Ioniq",
                "Golf",
                "Corolla",
                "Leaf",
                "Kwid E-Tech",
                "208",
                "Onix"

        );
        assertEquals(modelosEsperados, modelosEletricos);
    }

    @Test
    void testGetCarsByEconomia() {
        List<String> modelosOrdenados = given()
                .when()
                .get("/carros/economia")
                .then()
                .statusCode(200)
                .body("size()", equalTo(10))
                .extract()
                .jsonPath()
                .getList("modelo", String.class);

        List<String> modelosEsperados = List.of(
                "Model 3",
                "Leaf",
                "Kwid E-Tech",
                "Ioniq",
                "Fusion",
                "Corolla",
                "Toro",
                "Golf",
                "208",
                "Onix"
        );

        assertEquals(modelosEsperados, modelosOrdenados);
    }




    @Test
    void testGetCarsEletricos() {
        List<String> modelosEletricos = given()
                .when()
                .get("/carros/eletricos")
                .then()
                .statusCode(200)
                .body("size()", equalTo(3))
                .extract()
                .jsonPath()
                .getList("modelo", String.class);

        List<String> modelosEsperados = List.of(
                "Model 3",
                "Kwid E-Tech",
                "Leaf"
        );
        assertEquals(modelosEsperados, modelosEletricos);
    }
}