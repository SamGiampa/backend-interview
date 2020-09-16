package ai.brace.model;

import com.google.gson.annotations.SerializedName;

public class Text implements Comparable<Text>{
    private int id;

    @SerializedName("textdata") //While not super important here -
    // we shouldn't let the json field name dictate our fields (even just for capitalization)
    private String textData;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTextData() {
        return textData;
    }

    public void setTextData(String textData) {
        this.textData = textData;
    }

    @Override
    public int compareTo(Text u) {
        return Integer.compare(getId(),u.getId());
    }
}
