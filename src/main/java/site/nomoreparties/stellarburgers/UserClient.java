package site.nomoreparties.stellarburgers;

import io.restassured.response.ValidatableResponse;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UserClient extends  RestClient {

    private static final String AUTH_PATH = "/api/auth/register";
    private static final String LOGIN_PATH = "/api/auth/login";
    private static final String EDIT_AND_DELETE_USER_PATH = "/api/auth/user";

    public ValidatableResponse create(User user){
       return given()
                .spec(getBaseSpec())
                .body(user)
                .when()
                .post(AUTH_PATH)
                .then();
    }

    public ValidatableResponse login(UserCredentials userCredentials){
        return given()
                .spec(getBaseSpec())
                .body(userCredentials)
                .when()
                .post(LOGIN_PATH)
                .then();
    }

    public ValidatableResponse delete(String token){
        return given()
                .spec(getBaseSpec())
                .header("authorization", token)
                .and()
                .delete(EDIT_AND_DELETE_USER_PATH)
                .then();
    }

}
