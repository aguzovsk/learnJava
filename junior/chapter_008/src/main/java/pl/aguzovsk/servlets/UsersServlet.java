package pl.aguzovsk.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/***
 * class UsersServlet
 * created 22.07.18
 */
public class UsersServlet extends HttpServlet {
    final ValidateService validateService = ValidateService.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());

        StringBuilder sb = new StringBuilder("<table style='border: 1p solid black;' "
                + "cellpadding='1' cellspacing='1' border='1'>");
        sb.append("<tr>");
        sb.append("<th>User ID</th>");
        sb.append("<th>User name</th>");
        sb.append("<th>User login</th>");
        sb.append("<th>User email</th>");
        sb.append("<th>User creationTime</th>");
        sb.append("</tr>");
        for (User user : validateService.findAll()) {
            sb.append("<tr>");
            sb.append("<td>" + user.getId() + "</td>");
            sb.append("<td>" + user.getName() + "</td>");
            sb.append("<td>" + user.getLogin() + "</td>");
            sb.append("<td>" + user.getEmail() + "</td>");
            sb.append("<td>" + user.getCreationTime() + "</td>");
            sb.append("<td><form action='" + req.getContextPath() + "/edit' method='get'>");
            sb.append("<button type='submit' name='id' value='" + user.getId() + "''>Edit</button></form></td>");
            sb.append("<td><form action='" + req.getContextPath() + "/delete' method='post'>");
            sb.append("<button type='submit' name='userid' value='" + user.getId() + "'>Delete</button></form></td>");
            sb.append("</tr>");
        }
        sb.append("</table>");

        writer.append("<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "    <meta charset=\"UTF-8\">" +
                "    <title>Title</title>" +
                "</head>" +
                "<body>" +
                sb.toString() +
                "</body>" +
                "</html>");
        writer.flush();
    }
}
