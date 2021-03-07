package petStore;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Category {
    @JsonProperty("id")
    private int categoryID;
    @JsonProperty("name")
    private String categoryName;
}
