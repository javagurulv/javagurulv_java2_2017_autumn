package lv.javaguru.java2.businesslogic.api;

public class AddProductResponse {

    private boolean result;
    private String errorField;
    private String errorMessage;

    public AddProductResponse(boolean result) {
        this.result = result;
    }

    public AddProductResponse(boolean result, String errorField, String errorMessage) {
        this.result = result;
        this.errorField = errorField;
        this.errorMessage = errorMessage;
    }

    public boolean isResult() {
        return result;
    }

    public String getErrorField() {
        return errorField;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
