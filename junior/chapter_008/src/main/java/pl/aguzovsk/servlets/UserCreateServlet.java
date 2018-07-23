package pl.aguzovsk.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/***
 * class UserCreateServlet
 * created 22.07.18
 */
public class UserCreateServlet extends HttpServlet {
    ValidateService service = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append("<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "    <meta charset=\"UTF-8\">" +
                "    <title>Title</title>" +
                "</head>" +
                "<body>" +
                "<form action='" + req.getContextPath() + "/create' method='post'>" +
                "<label for='name'>Name: </label>" +
                "<input type='text' id='name' name='name'>" +
                "<label for='login'>Login: </lable>" +
                "<input type='text' id='login' name='login'>" +
                "<label for='email'>Email: </label>" +
                "<input type='text' id='email' name='email'>" +
                "<input type='submit'>" +
                "</form>" +
                "</body>" +
                "</html>");
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        LocalDateTime time = LocalDateTime.now();
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        if (service.add(name, login, email, time)) {
            writer.append(String.format("user: name=%s, login=%s, email=%s, was added.", name, login, email));
        } else {
            writer.append("error occured, operation: add user");
        }
        writer.flush();
    }
}
