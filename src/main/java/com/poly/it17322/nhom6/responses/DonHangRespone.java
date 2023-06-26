/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.responses;

import com.poly.it17322.nhom6.domainmodels.HoaDon;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author LiamTrieu
 */
@Getter
@Setter
@NoArgsConstructor
public class DonHangRespone {

    private UUID id;
    private UUID idNV;
    private UUID idKH;
    private String tenkhachHang;
    private String maHD;
    private String maNV;
    private String diaChi;
    private String tenship;
    private String sdtship;
    private String sdtKH;
    private String lyDo;
    private String maGiaoDich;
    private Date NgayNhanMongMuon;
    private Date ngayThanhToan;
    private Date ngayNhan;
    private BigDecimal tongTien;
    private BigDecimal tienMat;
    private BigDecimal chuyenKhoan;
    private BigDecimal giamGia;
    private BigDecimal phiShip;
    private BigDecimal tienThua;
    private int hinhThuc;
    private int nhanHang;
    private int soLanShip;
    private int trangThai;

    public DonHangRespone(HoaDon h) {
        this.id = h.getId();
        this.idNV = h.getTaiKhoan().getId();
        this.maHD = h.getMa();
        this.maNV = h.getTaiKhoan().getMa() + "-" + h.getTaiKhoan().getHoTen();
        this.diaChi = h.getDiaChi();
        this.tongTien = h.getTongTien();
        this.tienMat = h.getTienMat();
        this.chuyenKhoan = h.getChuyenKhoan();
        this.giamGia = h.getGiamGia();
        this.phiShip = h.getTienShip();
        this.soLanShip = h.getSoLanShip();
        this.tienThua = h.getTienThua();
        this.hinhThuc = h.getLoaiThanhToan();
        this.nhanHang = h.getTrangThai() == 0 ? 0 : (h.getTrangThai() == 3 ? 0 : 1);
        try {
            this.idKH = h.getKhachHang().getId();
            this.sdtKH = h.getSdtNguoiNhan();
            this.tenkhachHang = h.getTenKH();
        } catch (Exception e) {
        }
        this.sdtship = h.getSdtNguoiShip();
        this.tenship = h.getTenNguoiShip();
        this.trangThai = h.getTrangThai();
        try {
            this.ngayNhan = h.getNgayNhanHang();
        } catch (Exception e) {
        }
        if (trangThai == 4 || trangThai == 3) {
            this.ngayThanhToan = h.getNgayThanhToan();
        }
        try {
            this.NgayNhanMongMuon = h.getNgayNhanMongMuon();
        } catch (Exception e) {
        }
    }

}
