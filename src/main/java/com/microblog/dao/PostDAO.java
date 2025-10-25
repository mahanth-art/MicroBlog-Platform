
package com.microblog.dao;

import com.microblog.models.Post;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {
    public boolean create(Post post) {
        String sql = "INSERT INTO posts (user_id, content) VALUES (?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, post.getUserId());
            ps.setString(2, post.getContent());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Post> findAll() {
        List<Post> list = new ArrayList<>();
        String sql = "SELECT p.id, p.content, p.created_at, u.username FROM posts p JOIN users u ON p.user_id = u.id ORDER BY p.created_at DESC";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Post p = new Post();
                p.setId(rs.getInt("id"));
                p.setContent(rs.getString("content"));
                p.setCreatedAt(rs.getTimestamp("created_at"));
                p.setUsername(rs.getString("username"));
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
