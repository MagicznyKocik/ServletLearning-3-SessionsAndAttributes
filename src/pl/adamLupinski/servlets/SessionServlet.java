package pl.adamLupinski.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get current session object or create new if non is existing
        request.getSession();

        //write information about getting/creating session succes
        PrintWriter writer = response.getWriter();
        writer.println("Session successfully taken/created");


    }



}
