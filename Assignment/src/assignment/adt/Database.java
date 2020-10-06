package assignment.adt;
import java.sql.*;

public class Database {
    
    private String db_url = "jdbc:mysql://localhost:3306/assignment";
    private Connection conn;
    private PreparedStatement prepare;
    private ResultSet rs;
    private String query;


    public Database() throws SQLException {
        this.conn = DriverManager.getConnection(db_url, "root", "");
        this.prepare = null;
        this.rs = null;
    }

    public ResultSet runQuery(String query) throws SQLException {
        prepare = conn.prepareStatement(query);
        rs = prepare.executeQuery();
        return rs;
    }



}
