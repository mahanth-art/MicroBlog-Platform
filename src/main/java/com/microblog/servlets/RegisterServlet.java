
package com.microblog.servlets;

import com.microblog.dao.UserDAO;
import com.microblog.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        User u = new User();
        u.setUsername(username);
        u.setPassword(password);
        u.setEmail(email);

        boolean ok = userDAO.register(u);
        if (ok) {
            response.sendRedirect("login.jsp?msg=registered");
        } else {
            response.sendRedirect("register.jsp?error=true");
        }
    }
}
