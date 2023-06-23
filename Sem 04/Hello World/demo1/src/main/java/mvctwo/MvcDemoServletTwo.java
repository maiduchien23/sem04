package mvctwo;
import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.*;

/**
 * Servlet implementation class MvcDemoServletTwo
 */
@WebServlet("/MvcDemoServletTwo")
public class MvcDemoServletTwo extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public MvcDemoServletTwo(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = StudentDataUtil.getStudents();

        request.setAttribute("studentList", studentList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view_students-two.jsp");

        dispatcher.forward(request, response);
    }
}