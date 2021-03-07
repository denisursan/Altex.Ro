package response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import petStore.Pet;
@Getter
@Setter

public class DeletedPetResponse extends Pet {
    @JsonProperty("code")
    private int StatusCode;
    @JsonProperty("type")
    private String type;
    @JsonProperty("message")
    private String message;


}
