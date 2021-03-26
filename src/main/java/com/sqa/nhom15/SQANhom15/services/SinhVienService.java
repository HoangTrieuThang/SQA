package com.sqa.nhom15.SQANhom15.services;

import com.sqa.nhom15.SQANhom15.resultObject.SinhVien_Diem;

import java.util.List;

public interface SinhVienService {
    public List<SinhVien_Diem> findByNhomMonHoc(String maMH, Integer nhomMH);
}

