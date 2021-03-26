package com.sqa.nhom15.SQANhom15.services;

import com.sqa.nhom15.SQANhom15.dao.TinhDiemDAO;
import com.sqa.nhom15.SQANhom15.resultObject.SinhVien_Diem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Scope("prototype")
public class TinhDiemServiceImpl implements TinhDIemService {

    @Autowired
    private TinhDiemDAO tinhDiemDAO;

    @Override
    @Transactional
    public void setDiemSinhVien(List<SinhVien_Diem> lstSinhVienDiem, Integer nhomMH, String maMH) {
        tinhDiemDAO.setDiemSinhVien(lstSinhVienDiem, nhomMH, maMH);
    }

//	@Override
//	public Float tinhDiemSinhVien(DiemSo ds) {
//		return tinhDiemDAO.tinhDiemSinhVien(ds);
//	}

    @Override
    public int[] formatCauHinh(String cauHinhDiem) {
        return tinhDiemDAO.formatCauHinh(cauHinhDiem);
    }

}

