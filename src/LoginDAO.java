import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginDAO {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/user";

    static final String USER = "root";
    static final String PASS = "root";

    Connection conn;

    public Connection connect(){

        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER,PASS);
        }catch (SQLException ex){
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE,null,ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return conn;
    }

    public  boolean validate(String email, String password) throws Exception{

        conn = connect();

        boolean status;

        try {

            String sql = "select email,password from user where email = ? and password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);


            ResultSet rs = stmt.executeQuery();

            status = rs.next();

            rs.close();

        }finally{
            conn.close();
        }


        return status;
    }
}
