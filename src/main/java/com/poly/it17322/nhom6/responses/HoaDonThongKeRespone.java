/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.responses;

import com.poly.it17322.nhom6.domainmodels.HoaDon;
import com.poly.it17322.nhom6.domainmodels.HoaDonChiTiet;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author LiamTrieu
 */
@NoArgsConstructor
@Getter
@Setter
public class HoaDonThongKeRespone {

    private int sl;
    private BigDecimal tongTien;
    private Date ngayMua;

    public HoaDonThongKeRespone(HoaDon h, List<HoaDonChiTiet> lsthdct) {
        int soluong = 0;
        for (HoaDonChiTiet s : lsthdct) {
            soluong += s.getSoLuong();
        }
        this.sl = soluong;
        this.tongTien = h.getTongTien();
        this.ngayMua = h.getNgayThanhToan();
    }
}
