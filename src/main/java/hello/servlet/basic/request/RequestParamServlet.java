package hello.servlet.basic.request;


import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.util.Enumeration;

/**
 * 1. send param
 * http://localhost:8080/request-param?username=hello&age=20
 *
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("RequestParamServlet.service start");
        req.getParameterNames().asIterator()
                        .forEachRemaining(paramName -> System.out.println(paramName + " : " + req.getParameter(paramName)));
        System.out.println("RequestParamServlet.service end");
        System.out.println();

        System.out.println("Single param Start");
        String username = req.getParameter("username");
        String age = req.getParameter("age");
        System.out.println("username: " + username + ", age: " + age);
        System.out.println("Single param End");
        System.out.println();

        System.out.println("Same param Start");
        String[] usernames = req.getParameterValues("username");
        for (String s : usernames) {
            System.out.println("s : " + s);
        }
        System.out.println("Same param End");

        System.out.println("ok");
    }
}
