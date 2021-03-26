package com.sqa.nhom15.SQANhom15.dao;

import com.sqa.nhom15.SQANhom15.resultObject.SinhVien_Diem;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class SinhVienDAOImpl implements SinhVienDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<SinhVien_Diem> findByNhomMonHoc(String maMH, Integer nhomMH) {
        Session currentSession = entityManager.unwrap(Session.class);
        // Phai dung kieu du lieu Object, primitive khong dung duoc
        // Lấy danh sách sinh viên dựa trên môn học, nhóm môn học, lấy thêm cả sinh viên chưa có điểm (null)
        Query query = currentSession.createQuery("Select new"
                + " com.qlsv.ptit.tinhdiemptit.resultobject.SinhVien_Diem"
                + "(svmh.sinhVien.maSV, svmh.sinhVien.hoLot, svmh.sinhVien.ten, svmh.sinhVien.tenLop, diem.diemCC, diem.diemGK, diem.diemBTL, diem.diemThi, diem.diemTB)"
                + " from DiemSo diem"
                + " right outer join diem.sinhVienMonHoc svmh"
                + " right outer join svmh.nhomMonHoc nmh"
                + " where nmh.monHoc.maMonHoc = :maMH and nmh.nhomMonHoc = :nhomMH");
        query.setParameter("maMH", maMH);
        query.setParameter("nhomMH", nhomMH);
        List<SinhVien_Diem> listSinhVienDiem = query.getResultList();
        return listSinhVienDiem;
    }

}
