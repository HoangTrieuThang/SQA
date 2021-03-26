package com.sqa.nhom15.SQANhom15.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="giangvien")
public class GiangVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ma_gv")
    private String maGV;

    @Column(name="ho_ten")
    private String hoTen;

    @ManyToMany(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinTable(
            name="monhoc_giangvien",
            joinColumns = @JoinColumn(name="giangvien_ma_gv"),
            inverseJoinColumns = @JoinColumn(name="nhommonhoc_nhom_monhoc")
    )
    private List<MonHoc> monHocs;

    public List<MonHoc> getMonHocs() {
        return monHocs;
    }

    public void setMonHocs(List<MonHoc> monHocs) {
        this.monHocs = monHocs;
    }

    public GiangVien(String maGV, String hoTen) {
        this.maGV = maGV;
        this.hoTen = hoTen;
    }

    public void themMonHoc(MonHoc tempMonHoc) {
        if(monHocs == null) {
            monHocs = new ArrayList<MonHoc>();
        }
        monHocs.add(tempMonHoc);
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

}
