package apiPetStore;

import com.google.gson.Gson;
import entities.UserEntity;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class User {
    // Atributos
    String jsonBody;
    String ct = "application/json";
    String uri = "https://petstore.swagger.io/v2/";

    Gson gson = new Gson(); // instanciar
    @Test
    public void testCreatUser(){
        // Configura
        // Dados de Entrada
        UserEntity user = new UserEntity();
        user.id = 9999;
        user.username = "Gui";
        user.firstName = "Gui";
        user.lastName = "Monteiro";
        user.email = "guioliveiratvv@gmail.com";
        user.password = "Gui071120";
        user.phone = "14999008166";
        user.userStatusString = 0;

        jsonBody = gson.toJson(user);

        // Dados de Saida / Resultado Esperado
        int code = 200;
        String type = "unknown";
        String message = "9999";

        // Executa
        given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when()
                .post(uri + "user")
        // Valida
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(code))
                .body("type", is(type))
                .body("message", is(message))
        ;
    }
}
