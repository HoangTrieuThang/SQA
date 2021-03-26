package com.sqa.nhom15.SQANhom15.resultObject;

import java.util.List;

public class CauHinhDiems {

    private List<MonHoc_CauHinhDiem> listCauHinhDiem;

    public CauHinhDiems(List<MonHoc_CauHinhDiem> listCauHinhDiem) {
        this.listCauHinhDiem = listCauHinhDiem;
    }

    public List<MonHoc_CauHinhDiem> getListCauHinhDiem() {
        return listCauHinhDiem;
    }

    public void setListCauHinhDiem(List<MonHoc_CauHinhDiem> listCauHinhDiem) {
        this.listCauHinhDiem = listCauHinhDiem;
    }

}

