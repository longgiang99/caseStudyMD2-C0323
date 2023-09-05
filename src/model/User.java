/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author longg
 */
public class User  implements Serializable{
    private String username;
    private String password;
    private boolean role;
    private String phone;
    private List<SinhVien> listStudent;
    private List<Grade> listGrade; 

   
    public void addStudents(SinhVien sinhVien){
        listStudent.add(sinhVien);
    }
    public void addGrades(Grade grade){
        listGrade.add(grade);
    }

    public User() {
    }

    public List<SinhVien> getListStudent() {
        return listStudent;
    }

    public void setListStudent(List<SinhVien> listStudent) {
        this.listStudent = listStudent;
    }

    public List<Grade> getListGrade() {
        return listGrade;
        
    }

    public void setListGrade(List<Grade> listGrade) {
        this.listGrade = listGrade;
    }

    public User(String username, String password, boolean role,String phone) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }
    

    
    
}
