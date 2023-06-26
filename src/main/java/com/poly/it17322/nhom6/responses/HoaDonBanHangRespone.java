/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.responses;

import com.poly.it17322.nhom6.domainmodels.HoaDon;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author LiamTrieu
 */
@Setter
@Getter
@NoArgsConstructor
public class HoaDonBanHangRespone {

    private UUID id;
    private String ma;
    private Date ngayTao;
    private String nguoiTao;
    private String khachHang;
    private int trangThai;
    private int soLanShip;

    public HoaDonBanHangRespone(HoaDon hd) {
        try {
            this.id = hd.getId();
            this.ma = hd.getMa();
            this.ngayTao = hd.getNgayTao();
            this.soLanShip = hd.getSoLanShip();
            try {
                this.nguoiTao = hd.getTaiKhoan().getMa()+"-"+hd.getTaiKhoan().getHoTen();
            } catch (Exception e) {
                this.nguoiTao = "...";
            }
            try {
                this.khachHang = hd.getKhachHang().getHoTen();
            } catch (Exception e) {
                this.khachHang = "...";
            }
            this.trangThai = hd.getTrangThai();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getTrangThai() {
        switch (trangThai) {
            case 0:
                return "Chờ thanh toán";
            case 1:
                return "Chờ giao " + (soLanShip==0?"":soLanShip);
            case 2:
                return "Đang giao " + (soLanShip==0?"":soLanShip);
            case 3:
                return "Đã thanh toán";
            case 4:
                return "Đã giao";
        }
        return "Đã thanh toán";
    }

    public Object[] toDataRow() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return new Object[]{
            ma,
            sdf.format(ngayTao),
            nguoiTao,
            khachHang,
            getTrangThai()
        };
    }

}
