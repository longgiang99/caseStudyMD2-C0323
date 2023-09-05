/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 *
 * @author longg
 */
public class Grade implements Serializable{
    private int id;
    private SinhVien sv;
    private double anhVan,tinHoc,gdtc;

    public Grade() {
    }

    public Grade(int id, SinhVien sv, double anhVan, double tinHoc, double gdtc) {
        this.id = id;
        this.sv = sv;
        this.anhVan = anhVan;
        this.tinHoc = tinHoc;
        this.gdtc = gdtc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SinhVien getSv() {
        return sv;
    }

    public void setSv(SinhVien sv) {
        this.sv = sv;
    }

    public double getAnhVan() {
        return anhVan;
    }

    public void setAnhVan(double anhVan) {
        this.anhVan = anhVan;
    }

    public double getTinHoc() {
        return tinHoc;
    }

    public void setTinHoc(double tinHoc) {
        this.tinHoc = tinHoc;
    }

    public double getGdtc() {
        return gdtc;
    }

    public void setGdtc(double gdtc) {
        this.gdtc = gdtc;
        
    }
    public double getTBC(){
        double tbc = (getAnhVan()+ getTinHoc()+ getGdtc())/3;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String format=  decimalFormat.format(tbc);
        return Double.parseDouble(format);
    }
    public String getXepLoai(){
        String xl = "";
        double tbc = getTBC();
        if (tbc >8) {
            xl = "giỏi";
        }else if(tbc >=7){
            xl = "khá";
            
        }else if (tbc >=5 ){
            xl = "trung bình";
        }else {
            xl = "yếu";
        }
        return xl;
    }
}
