package ai.brace.model;

import com.google.gson.annotations.SerializedName;

public class Text {
    private int id;
    @SerializedName("textdata") //While not super important here -
    // we shouldn't let the json field name dictate our fields (even just for capitalization)
    private String textData;
}
