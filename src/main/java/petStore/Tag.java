package petStore;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tag {
    @JsonProperty("id")
    private int tagID;
    @JsonProperty("name")
    private String tagName;
}
