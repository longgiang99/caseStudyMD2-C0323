/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author longg
 */
public class GradeDAO implements Serializable {
    List<Grade> listDiem = new ArrayList<>();
    public int add(Grade d){
        listDiem.add(d);
        writerToFile();
        return 1;
    }
    public List<Grade> getAllGrade(){
        
        return listDiem;
    }
    public Grade getOneGradeByMaSV(String maSV ){
       
        for(Grade d: listDiem ){
            if (d.getSv().getMaSV().equalsIgnoreCase(maSV)) {
                return d;
            }
        }
        return null;
    }
    public int updategrade(Grade dNew){
        for (Grade d : listDiem) {
            if (d.getSv().getMaSV().equalsIgnoreCase(dNew.getSv().getMaSV())) {
                d.setAnhVan(dNew.getAnhVan());
                d.setTinHoc(dNew.getTinHoc());
                d.setGdtc(dNew.getGdtc());
                return 1;
            }
        }
        
        return -1; 
        
    }
    public int delGrade(String masv){
        Grade d = getOneGradeByMaSV(masv);
        if (d!=null) {
            listDiem.remove(d);
            return 1;
        }
        
        return -1;
     
    }
     public void writerToFile() {
        try (FileOutputStream fos = new FileOutputStream("diem.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(listDiem);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readFromFile() {
        try (FileInputStream fis = new FileInputStream("diem.dat"); 
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            listDiem = (List<Grade>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
    
}
