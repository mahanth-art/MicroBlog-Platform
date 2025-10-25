
Microblog - Minimal Servlet/JSP Microblogging Platform
=====================================================

What is included
----------------
- Simple Java Servlet + JSP webapp (Maven-based) providing:
  - User registration
  - User login
  - Create short posts (280 chars)
  - View feed (all posts)

Files of interest
-----------------
- pom.xml
- src/main/java/com/microblog/servlets/*  - servlets (Register, Login, Post, Logout)
- src/main/java/com/microblog/dao/*       - simple DAO with JDBC (DBUtil, UserDAO, PostDAO)
- src/main/java/com/microblog/models/*    - User and Post models
- src/main/webapp/*.jsp                   - JSP pages (index, register, login, home)
- src/main/webapp/WEB-INF/web.xml         - servlet mappings
- db.sql                                  - SQL to create database and tables

Setup Instructions
------------------
1. Install MySQL and create a database using `db.sql`:
   - Edit db.sql if you want a different DB name.
   - Run: mysql -u root -p < db.sql

2. Update DB credentials:
   - Edit DBUtil.java and set correct USER and PASS for your MySQL installation.

3. Build the project with Maven:
   - mvn clean package
   - This will create microblog.war in the target/ folder.

4. Deploy to Tomcat:
   - Copy target/microblog.war to Tomcat's webapps folder and start Tomcat.
   - Open http://localhost:8080/microblog/

Notes & Improvements
--------------------
- Passwords are stored in plaintext for simplicity. FOR REAL PROJECTS, always hash passwords (BCrypt).
- This project uses plain JDBC for simplicity. You can replace DAO layer with Hibernate later.
- No file upload or image support in this minimal version.
- No pagination or search yet — can be added as enhancements.

