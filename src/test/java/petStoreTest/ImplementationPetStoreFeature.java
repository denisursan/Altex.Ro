package petStoreTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.runner.Request;
import petStore.Pet;
import response.DeletedPetResponse;
import response.PetResponse;
import testImplementation.BaseSetUp;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ImplementationPetStoreFeature {
    private int petId = 23;
    private String baseUrl = "https://petstore.swagger.io/v2";
    private String path = "/pet";
    private String queryParam = "/findByStatus?status=available";
    Response response;
    Pet petresponse;
    String getAllPets = baseUrl + path + queryParam;
    Pet pet;
    Response getSpecificPetResponse;
    Pet updatedPet;
    Response responseUpdatedPet;
    Response deletedResponse;
    Response findBYStatusResponse;
    Response getresponse;
    Response statusGetResponse;

    @Given("I Set Get pet api endpoint")
    public void iSetGetPetApiEndpoint() {
        given().contentType(ContentType.JSON);

    }

    @When("I perform Get operation for pets")
    public void iperformGetOperation() {
        getresponse = when().get(baseUrl + path + queryParam).
                then().statusCode(200).log().all().extract().response();


    }


    @Then("^I receive valid HTTP response code$")
    public void iReceiveValidHTTPResponseCode() {
        assertEquals(getresponse.getStatusCode(), 200);


    }

    @Given("I want to create a new pet with name and status")
    public void iWantToCreateANewPetWithNameAndStatus() {
        pet = new Pet();
        pet.setPetID(23);
        pet.setPetCategory(223, "CaneCorso");
        pet.setPetName("Boris");
        pet.setPetPhotosURL(null);
        pet.setPetTags(256, "to be adopted");
        pet.setPetStatus("available");


    }

    @When("I create the pet resource")
    public void iCreateThePetResource() {
        response = given().when().contentType(ContentType.JSON).body(pet).post(baseUrl + path).then().log().all().extract().response();


    }


    @Then("the pet will be created in the database with the name")
    public void thePetWillBeCreatedInTheDatabaseWithTheName() {
        Pet petResponse = response.getBody().as(Pet.class);
        assertEquals(response.getStatusCode(), 200);
        assertEquals(petResponse.getPetStatus(), "available");
        assertEquals(petResponse.getPetName(), "Boris");
    }


    @Given("I set the request HEADER")
    public void iSetTheRequestHEADER() {
        getSpecificPetResponse = given().contentType(ContentType.JSON).when().get(baseUrl + path + "/" + petId).
                then().statusCode(200).log().all().extract().response();
    }

    @When("I send Get HTTP request")
    public void iSendGetHTTPRequest() {


    }

    @Then("I receive valid HTTP code response")
    public void iReceiveValidHTTPCodeResponse() {
        Pet specificPetResponse = getSpecificPetResponse.getBody().as(Pet.class);
        assertEquals(getSpecificPetResponse.getStatusCode(), 200);


    }

    @And("I receive the pet name")
    public void iReceiveThePetName() {
        Pet specificPetResponse = getSpecificPetResponse.getBody().as(Pet.class);
        assertEquals(specificPetResponse.getPetName(), "Boris");

    }

    @Given("I set a new name and a new CategoryId for the created pet")
    public void iSetANewNameAndANewCategoryIdForTheCreatedPet() {
        updatedPet = new Pet();
        updatedPet.setPetID(petId);
        updatedPet.setPetCategory(20, "CaneCorso");
        updatedPet.setPetName("Rexi");
        updatedPet.setPetPhotosURL(null);
        updatedPet.setPetStatus("available");

    }

    @When("I set a Put Http request")
    public void iSetAPutHttpRequest() {
        responseUpdatedPet = given().when().contentType(ContentType.JSON).body(updatedPet).put(baseUrl + path).then().extract().response();


    }

    @And("I receive valid HTTP code")
    public void iReceiveValidHTTPCode() {
        Pet petUpdatedResponse = responseUpdatedPet.getBody().as(Pet.class);
        assertEquals(responseUpdatedPet.getStatusCode(), 200);
        assertEquals(petUpdatedResponse.getPetName(), "Rexi");


    }

    @Given("I set DElETE pet api endpoint")
    public void iSetDElETEPetApiEndpoint() {
        deletedResponse = given().when().delete(baseUrl + path + "/" + petId).then().extract().response();


    }

    @When("I send DELETE HTTP request")
    public void iSendDELETEHTTPRequest() {
        deletedResponse.getBody().as(DeletedPetResponse.class);
        assertEquals(deletedResponse.getStatusCode(), 200);
    }


    @Then("I receive valid HTTP Response")
    public void iReceiveValidHTTPResponse() {
        assertEquals(deletedResponse.getStatusCode(), 200);
    }

    @Given("I send a new Http get request")
    public void iSendANewHttpGetRequest() {
        given().contentType(ContentType.JSON);


    }

    @When("I receive status code")
    public void iReceiveStatusCode() {
        statusGetResponse = when().get(baseUrl + path + queryParam).
                then().statusCode(200).log().all().extract().response();

    }


    @And("I receive valid code response")
    public void iReceiveValidCodeResponse() {
        assertEquals(statusGetResponse.getStatusCode(), 200);
    }
}





















