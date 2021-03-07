package petStore;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Pet {
    @JsonProperty("id")
    private int petID;
    @JsonProperty("category")
    private Category petCategory;
    @JsonProperty ("name")
    private String petName;
    @JsonProperty ("photoUrls")
    private List<String> petPhotosURL;
    @JsonProperty ("tags")
    private List<Tag> petTags;
    @JsonProperty("status")
    private String petStatus;


    public void setPetCategory(int petCategoryId, String petCategoryName){
        petCategory = new Category();
        petCategory.setCategoryID(petCategoryId);
        petCategory.setCategoryName(petCategoryName);
    }
    public void setPetTags(int petTagID, String petTagName){
        petTags = new ArrayList<>();
        Tag petTag = new Tag();
        petTag.setTagID(petTagID);
        petTag.setTagName(petTagName);
        petTags.add(petTag);
    }
}

