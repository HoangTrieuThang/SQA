package com.sqa.nhom15.SQANhom15.controller;

import com.sqa.nhom15.SQANhom15.model.CheckValue;
import com.sqa.nhom15.SQANhom15.resultObject.CauHinhDiems;
import com.sqa.nhom15.SQANhom15.resultObject.MonHoc_CauHinhDiem;
import com.sqa.nhom15.SQANhom15.services.CauHinhDiemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@ResponseBody

@RequestMapping("/cauhinh")
public class CauHinhDiemController {

    @Autowired
    private CauHinhDiemService cauHinhDiemService;

    @GetMapping("")
    public String getListCauHinh(Model model) {
        List<MonHoc_CauHinhDiem> listCauHinhDiem = cauHinhDiemService.findAll();
        // Đưa model CauHinhDiems chứa List<MonHoc_CauHinhDiem>
        CauHinhDiems lst = new CauHinhDiems(listCauHinhDiem);
        model.addAttribute("lst", lst);
        return "/cauhinh/cauhinhdiem";
    }

    @PostMapping("/saveCauHinh")
    public String saveCauHinh(@ModelAttribute("lst") CauHinhDiems lst, @RequestParam("countIndex") int index,
                              RedirectAttributes ra) {
        String check = CheckValue.OK.getValue();

        String cauHinhDiem = lst.getListCauHinhDiem().get(index).getCauHinhDiem();
        if (cauHinhDiemService.checkPattern(cauHinhDiem)) {
            if (cauHinhDiemService.checkCauHinh(cauHinhDiem)) {
                cauHinhDiemService.updateCauHinhDiem(lst.getListCauHinhDiem().get(index).getMaCauHinh(), cauHinhDiem);
            }
            else check = CheckValue.NOT_OK.getValue();
        }
        else {
            check = CheckValue.NOT_OK.getValue();
        }
        System.out.println("check??" +check);
        ra.addFlashAttribute("status", check);
        return "redirect:/cauhinh";
    }
}

