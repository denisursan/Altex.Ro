package petStoreTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import petStore.Pet;
import response.DeletedPetResponse;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ImplementationPetStoreFeature {
    private int petId = 23;
    private int pet1Id = 26;
    private String baseUrl = "https://petstore.swagger.io/v2";
    private String path = "/pet";
    private String queryParam = "/findByStatus?status=available";
    Response response;
    Pet pet;
    Pet pet1;
    Pet updatedPet;
    Response deletedResponse;
    Pet updatedpet1;

    @Given("I Set Get pet api endpoint")
    public void iSetGetPetApiEndpoint() {
        given().contentType(ContentType.JSON);

    }

    @When("I perform Get operation for pets")
    public void iperformGetOperation() {
        response = when().get(baseUrl + path + queryParam).
                then().statusCode(200).log().all().extract().response();


    }


    @Then("^I receive valid HTTP response code (.*)$")
    public void iReceiveValidHTTPResponseCode(int code) {
        assertEquals(response.getStatusCode(), 200);


    }

    @Given("^I want to create a new pet with name (.*) and status (.*)$")
    public void iWantToCreateANewPetWithNameAndStatus(String name, String status) {
        pet = new Pet();
        pet.setPetID(23);
        pet.setPetCategory(223, "CaneCorso");
        pet.setPetName(name);
        pet.setPetPhotosURL(null);
        pet.setPetTags(256, "to be adopted");
        pet.setPetStatus(status);


    }

    @When("I create the pet resource")
    public void iCreateThePetResource() {
        response = given().when().contentType(ContentType.JSON).body(pet).post(baseUrl + path).then().log().all().extract().response();


    }


    @Then("^the pet will be created in the database with the name (.*)$")
    public void thePetWillBeCreatedInTheDatabaseWithTheName(String nameCreated) {
        Pet petResponse = response.getBody().as(Pet.class);
        assertEquals(response.getStatusCode(), 200);
        assertEquals(petResponse.getPetStatus(), "available");
        assertEquals(petResponse.getPetName(), nameCreated);
    }


    @Given("I set the request HEADER")
    public void iSetTheRequestHEADER() {
        response = given().contentType(ContentType.JSON).when().get(baseUrl + path + "/" + petId).
                then().statusCode(200).log().all().extract().response();
    }

    @When("I send Get HTTP request")
    public void iSendGetHTTPRequest() {


    }

    @Then("^I receive valid HTTP code (.*) response$")
    public void iReceiveValidHTTPCodeResponse(int code ) {
        Pet specificPetResponse = response.getBody().as(Pet.class);
        assertEquals(response.getStatusCode(), code);


    }

    @And("^I receive the pet name (.*)$")
    public void iReceiveThePetName(String name) {
        Pet specificPetResponse = response.getBody().as(Pet.class);
        assertEquals(specificPetResponse.getPetName(), name);

    }

    @Given("I set a new name (.*) and a new CategoryId (.*) for the created pet$")
    public void iSetANewNameAndANewCategoryIdForTheCreatedPet(String name, int categoryId) {
        updatedPet = new Pet();
        updatedPet.setPetID(petId);
        updatedPet.setPetCategory(categoryId, "CaneCorso");
        updatedPet.setPetName(name);
        updatedPet.setPetPhotosURL(null);
        updatedPet.setPetStatus("available");

    }

    @When("I set a Put Http request")
    public void iSetAPutHttpRequest() {
        response = given().when().contentType(ContentType.JSON).body(updatedPet).put(baseUrl + path).then().extract().response();


    }

    @And("^I receive a valid HTTP code (.*)$")
    public void iReceiveValidHTTPCodeR(int code) {
        Pet petUpdatedResponse = response.getBody().as(Pet.class);
        assertEquals(response.getStatusCode(), code);
        assertEquals(petUpdatedResponse.getPetName(), "Rexi");


    }

    @Given("I set DELETE pet api endpoint")
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
        response = when().get(baseUrl + path + queryParam).
                then().statusCode(200).log().all().extract().response();

    }


    @And("I receive valid status")
    public void iReceiveValidCodeResponse() {
        assertEquals(response.statusCode(), 200);
    }

    @Given("I want to create another  pet")
    public void iWantToCreateAnotherPet() {
        pet1 = new Pet();
        pet1.setPetID(26);
        pet1.setPetCategory(223, "CaneCorso");
        pet1.setPetName("Max");
        pet1.setPetPhotosURL(null);
        pet1.setPetTags(256, "to be adopted");
        pet1.setPetStatus("not available");

    }

    @When("I create the new pet resource")
    public void iCreateTheNewPetResource() {
      response = given().when().contentType(ContentType.JSON).body(pet1).post(baseUrl + path).then().log().all().extract().response();


    }

    @Then("the pet will be created in the database")
    public void thePetWillBeCreatedInTheDatabase() {
        Pet petResponse = response.getBody().as(Pet.class);
        assertEquals(response.getStatusCode(), 200);
        assertEquals(petResponse.getPetStatus(), "not available");
        assertEquals(petResponse.getPetName(), "Max");
    }


    @Given("I set the request HEADER for revious pet created")
    public void iSetTheRequestHEADERForReviousPetCreated() {

        given().contentType(ContentType.JSON);
    }

    @When("I send Get request for specific pet")
    public void iSendGetRequestForSpecificPet() {
        response = given().contentType(ContentType.JSON).when().get(baseUrl + path + "/" + pet1Id).
                then().statusCode(200).log().all().extract().response();

    }

    @Then("^I can see a valid HTTP code (.*) Response$")
    public void iCanSeeAValidHTTPCodeCodeResponse(int code) {
        //Pet specificPetResponse = response.getBody().as(Pet.class);
        assertEquals(response.getStatusCode(), code);


    }

    @And("^The pet name will be (.*)$")
    public void thePetNameWillBeName(String name) {
        Pet specificPetResponse = response.getBody().as(Pet.class);
        assertEquals(specificPetResponse.getPetName(),name);
    }

    @Given("I set the  DElETE pet api endpoint")
    public void iSetTheDElETEPet1ApiEndpoint() {
        response = given().when().delete(baseUrl + path + "/" + pet1Id).then().extract().response();

    }

    @When("I send DELETE  request")
    public void iSendDELETERequest() {
        response.getBody().as(DeletedPetResponse.class);
    }

    @Then("^I receive valid code (.*)$")
    public void iReceiveValidCodeCode(int code) {
        assertEquals(response.getStatusCode(), code);
    }

    @Given("I set a new name and a new Id for category section")
    public void iSetANewNameAndANewIdForCategorySection() {
        updatedpet1 = new Pet();
        updatedpet1.setPetID(pet1Id);
        updatedpet1.setPetCategory(10, "Cat");
        updatedpet1.setPetName("Leila");
        updatedpet1.setPetPhotosURL(null);
        updatedpet1.setPetStatus("not available");

    }

    @When("I set a Put Http request for the previous pet created")
    public void iSetAPutHttpRequestForThePreviousPetCreated() {

        response = given().when().contentType(ContentType.JSON).body(updatedpet1).put(baseUrl + path).then().log().all().extract().response();

    }

    @And("I receive the code request")
    public void iReceiveTheCodeCode() {
         response.getBody().as(Pet.class);
        assertEquals(response.statusCode(),200);
    }
}





















