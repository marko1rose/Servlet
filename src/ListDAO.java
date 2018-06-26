import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListDAO {

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
            Logger.getLogger(ListDAO.class.getName()).log(Level.SEVERE,null,ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return conn;
    }


    public List<User> returnAll() throws Exception{
        conn = connect();
        List<User> list = new ArrayList<>();

        try{
            ResultSet rs = conn.createStatement().executeQuery("select * from user");
            while(rs.next()){
                User u = new User(rs.getInt("id"), rs.getString("email"), rs.getString("username"), rs.getString("password"));
                list.add(u);
            }
            rs.close();
        }finally {
            conn.close();
        }

        return list;

    }
}
