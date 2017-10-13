package lv.javaguru.java2.businesslogic.api;

public class AddProductRequest {

    private String title;
    private String description;

    public AddProductRequest(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
