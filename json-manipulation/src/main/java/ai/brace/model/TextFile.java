package ai.brace.model;

import java.util.Date;
import java.util.List;

public class TextFile {
    private String version;
    private String uuid;
    private Date lastModified;
    private String title;
    private String author;
    private String translator;
    private String releaseDate;
    private String language;
    List<Text> textArray;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date datetime) {
        this.lastModified = datetime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<Text> getTextArray() {
        return textArray;
    }

    public void setTextArray(List<Text> textArray) {
        this.textArray = textArray;
    }
}
