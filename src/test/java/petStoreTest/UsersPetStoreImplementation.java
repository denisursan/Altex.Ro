package petStoreTest;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.google.gson.Gson;
import io.cucumber.messages.internal.com.google.gson.JsonArray;
import io.cucumber.messages.internal.com.google.gson.JsonPrimitive;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import petStore.User;
import response.UserCreationResponse;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.JSONObject;

import javax.xml.bind.annotation.XmlElement;


public class UsersPetStoreImplementation {

    private String baseUrl = "https://petstore.swagger.io/v2";
    private String path = "/user";
    private int userId = 7;
    User user;
    @XmlElement
    List<User> users= new ArrayList<User>();
    Gson gson = new Gson();
    @Given("I want to create a new user")
    public void iWantToCreateANewUser() {

        user = new User();
        user.setId(userId);
        user.setUserName("BorisCatelul");
        user.setFirstNAme("Boris");
        user.setLastName("Rexi");
        user.setEmail("boris_@yahoo.com");
        user.setPassword("dog");
        user.setUserStatus("available");

        users.add(user);
      String json= gson.toJson(users);
       // users= gson.fromJson(br)

    }
    @When("I POST the created user")
    public void iPOSTTheCreatedUser() {

            Response userResponse = given().when().contentType(ContentType.JSON).body(users).post(baseUrl + path).then().log().all().extract().response();
            UserCreationResponse postResponse = userResponse.as(UserCreationResponse.class);
            assertEquals(postResponse.getMessage(),"7");

        }

    }



