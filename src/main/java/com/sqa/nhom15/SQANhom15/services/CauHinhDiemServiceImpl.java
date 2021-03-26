package com.sqa.nhom15.SQANhom15.services;

import com.sqa.nhom15.SQANhom15.dao.CauHinhDiemDAO;
import com.sqa.nhom15.SQANhom15.resultObject.MonHoc_CauHinhDiem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CauHinhDiemServiceImpl implements CauHinhDiemService {

    @Autowired
    private CauHinhDiemDAO cauHinhDiemDAO;

    @Override
    @Transactional
    public List<MonHoc_CauHinhDiem> findAll() {
        return cauHinhDiemDAO.findAll();
    }

    @Override
    @Transactional
    public void updateCauHinhDiem(int maCauHinh, String cauHinhDiem) {
        cauHinhDiemDAO.updateCauHinhDiem(maCauHinh, cauHinhDiem);
    }

    @Override
    @Transactional
    public String findById(String maMH) {
        return cauHinhDiemDAO.findById(maMH);
    }

    @Override
    public boolean checkCauHinh(String cauHinhDiem) {
        return cauHinhDiemDAO.checkCauHinh(cauHinhDiem);
    }

    @Override
    public boolean checkPattern(String cauHinhDiem) {
        return cauHinhDiemDAO.checkPattern(cauHinhDiem);
    }

}

