package com.sqa.nhom15.SQANhom15.services;

import com.sqa.nhom15.SQANhom15.resultObject.MonHoc_CauHinhDiem;

import java.util.List;

public interface CauHinhDiemService {
    public List<MonHoc_CauHinhDiem> findAll();
    public void updateCauHinhDiem(int maCauHinh, String cauHinhDiem);
    public String findById(String maMH);
    public boolean checkCauHinh(String cauHinhDiem);
    public boolean checkPattern(String cauHinhDiem);
}
