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
import lombok.Setter;

/**
 *
 * @author LiamTrieu
 */
@Getter
@Setter
public class HoaDonResponse {

    private UUID Id;
    private String ma;
    private String hoTen;
    private String sdt;
    private BigDecimal tongTien;
    private Date ngayTao;
    private Date ngayThanhToan;
    private int loaiThanhToan;
    private int soLanShip;
    private String maNV;
    private String tenNV;
    private String diaChi;
    private String lyDo;
    private int trangThai;

    public HoaDonResponse() {
    }

    public HoaDonResponse(HoaDon hd) {
        try {
            this.Id = hd.getId();
            this.ma = hd.getMa();
            this.soLanShip = hd.getSoLanShip();
            try {
                this.hoTen = hd.getKhachHang().getHoTen();
                this.sdt = hd.getKhachHang().getSdt();
            } catch (Exception e) {
                this.hoTen = "";
                this.sdt = "";
            }
            try {
                this.lyDo = hd.getLyDo();
            } catch (Exception e) {
                this.lyDo = "";
            }
            this.tongTien = hd.getTongTien();
            this.ngayTao = hd.getNgayTao();
            this.ngayThanhToan = hd.getNgayThanhToan();
            this.loaiThanhToan = hd.getLoaiThanhToan();
            this.maNV = hd.getTaiKhoan().getMa();
            this.tenNV = hd.getTaiKhoan().getHoTen();
            this.diaChi = hd.getDiaChi();
            this.trangThai = hd.getTrangThai();

        } catch (Exception e) {
        }
    }

    public String getloaiThanhToan() {
        return loaiThanhToan == 0 ? "Tiền mặt" : loaiThanhToan == 1 ? "Chuyển khoản" : "Kết hợp";
    }

    public String getTrangThai() {
        if (trangThai == 0) {
            return "Chờ thanh toán ";
        } else if (trangThai == 1) {
            return "Chờ giao" + (soLanShip==0?"":soLanShip);
        } else if (trangThai == 2) {
            return "Đang giao" + (soLanShip==0?"":soLanShip);
        } else if (trangThai == 3) {
            return "Đã thanh toán";
        } else {
            return "Đã giao";
        }
    }

    public Object[] toDataRow() {
        return new Object[]{ma, hoTen, sdt, diaChi, maNV, tenNV,
            ngayTao, ngayThanhToan, getloaiThanhToan(), tongTien, getTrangThai(), lyDo};
    }
}
