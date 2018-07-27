package pl.aguzovsk.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/***
 * class UserUpdateController
 * created 26.07.18
 */
public class UserUpdateController extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(UserCreateServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("user", DbStore.getInstance().findById(id));
        request.getRequestDispatcher("/WEB-INF/views/UserUpdateView.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        int id = -1;
        try {
            id = Integer.parseInt(request.getParameter("userid"));
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            e.printStackTrace();
        }
        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        PrintWriter writer = new PrintWriter(response.getOutputStream());
        if (DbStore.getInstance().update(id, name, login, email)) {
            writer.append("user was successfully updated");
            LOG.info("user was successfully updated");
        } else {
            writer.append("user isn't updated, error occurred.");
            LOG.error("user isn't updated, error occurred.");
        }
        writer.flush();
    }
}
