package pl.aguzovsk.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private DbStore store = DbStore.getInstance();
    private static final Logger LOG = LoggerFactory.getLogger(UserCreateServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.sendRedirect(String.format("%s%s/index.jsp", request.getContextPath(), request.getServletPath()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        int id = -1;
        try {
            id = Integer.parseInt(req.getParameter("userid"));
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            e.printStackTrace();
        }
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        if (store.update(id, name, login, email)) {
            writer.append("user was successfully updated");
            LOG.info("user was successfully updated");
        } else {
            writer.append("user isn't updated, error occurred.");
            LOG.error("user isn't updated, error occurred.");
        }
        writer.flush();
    }
}
