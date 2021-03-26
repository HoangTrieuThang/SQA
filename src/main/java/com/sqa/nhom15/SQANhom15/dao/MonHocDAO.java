package com.sqa.nhom15.SQANhom15.dao;

import com.sqa.nhom15.SQANhom15.model.MonHoc;
import com.sqa.nhom15.SQANhom15.model.NhomMonHoc;
import com.sqa.nhom15.SQANhom15.resultObject.MonHocs;

import java.util.List;

public interface MonHocDAO {

    public List<MonHocs> findById(String maMH, Integer nhomMH);
    public List<MonHoc> findMonHocDropDown();
    public List<NhomMonHoc> findNhomMonHocDropDown(String maMH);
}
