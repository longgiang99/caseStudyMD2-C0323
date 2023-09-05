package database;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    
//    public static void main(String[] args) {
//        getDBConnection();
//    }
    
    public static final String ConnectionUrl = "jdbc:sqlserver://DESKTOP-66OMK4Q\\SQLEXPRESS:1433;"
            + "databaseName=DB_ASS_Java3;user=sa;password=12324%Giang;encrypt=false";

    public static Connection getDBConnection() {
    try {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("1234%Giang");
        ds.setDatabaseName("DB_ASS_Java3");
        ds.setServerName("DESKTOP-66OMK4Q\\SQLEXPRESS");
        ds.setPortNumber(1433);
        ds.setEncrypt(false);
        Connection conn = ds.getConnection();
        System.out.println("Kết nối thành công đến cơ sở dữ liệu.");
        return conn;
    } catch (SQLException ex) {
        System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
        System.out.println("Lỗi: " + ex.getMessage());
    }
    return null;
}
    
    
//    public static Connection getDBConnection() {
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            Connection conn = DriverManager.getConnection(ConnectionUrl);
//            System.out.println("Kết nối thành công đến cơ sở dữ liệu.");
//            return conn;
//        } catch (ClassNotFoundException ex) {
//            System.out.println("Không tìm thấy lớp JDBC driver.");
//            System.out.println("Lỗi: " + ex.getMessage());
//        } catch (SQLException e) {
//            System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
//            System.out.println("Lỗi: " + e.getMessage());
//        }
//        return null;
//    }
}