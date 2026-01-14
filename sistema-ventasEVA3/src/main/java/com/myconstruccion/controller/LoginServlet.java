package com.myconstruccion.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
       
        String user = request.getParameter("txtUser");
        String pass = request.getParameter("txtPass");

         
        String url = "jdbc:mysql://localhost:3306/my_construction";
        String dbUser = "root";
        String dbPass = "admin"; 

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, dbUser, dbPass);
            
         
            String sql = "SELECT * FROM usuarios WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                
                out.println("<html><body>");
                out.println("<script type='text/javascript'>");
                out.println("alert('Bienvenido al Sistema Centralizado de My Construction');");
                out.println("location='home.jsp';"); 
                out.println("</script>");
                out.println("</body></html>");
            } else {
                
                out.println("<html><body>");
                out.println("<h3 style='color:red;'>Error: Usuario o Clave inválidos para My Construction.</h3>");
                out.println("<a href='index.jsp'>Intentar de nuevo</a>");
                out.println("</body></html>");
            }
            
            con.close();
        } catch (Exception e) {
            out.println("Error de conexión: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
