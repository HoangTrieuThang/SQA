package com.sqa.nhom15.SQANhom15.services;

import com.sqa.nhom15.SQANhom15.resultObject.SinhVien_Diem;

import java.util.List;

public interface TinhDIemService {
    public void setDiemSinhVien(List<SinhVien_Diem> lstSinhVienDiem, Integer nhomMH, String maMH);
    //	public Float tinhDiemSinhVien(DiemSo ds);
    public int[] formatCauHinh(String cauHinhDiem);
}
