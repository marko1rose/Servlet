import org.w3c.dom.UserDataHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Register")
public class Register extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String name = request.getParameter("username");
        String mail = request.getParameter("email");
        String pass = request.getParameter("password");

        User u = new User(mail, name, pass);

        UserDAO us = new UserDAO();

        try {
            us.register(u);
            request.getRequestDispatcher("/index.html").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }




    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
