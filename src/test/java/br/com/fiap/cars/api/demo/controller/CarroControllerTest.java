package br.com.fiap.cars.api.demo.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import io.restassured.RestAssured;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


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
    void addCar() {
    }

    @Test
    void testGetCarById() {
        given()
                .when()
                .get("/carros/" + 1L)
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("marca", equalTo("Fiat"))
                .body("modelo", equalTo("Toro"))
                .body("ano", equalTo(2015))
                .body("potencia", equalTo("250.0 HP"))
                .body("tipo", equalTo("COMBUSTAO"))
                .body("economia", equalTo("50.0 km/litro"))
                .body("preco", equalTo(700000.0F));
    }
    @Test
    void deleteCar() {
    }

    @Test
    void updateCar() {
    }

    @Test
    void getCarsByPotencia() {
    }

    @Test
    void getCarsByEconomia() {
    }

    @Test
    void getCarsEletricos() {
    }
}