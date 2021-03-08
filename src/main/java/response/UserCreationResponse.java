package response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import petStore.User;
@Getter
@Setter
public class UserCreationResponse extends User {
    @JsonProperty("code")
   private int code;
    @JsonProperty("type")
   private String Type;
    @JsonProperty("message")
   private String message;

}
