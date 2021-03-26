package com.sqa.nhom15.SQANhom15.dao;

import com.sqa.nhom15.SQANhom15.resultObject.SinhVien_Diem;

import java.util.List;

public interface TinhDiemDAO {

    public void setDiemSinhVien(List<SinhVien_Diem> lstSinhVienDiem, Integer nhomMH, String maMH);
    //	public Float tinhDiemSinhVien(DiemSo ds);
    public int[] formatCauHinh(String cauHinhDiem);
}