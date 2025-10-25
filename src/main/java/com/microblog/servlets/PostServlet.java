
package com.microblog.servlets;

import com.microblog.dao.PostDAO;
import com.microblog.models.Post;
import com.microblog.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class PostServlet extends HttpServlet {
    private PostDAO postDAO = new PostDAO();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        User u = (User) session.getAttribute("user");
        String content = request.getParameter("content");
        if (content != null && content.length() > 0 && content.length() <= 280) {
            Post p = new Post();
            p.setUserId(u.getId());
            p.setContent(content);
            postDAO.create(p);
        }
        response.sendRedirect("home.jsp");
    }
}
