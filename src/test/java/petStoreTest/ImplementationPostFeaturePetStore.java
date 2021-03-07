package petStoreTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import petStore.Pet;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class ImplementationPostFeaturePetStore {
//    private String baseUrl = "https://petstore.swagger.io/v2";
//    private String path = "/pet";
//    private String queryParam = "/findByStatus?status=available";
//    Pet pet;
//    Response response;
//
//    @Given("I want to create a new pet with name and status")
//    public void iWantToCreateANewPetWithNameAndStatus() {
//        pet = new Pet();
//        pet.setPetID(22);
//        pet.setPetCategory(223, "CaneCorso");
//        pet.setPetName("Boris");
//        pet.setPetPhotosURL(null);
//        pet.setPetTags(256, "to be adopted");
//        pet.setPetStatus("available");
//
//
//    }
//
//    @When("I create the pet resource")
//    public void iCreateThePetResource() {
//         response = given().when().contentType(ContentType.JSON).body(pet).post(baseUrl + path).then().log().all().extract().response();
//
//
//
//    }
//
//
//    @Then("the pet will be created in the database with the name")
//    public void thePetWillBeCreatedInTheDatabaseWithTheName() {
//        Pet petResponse = response.getBody().as(Pet.class);
//        assertEquals(response.getStatusCode(), 200);
//        assertEquals(petResponse.getPetStatus(), "available");
//        assertEquals(petResponse.getPetName(),"Boris");
//    }
//}
