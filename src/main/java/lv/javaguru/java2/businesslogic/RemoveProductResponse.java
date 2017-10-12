package lv.javaguru.java2.businesslogic;

public class RemoveProductResponse {

    private boolean removed;

    public RemoveProductResponse(boolean removed) {
        this.removed = removed;
    }

    public boolean isRemoved() {
        return removed;
    }
}
