package petStore;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category {
    @JsonProperty("id")
    private int categoryID;
    @JsonProperty("name")
    private String categoryName;
}
