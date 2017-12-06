package lv.javaguru.java2.mvc;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class HelloWorldController implements MVCController {

    @Override
    public MVCModel processGet(HttpServletRequest request) {
        return new MVCModel("/helloWorld.jsp", "Hello from MVC!");
    }

    @Override
    public MVCModel processPost(HttpServletRequest request) {
        return null;
    }

}
