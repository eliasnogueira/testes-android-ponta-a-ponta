package integracao;

import org.junit.Test;

import static com.jayway.restassured.RestAssured.baseURI;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.port;
import static org.hamcrest.CoreMatchers.equalTo;


public class TrianguloIntegrationTest {

    public TrianguloIntegrationTest() {
        baseURI = "http://localhost/triangulo/api/";
        port = 8888;
    }


    @Test
    public void testeTrianguloEquilatero() {
        given()
            .param("lado1", "3")
            .param("lado2", "3")
            .param("lado3", "3")
        .when()
            .post("/calcular")
        .then()
            .body("resultado",equalTo("O triângulo é Equilátero"));
    }

    @Test
    public void testeTrianguloEscaleno() {
        given()
                .param("lado1", "3")
                .param("lado2", "6")
                .param("lado3", "9")
        .when()
                .post("/calcular")
        .then()
                .body("resultado", equalTo("O trinauglo e escaleno"));
    }


}