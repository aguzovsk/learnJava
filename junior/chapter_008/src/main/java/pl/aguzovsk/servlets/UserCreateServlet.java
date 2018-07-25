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
 * class UserCreateServlet
 * created 22.07.18
 */
public class UserCreateServlet extends HttpServlet {
    private DbStore store = DbStore.getInstance();
    private static final Logger LOG = LoggerFactory.getLogger(UserCreateServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.sendRedirect(String.format("%s%s/index.jsp", request.getContextPath(), request.getServletPath()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        LocalDateTime time = LocalDateTime.now();
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        if (store.add(name, login, email, time)) {
            writer.append(String.format("user: name=%s, login=%s, email=%s, was added.", name, login, email));
            LOG.info(String.format("user: name=%s, login=%s, email=%s, was added.", name, login, email));
        } else {
            writer.append("error occured, operation: add user");
            LOG.error("error occured, operation: add user");
        }
        writer.flush();
    }
}
