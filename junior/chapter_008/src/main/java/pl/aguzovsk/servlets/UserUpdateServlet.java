package pl.aguzovsk.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/***
 * class UserUpdateServlet
 * created 22.07.18
 */
public class UserUpdateServlet extends HttpServlet {
    private  ValidateService validateService = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        int id = Integer.parseInt(req.getParameter("id"));
        User user = ValidateService.getInstance().findById(id);
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        if (user == null) {
            writer.append("User with such id not found");
            writer.flush();
            return;
        }

        writer.append("<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "    <meta charset=\"UTF-8\">" +
                "    <title>Title</title>" +
                "</head>" +
                "<body>" +
                "<form action='"+req.getContextPath()+req.getServletPath()+"' method='post'>" +
                "<label for='name'>Name: </label>" +
                "<input type='text' id='name' name='name' value='" + user.getName() + "'>"+
                "<label for='login'>Login: </lable>" +
                "<input type='text' id='login' name='login' value='" + user.getLogin() + "'>"+
                "<label for='email'>Email: </label>" +
                "<input type='text' id='email' name='email' value='"+ user.getEmail()+"'>"+
                "<input type='hidden' name='userid' value='"+id+"'>"+
                "<input type='submit'>"+
                "</form>" +
                "</body>" +
                "</html>");
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        int id = -1;
        try {
            id = Integer.parseInt(req.getParameter("userid"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String name = req.getParameter("name");
        String login= req.getParameter("login");
        String email= req.getParameter("email");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append("<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "    <meta charset=\"UTF-8\">" +
                "    <title>Title</title>" +
                "</head>" +
                "<body>" +
                "<div>User: </div>" +
                "<table>" +
                "<tr><td>" +
                id +"</td>" +
                "<td>"+name+"</td>"+
                "<td>"+login+"</td>"+
                "<td>"+email+"</td><tr>"+
                "</table>" +
                (validateService.update(id, name, login, email) ? "Was successfully updated" :
                        "wasn't updated error occurred") +
                "</body>" +
                "</html>");
        writer.flush();

    }
}
