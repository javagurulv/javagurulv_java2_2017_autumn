package lv.javaguru.java2.mvc;

public class MVCModel {

    private String view;
    private Object data;

    public MVCModel(String view, Object data) {
        this.view = view;
        this.data = data;
    }

    public MVCModel(String view) {
        this.view = view;
    }

    public String getView() {
        return view;
    }

    public Object getData() {
        return data;
    }
}
