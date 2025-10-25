
package com.microblog.servlets;

import com.microblog.dao.UserDAO;
import com.microblog.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User u = userDAO.findByUsernameAndPassword(username, password);
        if (u != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", u);
            response.sendRedirect("home.jsp");
        } else {
            response.sendRedirect("login.jsp?error=1");
        }
    }
}
