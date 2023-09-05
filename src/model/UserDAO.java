/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import assquanlisinhvien.ASSQuanLiSinhVien;
import com.mysql.cj.xdevapi.PreparableStatement;
//import com.sun.jdi.connect.spi.Connection;
import database.DatabaseUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import java.sql.Connection;


public class UserDAO implements Serializable {

//    private static List<User> listUser;
    public User getUserById(String username){
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        User ee = new User();
        try {
       String sSQL = "select  *  from Users where username = ?";
//       conn = (Connection) ASSQuanLiSinhVien.checkConnection();
       conn = (Connection) DatabaseUtil.getDBConnection();
       sttm = conn.prepareStatement(sSQL);
       sttm.setString(  1, username);
       rs = sttm.executeQuery();
       while (rs.next()){
           ee.setUsername(rs.getString(1).trim());
           ee.setPassword(rs.getString(2).trim());
//           ee.setRole(rs.getBoolean(3));
           return ee;
       }
    }catch(Exception e){
            System.out.println("error"+e.toString());
    }finally{
            try{
                conn.close();
                rs.close();
                sttm.close();
            }catch( Exception e){
                
            }
        }
        return  null;
    }

      public boolean checkLogin(String username, String pass) {
       User user = getUserById(username);
       if(user!= null){
           if( user.getPassword().equals(pass)){
               return true;
           }
       }
       return false;
       
    }
      //    public UserDAO() {
//        listUser = new ArrayList<>();
//    }

//    public boolean checkLogin(String username, String password) {
//        listUser = readFromFile();
//        for (User user : listUser) {
//            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public int themUser(User user) {
////        listUser = readFromFile();
////        user.setListStudent(new ArrayList<>());
////        user.setListGrade(new ArrayList<>());
//        listUser.add(user);
////        writerToFile();
////        createUserFile(user.getUsername());
//        return 1;
//    }

//    public void createUserFile(String username) {
//        String fileName = username + ".txt";
//        File file = new File(fileName);
//        try {
//            if (file.createNewFile()) {
//                System.out.println("Tạo file thành công: " + fileName);
//            } else {
//                System.out.println("File đã tồn tại: " + fileName);
//            }
//        } catch (IOException e) {
//            System.out.println("Lỗi khi tạo file: " + e.getMessage());
//        }
//    }

//    public void writerToFile() {
//        try (FileOutputStream fos = new FileOutputStream("users.txt");
//                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
//            oos.writeObject(listUser);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    public List<User> readFromFile() {
//        try (FileInputStream fis = new FileInputStream("users.txt"); 
//                ObjectInputStream ois = new ObjectInputStream(fis)) {
//            listUser = (List<User>) ois.readObject();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return listUser;
//    }

}
