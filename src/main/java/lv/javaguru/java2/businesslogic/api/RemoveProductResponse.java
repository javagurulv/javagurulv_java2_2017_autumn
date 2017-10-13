package lv.javaguru.java2.businesslogic.api;

public class RemoveProductResponse {

    private boolean removed;

    public RemoveProductResponse(boolean removed) {
        this.removed = removed;
    }

    public boolean isRemoved() {
        return removed;
    }
}
