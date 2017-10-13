package lv.javaguru.java2.businesslogic.api;

public class AddProductResponse {

    private boolean result;

    public AddProductResponse(boolean result) {
        this.result = result;
    }

    public boolean isResult() {
        return result;
    }
}
