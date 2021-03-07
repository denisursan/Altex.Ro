package petStore;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Tag {
    @JsonProperty("id")
    private int tagID;
    @JsonProperty("name")
    private String tagName;
}
