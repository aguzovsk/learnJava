package pl.aguzovsk.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/***
 * class EchoServlet
 * created 19.07.18
 */
public class EchoServlet extends HttpServlet {
    //private static final Logger LOG = LoggerFactory.getLogger(EchoServlet.class);
    List<String> users = new CopyOnWriteArrayList<>();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String login = req.getParameter("login");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append("hello world, " + login);
        writer.flush();
    }


    @Override
    protected  void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String login = req.getParameter("login");
        doGet(req, resp);
    }
}
