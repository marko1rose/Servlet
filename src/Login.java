import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        LoginDAO login = new LoginDAO();

        boolean val;

        try {
            val = login.validate(email, password);
            if(val){
                request.getRequestDispatcher("/index.html").forward(request, response);
            }else{
                System.out.println("Try again!");
                request.getRequestDispatcher("/login.html").forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
