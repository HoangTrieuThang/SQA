package com.sqa.nhom15.SQANhom15.dao;

import com.sqa.nhom15.SQANhom15.resultObject.SinhVien_Diem;

import java.util.List;

public interface SinhVienDAO {

    public List<SinhVien_Diem> findByNhomMonHoc(String maMH, Integer nhomMH);
}