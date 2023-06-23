package com.example.data_crud;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import javax.sql.DataSource;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//import javax.annotation.Resource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

//@Resource(name="jdbc/web_student_tracker")
//    private DataSource dataSource;

    /**
     * *@see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String url = "jdbc:mysql://localhost:3306/web_student_tracker";
        String username = "root";
        String password="";

        PrintWriter out = response.getWriter();
        response.setContentType("text/plain");

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try{
//        myConn = dataSource.getConnection();
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url,username,password);

            String sql = "select * from student";
            myStmt = myConn.createStatement();

            myRs = myStmt.executeQuery(sql);

            while (myRs.next()){
                String email = myRs.getString("email");;
                out.println(email);
            }
        }
        catch (Exception exc){
            exc.printStackTrace();
        }
    }
}
