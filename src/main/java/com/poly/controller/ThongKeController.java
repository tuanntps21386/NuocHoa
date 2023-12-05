package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.dao.OrderDAO;
import com.poly.dto.DoanhThuTheoThang;

@Controller
@RequestMapping("/thongke")
public class ThongKeController {

    @Autowired
    private OrderDAO orderRepository;

    @GetMapping("/doanhthu")
    public String thongKeDoanhThu(Model model,
                                  @RequestParam(required = false) Integer nam,
                                  @RequestParam(required = false) Integer thang,
                                  @RequestParam(required = false) Integer ngay) {

        List<DoanhThuTheoThang> doanhThuTheoThangs;

        if (ngay != null) {
            // Thống kê theo ngày
            doanhThuTheoThangs = orderRepository.thongKeDoanhThuTheoNgay(nam, thang, ngay);
        } else if (thang != null) {
            // Thống kê theo tháng
            doanhThuTheoThangs = orderRepository.thongKeDoanhThuTheoThang(nam, thang);
        } else if (nam != null){
            // Thống kê theo năm
            doanhThuTheoThangs = orderRepository.thongKeDoanhThuTheoNam(nam);
        }else {
        	doanhThuTheoThangs = orderRepository.thongKeDoanhThu();
        }

        model.addAttribute("doanhThuTheoThangs", doanhThuTheoThangs);

        return "doanhthu";
    }
}


