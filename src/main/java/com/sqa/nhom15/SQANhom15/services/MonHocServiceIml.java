package com.sqa.nhom15.SQANhom15.services;

import com.sqa.nhom15.SQANhom15.dao.MonHocDAO;
import com.sqa.nhom15.SQANhom15.model.MonHoc;
import com.sqa.nhom15.SQANhom15.model.NhomMonHoc;
import com.sqa.nhom15.SQANhom15.resultObject.MonHocs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MonHocServiceIml implements MonHocService {

    @Autowired
    private MonHocDAO monHocDAO;

    @Override
    @Transactional
    public List<MonHocs> findById(String maMH, Integer nhomMH) {
        return monHocDAO.findById(maMH, nhomMH);
    }

    @Override
    @Transactional
    public List<MonHoc> findMonHocDropDown() {
        return monHocDAO.findMonHocDropDown();
    }

    @Override
    @Transactional
    public List<NhomMonHoc> findNhomMonHocDropDown(String maMH) {
        return monHocDAO.findNhomMonHocDropDown(maMH);
    }

}

