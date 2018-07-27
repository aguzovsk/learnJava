package pl.aguzovsk.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * class UsersController
 * created 26.07.18
 */
public class UsersController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("users", DbStore.getInstance().findAll());
        request.getRequestDispatcher("/WEB-INF/views/UsersView.jsp").forward(request, response);
    }
}
