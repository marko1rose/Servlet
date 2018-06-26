import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "/ListUsers")
public class ListUsers extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ListDAO ld = new ListDAO();
        List<User> users = new ArrayList<>();


        try {
            users = ld.returnAll();

            request.setAttribute("list", users);
            request.getRequestDispatcher("list.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
