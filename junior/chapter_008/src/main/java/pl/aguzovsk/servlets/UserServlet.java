package pl.aguzovsk.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.time.*;


/***
 * class UserServlet
 * created 19.07.18
 */
public class UserServlet extends HttpServlet {
    ValidateService service = ValidateService.getInstance();
    /**
     * Show list of all users in the database
     * @param req - servlet hhtp request
     * @param resp - servlet hhttp response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Collection<User> users = service.findAll();
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        for (User user : users) {
            writer.append("<div>"+user.getName()+"</div>");
        }
        writer.flush();
    }

    /**
     * Create, update, delete user
     * @param req - servlet hhtp request
     * @param resp - servlet hhttp response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected  void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String action = req.getParameter("action");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());

        switch(action) {
            case "add" :
                String name = req.getParameter("name");
                String login = req.getParameter("login");
                String email = req.getParameter("email");
                LocalDateTime time = LocalDateTime.now();
                if (service.add(name, login, email, time)) {
                    writer.append(String.format("user: name=%s, login=%s, email=%s, was added.", name, login, email));
                } else {
                    writer.append("error occured, operation: add user");
                }
                break;
            case "update" :
                int id = Integer.parseInt(req.getParameter("id"));
                name = req.getParameter("name");
                if (service.updateName(id, name)) {
                    writer.append("User updated successfully");
                } else {
                    writer.append("error occured during user update");
                }
                break;
            case "delete" :
                id = Integer.parseInt(req.getParameter("id"));
                if (service.delete(id)) {
                    writer.append("user deleted successfully");
                } else {
                    writer.append("user delete failed");
                }
                break;
            default: writer.append("unknown operation: "+action);
        }
        writer.flush();
    }
}
