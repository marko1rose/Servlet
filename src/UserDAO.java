import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO {

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
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE,null,ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return conn;
    }

    public void register(User u) throws Exception{
        conn = connect();

        try {

            String sql = "insert into user(email, username, password) values (?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, u.getEmail());
            stmt.setString(2, u.getUsername());
            stmt.setString(3, u.getPassword());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            while (rs.next()) {
                u.setId(rs.getInt(1));

            }

            rs.close();

        }finally{
            conn.close();
        }

        }





   /* public List<User> returnAll() throws Exception{
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

    public void deleteUser(int id) throws Exception{
        conn = connect();

        try{
            PreparedStatement ps = conn.prepareStatement("delete from user where id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();


        }finally{
            conn.close();
        }
    }

    public void deleteAll() throws Exception{
        conn = connect();

        try {
            PreparedStatement ps = conn.prepareStatement("delete from user");
            ps.execute();
        }finally {
            conn.close();
        }
    }*/
}
