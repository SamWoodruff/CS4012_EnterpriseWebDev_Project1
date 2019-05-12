import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "confirmation",
        urlPatterns = "/confirmation")
public class confirmation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("button1") != null) {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else if (request.getParameter("button2") != null) {
            request.getRequestDispatcher("/courseSchedulePage.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
