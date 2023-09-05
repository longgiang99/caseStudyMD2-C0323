/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assquanlisinhvien;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import database.DatabaseUtil;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author longg
 */
public class ASSQuanLiSinhVien {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
checkConnection();

    }
    
    
    public static Connection getJDBConnection(){
        String url = "jdbc:mysql://localhost:3306/demo";
        String user = "root";
        String password = "1234%Giang";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ASSQuanLiSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ASSQuanLiSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return null;
    }
    public static void checkConnection(){
        Connection conn = getJDBConnection();
        if(conn!=null){
            System.out.println("thanh cong");
        }else{
            System.out.println("that bai");
        }
    }
//    public static void checkConnection(){
//          var server = "DESKTOP-66OMK4Q\\SQLEXPRESS";
//        var user = "sa";
//        var password = "1234%Giang";
//        var db = "DB_ASS_Java3";
//        var port = 1433;
//        SQLServerDataSource ds = new SQLServerDataSource();
//        ds.setUser(user);
//        ds.setPassword(password);
//        ds.setDatabaseName(db);
//        ds.setServerName(server);
//        ds.setPortNumber(port);
//        ds.setEncrypt(false);
//        try (Connection conn = ds.getConnection()) {
//            System.out.println("ket noi thanh cong");
//            System.out.println(conn.getCatalog() );
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            Logger.getLogger(ASSQuanLiSinhVien.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

}
