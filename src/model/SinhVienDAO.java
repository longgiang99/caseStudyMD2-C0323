/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
//import com.sun.jdi.connect.spi.Connection;
import database.DatabaseUtil;
import java.sql.*;
import java.sql.Connection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author longg
 */
public class SinhVienDAO implements Serializable {

    SimpleDateFormat format_date = new SimpleDateFormat("yyyy/MM/dd");

    public static List<SinhVien> listSinhVien = new ArrayList<>();

//    public int add(SinhVien sv) {
//        listSinhVien.add(sv);
//      
//        return 1;
//    }
    public int add(SinhVien sv) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            String sSQL = "insert into SinhVien(MaSv,TenSV,NgaySinh,GioiTinh,DiaChi,HinhAnh) values (?,?,?,?,?,?)";
            con = DatabaseUtil.getDBConnection();
            ps = con.prepareStatement(sSQL);
            ps.setString(1, sv.getMaSV());
            ps.setString(2, sv.getTenSN());
            ps.setString(3, format_date.format(sv.getNgaySinh()));
            ps.setBoolean(4, sv.isGioiTinh());
            ps.setString(5, sv.getDiaChi());
            ps.setString(6, sv.getHinhAnh());
            if (ps.executeUpdate() > 0) {
                System.out.println("them thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("error" + e.toString());
        } finally {
            try {
                con.close();
                ps.close();
            } catch (Exception e) {

            }
        }
        return -1;//khong thanh cong
    }

    public int capNhatThongTinSinhVienTheoID(SinhVien sv) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            String sSQL = "update SinhVien set TenSV=?,NgaySinh=?,GioiTinh=?,DiaChi=?,HinhAnh=? where MaSv =?";
            con = DatabaseUtil.getDBConnection();
            ps = con.prepareStatement(sSQL);
            ps.setString(1, sv.getMaSV());
            ps.setString(2, sv.getTenSN());
            ps.setString(3, format_date.format(sv.getNgaySinh()));
            ps.setString(4, sv.getMaSV());
            ps.setString(5, sv.getMaSV());
            ps.setString(6, sv.getMaSV());
            if (ps.executeUpdate() > 0) {
                System.out.println("cap nhat thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("error" + e.toString());
        } finally {
            try {
                con.close();
                ps.close();
            } catch (Exception e) {
            }
        }
        return -1;//khong thanh cong
    }

    public int xoaSinhVienTheoID(String maSV) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            String sSQL = "delete SinhVien where MaSv =?";
            con = DatabaseUtil.getDBConnection();
            ps = con.prepareStatement(sSQL);
            ps.setString(1, maSV);

            if (ps.executeUpdate() > 0) {
                System.out.println("xoa thanh cong");
                return 1;
            }

        } catch (Exception e) {
            System.out.println("error" + e.toString());
        } finally {
            try {
                con.close();
                ps.close();
            } catch (Exception e) {

            }
        }
        return -1;//khong thanh cong
    }

    public List<SinhVien> getAllSinhVien() {
        List<SinhVien> ls = new ArrayList<>();
        Connection con = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "select * from SinhVien";
            con = DatabaseUtil.getDBConnection();
            sttm = con.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                SinhVien sv = new SinhVien();
                sv.setMaSV(rs.getString(1));
                sv.setTenSN(rs.getString(2));
                sv.setNgaySinh(rs.getDate(3));
                sv.setGioiTinh(rs.getBoolean(4));
                sv.setDiaChi(rs.getString(5));
                sv.setHinhAnh(rs.getString(6));
                ls.add(sv);
            }
        } catch (Exception e) {
            System.out.println("error" + e.toString());
        } finally {
            try {
                con.close();
                sttm.close();
                rs.close();
            } catch (Exception e) {
            }
        }
        return ls;
    }

    public SinhVien traVeSinhVienTheoID(String maSV) {

        Connection con = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        SinhVien sv = new SinhVien();

        try {
            String sSQL = "select * from SinhVien where MaSV =?";
            con = DatabaseUtil.getDBConnection();
            sttm = con.prepareStatement(sSQL);
            sttm.setString(1, maSV);
            rs = sttm.executeQuery();
            while (rs.next()) {
                 sv.setMaSV(rs.getString(1));
                sv.setTenSN(rs.getString(2));
                sv.setNgaySinh(rs.getDate(3));
                sv.setGioiTinh(rs.getBoolean(4));
                sv.setDiaChi(rs.getString(5));
                sv.setHinhAnh(rs.getString(6));
              return  sv;
            }
        } catch (Exception e) {
            System.out.println("error" + e.toString());
        } finally {
            try {
                con.close();
                sttm.close();
                rs.close();
            } catch (Exception e) {
            }
        }
        return sv;
    }

//    public void createSinhVienFile(String sinhvien) {
//        String fileName = sinhvien + "sinh_vien" + ".txt";
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
//    public List<SinhVien> getAllSinhVien() {
//
//        return listSinhVien;
//
//    }
//    public int xoaSinhVienTheoID(String ma) {
//
//        for (SinhVien sv : listSinhVien) {
//            if (sv.getMaSV().equalsIgnoreCase(ma)) {
//                listSinhVien.remove(sv);
//
//                return 1;
//            }
//        }
//        return -1;
//    }
//    public SinhVien traVeSinhVienTheoID(String id) {
//
//        for (SinhVien sv : listSinhVien) {
//            if (sv.getMaSV().equalsIgnoreCase(id)) {
//                return sv;
//            }
//        }
//        return null;
//    }

//    public int capNhatThongTinSinhVienTheoID(SinhVien svNew) {
//        for (SinhVien sv : listSinhVien) {
//            if (sv.getMaSV().equalsIgnoreCase(svNew.getMaSV())) {
//                sv.setDiaChi(svNew.getDiaChi());
//                sv.setGioiTinh(svNew.isGioiTinh());
//                sv.setHinhAnh(svNew.getHinhAnh());
//                sv.setNgaySinh(svNew.getNgaySinh());
//                sv.setTenSN(svNew.getTenSN());
//                return 1;
//            }
//        }
//
//        return -1;
//    }
//    public void writerToFile() {
//        try (FileOutputStream fos = new FileOutputStream("sinhvien.txt"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
//
//            oos.writeObject(listSinhVien);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    public void readFromFile() {
//        try (FileInputStream fis = new FileInputStream("users.dat"); ObjectInputStream ois = new ObjectInputStream(fis)) {
//            listSinhVien = (List<SinhVien>) ois.readObject();
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//
//    }
}
