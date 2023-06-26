/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.responses;

import com.poly.it17322.nhom6.domainmodels.HoaDonChiTiet;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LiamTrieu
 */
@Getter
@Setter
public class HoaDonChiTietResponse {

    private UUID Id;
    private UUID IdHoaDon;
    private UUID IdChiTietSP;
    private String tenSP;
    private BigDecimal donGia;
    private BigDecimal giaBan;
    private BigDecimal giamGia;
    private int soLuong;
    private int trangThai;

    public HoaDonChiTietResponse() {
    }

    public HoaDonChiTietResponse(HoaDonChiTiet hdct) {
        this.Id = hdct.getId();
        this.IdHoaDon = hdct.getHoaDon().getId();
        this.IdChiTietSP = hdct.getChiTietSP().getId();
        this.tenSP = hdct.getTenSP();
        this.donGia = hdct.getDonGia();
        this.soLuong = hdct.getSoLuong();
        this.trangThai = hdct.getTrangThai();
        this.giamGia = hdct.getHoaDon().getGiamGia();

    }

    public Object[] toDataRow() {
        return new Object[]{tenSP, soLuong, donGia, giamGia, ((new BigDecimal(soLuong).multiply(donGia)).subtract(giamGia)),
        trangThai==1?"":"Hàng trả"};
    }
}
