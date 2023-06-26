/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.responses;

import com.poly.it17322.nhom6.domainmodels.KhachHang;
import java.util.Date;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class KhachHangResponse {

    private UUID id;
    private String ma;
    private String hoten;
    private int gioitinh;
    private String sdt;
    private String diachi;
    private Date ngaysinh;
    private int hang;

    public KhachHangResponse(KhachHang khachhang) {
        this.id = khachhang.getId();
        this.ma = khachhang.getMa();
        this.hoten = khachhang.getHoTen();
        this.gioitinh = khachhang.getGioiTinh();
        this.sdt = khachhang.getSdt();
        this.diachi = khachhang.getDiaChi();
        this.ngaysinh = khachhang.getNgaySinh();
        this.hang = khachhang.getCapDo();
    }

    public String getHang() {
        switch (hang) {
            case 0:
                return "Đồng";
            case 1:
                return "Bạc";
            case 2:
                return "Vàng";
            case 3:
                return "Kim cương";
            default:
                return "";
        }
    }
}
