package petStoreTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import petStore.Order;
import response.DeletedPetResponse;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrdersPetStoreImplementation {

    private String baseUrl = "https://petstore.swagger.io/v2";
    private String path = "/store/order";
    private String pathInventory = "/store/inventory";
    private int orderId = 5;
    Order order;
    Response orderCreatedResponse;
    Response getResponseforASpecificGetOrderRequest;
    Order orderResponse;
    Response deleteOrderResponse;
    Response responseInventory;


    @Given("I want to create a new order with in the database")
    public void iCreateANewOrder() {
        order = new Order();
        order.setOrderId(orderId);
        order.setPetId(48);
        order.setQuantity(1);
        order.setStatus("placed");
        order.isComplete();
        order.setShipDate("2020-07-11T15:55:47.053+0000");

    }

    @When("I POST the created order")
    public void iPerformPostOperationForOrder() {
        orderCreatedResponse = given().when().contentType(ContentType.JSON).body(order).post(baseUrl + path).then().statusCode(200).log().all().extract().response();
    }

    @Then("^the order will be created in the database with a valid HTTP code response (.*)$")
    public void iReceiveAValidHTTPResponse(int code) {
        orderCreatedResponse.getBody().as(Order.class);
        assertEquals(orderCreatedResponse.getStatusCode(), code);

    }

    @Given("I set the  order request")
    public void iSetTheOrderRequest() {

        given().contentType(ContentType.JSON);
    }

    @When("I send Get request for a specific order")
    public void iSendGetRequestForASpecificOrder() {
        getResponseforASpecificGetOrderRequest = when().get(baseUrl + path + "/" + orderId).then().log().all().extract().response();

    }

    @Then("^I receive valid HTTP code (.*) response for order request$")
    public void iReceiveValidHTTPCodeResponseForOrderRequest(int code) {
        orderResponse = getResponseforASpecificGetOrderRequest.getBody().as(Order.class);
        assertEquals(getResponseforASpecificGetOrderRequest.getStatusCode(), code);
    }

    @And("^I verify the order by Id (.*)$")
    public void iVerifyTheOrderById(int id) {
        assertEquals(orderResponse.getOrderId(), id);

    }


    @Given("I want to delete the created order")
    public void iWantToDeleteTheCreatedOrder() {
        given().contentType(ContentType.JSON);


    }

    @When("I set a Delete Http request for the created order")
    public void iSetADeleteHttpRequestForTheCreatedOrder() {
        deleteOrderResponse = when().delete(baseUrl + path + "/" + orderId);


    }

    @Then("^I receive delete validation for the order as an HTTP code (.*)$")
    public void iReceiveDeleteValidationForTheOrderAsAnHTTPCode(int code) {
        assertEquals(deleteOrderResponse.getStatusCode(), code);
    }


    @Given("I want to get the deleted order")
    public void iWantToGetTheDeletedOrder() {
        given().contentType(ContentType.JSON);

    }

    @When("I perform Get operation for specific order")
    public void iPerformGetOperationForSpecificOrder() {
        getResponseforASpecificGetOrderRequest = when().get(baseUrl + path + "/" + orderId).then().log().all().extract().response();
    }

    @Then("^The response code  will be (.*)$")
    public void theResponseCodeWillBeCode(int code) {
        assertEquals(getResponseforASpecificGetOrderRequest.getStatusCode(), code);


    }

    @Given("I want to get the inventory")
    public void iWantToGetTheInventory() {

        given().contentType(ContentType.JSON);
    }

    @When("I perform Get operation")
    public void iPerformGetOperation() {
        responseInventory = when().get(baseUrl + pathInventory).then().log().all().extract().response();

    }

    @And("^I receive a valid response code (.*)$")
    public void iReceiveAValidResponseCode(int code) {
        assertEquals(responseInventory.statusCode(), code);

    }
}
