package pl.aguzovsk.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/***
 * class UserCreateController
 * created 27.07.18
 */
public class UserCreateController extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(UserCreateServlet.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.getRequestDispatcher("/WEB-INF/views/UserCreateView.jsp");
        request.getRequestDispatcher("/WEB-INF/views/UserCreateView.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        LocalDateTime time = LocalDateTime.now();
        PrintWriter writer = new PrintWriter(response.getOutputStream());
        if (DbStore.getInstance().add(name, login, email, time)) {
            writer.append(String.format("user: name=%s, login=%s, email=%s, was added.", name, login, email));
            LOG.info(String.format("user: name=%s, login=%s, email=%s, was added.", name, login, email));
        } else {
            writer.append("error occured, operation: add user");
            LOG.error("error occured, operation: add user");
        }
        writer.flush();
    }
}
