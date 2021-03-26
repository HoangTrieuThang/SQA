package com.sqa.nhom15.SQANhom15.dao;

import com.sqa.nhom15.SQANhom15.resultObject.MonHoc_CauHinhDiem;

import java.util.List;

public interface CauHinhDiemDAO {

    public List<MonHoc_CauHinhDiem> findAll();
    public void updateCauHinhDiem(int maCauHinh, String cauHinhDiem);
    public String findById(String maMH);
    public boolean checkCauHinh(String cauHinhDiem);
    public boolean checkPattern(String cauHinhDiem);
}
