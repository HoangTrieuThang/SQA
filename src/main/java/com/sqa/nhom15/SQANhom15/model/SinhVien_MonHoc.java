package com.sqa.nhom15.SQANhom15.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="sinhvien_monhoc")
public class SinhVien_MonHoc {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne(fetch=FetchType.LAZY, cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="sinhvien_ma_sv")
    private SinhVien sinhVien;

    @ManyToOne(fetch=FetchType.LAZY, cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="nhommonhoc_id")
    private NhomMonHoc nhomMonHoc;


    @OneToMany(mappedBy = "sinhVienMonHoc", cascade = CascadeType.ALL)
    private List<DiemSo> lstDiemSo;

    public SinhVien_MonHoc() {

    }

    public SinhVien_MonHoc(SinhVien sinhVien, NhomMonHoc nhomMonHoc, List<DiemSo> lstDiemSo) {
        this.sinhVien = sinhVien;
        this.nhomMonHoc = nhomMonHoc;
        this.lstDiemSo = lstDiemSo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public NhomMonHoc getNhomMonHoc() {
        return nhomMonHoc;
    }

    public void setNhomMonHoc(NhomMonHoc nhomMonHoc) {
        this.nhomMonHoc = nhomMonHoc;
    }

    public List<DiemSo> getLstDiemSo() {
        return lstDiemSo;
    }

    public void setLstDiemSo(List<DiemSo> lstDiemSo) {
        this.lstDiemSo = lstDiemSo;
    }

}
