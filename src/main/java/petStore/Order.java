package petStore;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {
    @JsonProperty("id")
    private int orderId;
    @JsonProperty ("petId")
    private int petId;
    @JsonProperty ("quantity")
    private int quantity;
    @JsonProperty ("shipDate")
    private String shipDate;
    @JsonProperty ("status")
    private String status;
    @JsonProperty("complete")
    private boolean complete;


}
