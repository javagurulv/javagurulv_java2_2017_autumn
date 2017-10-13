package lv.javaguru.java2.businesslogic.api;

public class RemoveProductRequest {

    private String title;

    public RemoveProductRequest(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
