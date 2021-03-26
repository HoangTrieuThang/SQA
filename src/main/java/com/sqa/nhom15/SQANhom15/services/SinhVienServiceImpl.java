package com.sqa.nhom15.SQANhom15.services;

import com.sqa.nhom15.SQANhom15.dao.SinhVienDAO;
import com.sqa.nhom15.SQANhom15.resultObject.SinhVien_Diem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SinhVienServiceImpl implements SinhVienService {

    @Autowired
    private SinhVienDAO sinhVienDAO;

    @Override
    @Transactional
    public List<SinhVien_Diem> findByNhomMonHoc(String maMH, Integer nhomMH) {
        return sinhVienDAO.findByNhomMonHoc(maMH, nhomMH);
    }

}
