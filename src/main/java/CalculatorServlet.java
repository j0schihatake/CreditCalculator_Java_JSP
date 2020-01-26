import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorController", urlPatterns = "/")
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String summ = request.getParameter("summText");
        String month = request.getParameter("monthText");
        String url = "start.jsp?summText=" + summ + "&monthText=" + month;
        request.getRequestDispatcher(url).forward(request, response);
    }
}
