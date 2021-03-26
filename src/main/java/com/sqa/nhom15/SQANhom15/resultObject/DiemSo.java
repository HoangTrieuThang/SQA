package com.sqa.nhom15.SQANhom15.resultObject;

import java.util.List;

public class DiemSo {

    private List<SinhVien_Diem> listSinhVienDiem;

    public DiemSo() {

    }

    public DiemSo(List<SinhVien_Diem> listSinhVienDiem) {
        this.listSinhVienDiem = listSinhVienDiem;
    }

    public List<SinhVien_Diem> getListSinhVienDiem() {
        return listSinhVienDiem;
    }

    public void setListSinhVienDiem(List<SinhVien_Diem> listSinhVienDiem) {
        this.listSinhVienDiem = listSinhVienDiem;
    }

}
