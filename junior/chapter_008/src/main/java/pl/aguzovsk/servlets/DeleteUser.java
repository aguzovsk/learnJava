package pl.aguzovsk.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/***
 * class DeleteUser
 * created 22.07.18
 */
public class DeleteUser extends HttpServlet {
    DbStore store = DbStore.getInstance();
    private static final Logger LOG = LoggerFactory.getLogger(UserCreateServlet.class);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = -1;
        try {
            id = Integer.parseInt(req.getParameter("userid"));
        } catch (Exception e) {
            //e.printStackTrace();
            LOG.error(e.getMessage(), e);
        }
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        if (store.delete(id)) {
            writer.append(String.format("User with id %d was deleted", id));
            LOG.info(String.format("User with id %d was deleted", id));
        } else {
            writer.append(String.format("User with id %d was not found", id));
            LOG.error(String.format("User with id %d was not found", id));
        }
        writer.flush();
    }
}
