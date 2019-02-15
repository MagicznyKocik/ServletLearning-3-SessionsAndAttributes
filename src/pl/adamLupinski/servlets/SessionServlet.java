package pl.adamLupinski.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {

    // use this with sending parameters in request  example http://localhost:8080/SessionServlet?firstName=Adam&lastName=Doe


    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get current session object or create new if non is existing
        HttpSession session = request.getSession();

        // creating user session request parameters
        User user = (User) session.getAttribute("user"); // take values from parameter with key "user"
        if (user == null) {
            user = createUser(request);
            if (user != null) {
                session.setAttribute("user", user); // set value user to parameter with key "user"
            }
        }

        sendResponse(response, user);
    }

    // creating user id dont exist
    private User createUser(HttpServletRequest request){
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        if(firstName == null || lastName == null){
            return null;
        } else {
            return new User(firstName, lastName);
        }
    }
    // response to print on the page parameters in this case parameters from object user
    private void sendResponse(HttpServletResponse response, User user) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<h1>Session Test</h1>");
        if (user!=null && user.getFirstName()!=null && user.getLastName()!=null){
            writer.println("<div>   Hello " + user.getFirstName() + " " + user.getLastName() + "</div>");
        } else{
            writer.println("<div> Hello stranger </div>");
        }
        writer.println("</body>");
        writer.println("</html>");

    }



}
