
<%@ page import="java.util.*,com.microblog.models.Post" %>
<%@ page session="true" %>
<%
    Object user = session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Home</title></head>
<body>
<h2>Home - Microblog</h2>
<form action="post" method="post">
    <textarea name="content" rows="3" cols="50" placeholder="What's happening? (max 280 chars)"></textarea><br/>
    <button type="submit">Post</button>
</form>
<hr/>
<h3>Feed</h3>
<%
    com.microblog.dao.PostDAO dao = new com.microblog.dao.PostDAO();
    List<Post> posts = dao.findAll();
    for (Post p : posts) {
%>
    <div style="border:1px solid #ccc; padding:8px; margin-bottom:8px;">
        <strong><%= p.getUsername() %></strong> - <small><%= p.getCreatedAt() %></small>
        <p><%= p.getContent() %></p>
    </div>
<% } %>

<p><a href="logout">Logout</a></p>
</body>
</html>
