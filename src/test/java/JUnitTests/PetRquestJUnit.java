package JUnitTests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import petStore.Pet;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetRquestJUnit {
    private String baseUrl = "https://petstore.swagger.io/v2";
    private String path = "/pet";
    private String queryParam = "/findByStatus?status=available";
    private int petID = 555;
    @Test
    @Order(1)
    public void checkPetEndPoint() {
        given().when().get(baseUrl + path + queryParam).then().statusCode(200);
    }
    @Test
    @Order(2)
    public void createPet() {
        //serializare
        Pet pet = new Pet();
        pet.setPetID(petID);
        pet.setPetCategory(223, "Hamsters");
        pet.setPetName("Alex");
        pet.setPetPhotosURL(null);
        pet.setPetTags(546, "to be adopted");
        pet.setPetStatus("available");
        Response response = given().when().contentType(ContentType.JSON).body(pet).post(baseUrl + path).then().extract().response();
        //deserializare
        Pet petResponse = response.getBody().as(Pet.class);
        assertEquals(response.getStatusCode(), 200);
        assertEquals(petResponse.getPetStatus(), "available");
    }
    @Test
    @Order(3)
    public void updatePet() {
        Pet updatedPet = new Pet();
        updatedPet.setPetID(petID);
        updatedPet.setPetCategory(223, "Hamsters");
        updatedPet.setPetName("Gicu");
        updatedPet.setPetPhotosURL(null);
        updatedPet.setPetTags(111, "adopted");
        updatedPet.setPetStatus("sold");
        Response response = given().when().contentType(ContentType.JSON).body(updatedPet).put(baseUrl + path).then().extract().response();
        //deserializare
        Pet petResponse = response.getBody().as(Pet.class);
        assertEquals(response.getStatusCode(), 200);
        assertEquals(petResponse.getPetStatus(), "sold");
    }
//    @Test
//    @Order(4)
//    public void deletePet() {
////        Response response = given().when().delete(baseUrl + path + "/" + petID).then().extract().response();
////        //deserializare
////        DeletedPetResponse deletedPetResponse = response.getBody().as(DeletedPetResponse.class);
////        assertEquals(response.getStatusCode(), 200);
////        //Cast no longer necessary: String deleteResponse = String.valueOf(deletedPetResponse.getMessage());
////        assertEquals(deletedPetResponse.getMessage(), "555");
////    }
//    @Test
//    @Order(5)
//    public void checkThatPetWasDeleted() {
////        Response response = given().when().get(baseUrl + path + "/" + petID).then().extract().response();
////        //deserializare
////        DeletedPetResponse deletedPetResponse = response.getBody().as(DeletedPetResponse.class);
////        assertEquals(response.getStatusCode(), 404);
////        String deleteResponse = deletedPetResponse.getMessage();
////        assertEquals(deleteResponse, "Pet not found");
////    }
}



