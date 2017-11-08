package lv.javaguru.java2.businesslogic;

public class ValidationError {

    private String field;
    private String description;

    public ValidationError(String field, String description) {
        this.field = field;
        this.description = description;
    }

    public String getField() {
        return field;
    }

    public String getDescription() {
        return description;
    }
}
