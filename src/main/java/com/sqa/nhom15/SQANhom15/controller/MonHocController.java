package com.sqa.nhom15.SQANhom15.controller;

import com.sqa.nhom15.SQANhom15.model.MonHoc;
import com.sqa.nhom15.SQANhom15.model.NhomMonHoc;
import com.sqa.nhom15.SQANhom15.resultObject.DiemSo;
import com.sqa.nhom15.SQANhom15.resultObject.MonHocs;
import com.sqa.nhom15.SQANhom15.resultObject.SinhVien_Diem;
import com.sqa.nhom15.SQANhom15.services.CauHinhDiemService;
import com.sqa.nhom15.SQANhom15.services.MonHocService;
import com.sqa.nhom15.SQANhom15.services.SinhVienService;
import com.sqa.nhom15.SQANhom15.services.TinhDIemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@ResponseBody

@RequestMapping("/monhoc")
public class MonHocController {

    @Autowired
    private MonHocService monHocService;

    @Autowired
    private SinhVienService sinhVienService;

    @Autowired
    private CauHinhDiemService cauHinhDiemService;

    @Autowired
    private TinhDIemService tinhDiemService;

    @GetMapping(value= {"", "/{maMonHoc}", "/{maMonHoc}/{nhomMonHoc}"})
    public String getListMonHocTheoNhom(Model model, @PathVariable(required = false) String maMonHoc,
                                        @PathVariable(required = false) Integer nhomMonHoc) {
        List<MonHoc> listMonHoc = monHocService.findMonHocDropDown();
        model.addAttribute("listMonHoc", listMonHoc);
        if (maMonHoc != null) {
            List<NhomMonHoc> listNhomMonHoc = monHocService.findNhomMonHocDropDown(maMonHoc);
            List<MonHocs> listMonHocs = monHocService.findById(maMonHoc, nhomMonHoc);
            String cauHinhDiem = cauHinhDiemService.findById(maMonHoc);
            model.addAttribute("cauHinhDiem", cauHinhDiem);
            model.addAttribute("selectedId", maMonHoc);
            model.addAttribute("listNhomMonHoc", listNhomMonHoc);
            model.addAttribute("listMonHocs", listMonHocs);
            if (nhomMonHoc != null) {
                model.addAttribute("selectedNhom", nhomMonHoc);
            }
        }
        return "/monhoc/danhsachmonhoc";
    }

    @GetMapping("/{maMonHoc}/{nhomMonHoc}/dssv")
    public String getListSinhVienTheoNhom(Model model,
                                          @PathVariable String maMonHoc,
                                          @PathVariable Integer nhomMonHoc,
//			@RequestParam(name = "maMonHoc", required = false) String maMonHoc,
//			@RequestParam(name = "nhomMH", required = false) Integer nhomMonHoc,
                                          @RequestParam(name = "tenMH", required = false) String tenMH,
                                          @RequestParam(name = "giangVien", required = false) String giangVien,
                                          @RequestParam(name = "cauHinhDiem", required = false) String cauHinhDiem) {
        List<SinhVien_Diem> listSinhVienDiem = sinhVienService.findByNhomMonHoc(maMonHoc, nhomMonHoc);
        if(!cauHinhDiem.isEmpty()) {
            tinhDiemService.formatCauHinh(cauHinhDiem);
            tinhDiemService.setDiemSinhVien(listSinhVienDiem, nhomMonHoc, maMonHoc);
        }
        DiemSo lst = new DiemSo(sinhVienService.findByNhomMonHoc(maMonHoc, nhomMonHoc));
        model.addAttribute("lst", lst);
        model.addAttribute("nhomMH", nhomMonHoc);
        model.addAttribute("giangVien", giangVien);
        model.addAttribute("tenMH", tenMH);
        model.addAttribute("cauHinhDiem", cauHinhDiem);
        model.addAttribute("maMonHoc", maMonHoc);
        return "/sinhvien/danhsachsinhvien";
    }

    @PostMapping("/{maMonHoc}/{nhomMonHoc}/dssv/saveDiemSo")
    public String saveDiemSinhVien(Model model, RedirectAttributes ra, @ModelAttribute("lst") DiemSo lst,
                                   @PathVariable Integer nhomMonHoc, @PathVariable String maMonHoc,
                                   @RequestParam("tenMH") String tenMH, @RequestParam("giangVien") String giangVien,
                                   @RequestParam("cauHinh") String cauHinhDiem) {

        List<SinhVien_Diem> listSinhVienDiem = lst.getListSinhVienDiem();
        if(!cauHinhDiem.isEmpty()) {
            tinhDiemService.formatCauHinh(cauHinhDiem);
        }
        tinhDiemService.setDiemSinhVien(listSinhVienDiem, nhomMonHoc, maMonHoc);
        // Redirect đẩy dữ liệu sang
        ra.addAttribute("nhomMH", nhomMonHoc);
        ra.addAttribute("giangVien", giangVien);
        ra.addAttribute("tenMH", tenMH);
        ra.addAttribute("cauHinhDiem", cauHinhDiem);
        ra.addAttribute("maMonHoc", maMonHoc);
        return "redirect:/monhoc/" +maMonHoc+ "/" +nhomMonHoc+ "/dssv";
    }
}