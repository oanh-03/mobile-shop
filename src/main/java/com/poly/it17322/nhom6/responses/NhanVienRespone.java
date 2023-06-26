/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.responses;

import com.poly.it17322.nhom6.domainmodels.TaiKhoan;
import java.util.Date;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NhanVienRespone {
    private UUID id;
    private String ma;
    private String ten;
    private int gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String email;
    private String sdt;
    private String matKhau;
    private int chucVu;
    private int trangThai;

    public NhanVienRespone(TaiKhoan taiKhoan) {
        this.id = taiKhoan.getId();
        this.ma =  taiKhoan.getMa();
        this.ten =  taiKhoan.getHoTen();
        this.gioiTinh =  taiKhoan.getGioiTinh();
        this.ngaySinh =  taiKhoan.getNgaySinh();
        this.diaChi =  taiKhoan.getDiaChi();
        this.email =  taiKhoan.getEmail();
        this.sdt =  taiKhoan.getSdt();
        this.matKhau = taiKhoan.getMatKhau();
        this.chucVu =  taiKhoan.getChucVu();
        this.trangThai = taiKhoan.getTrangThai();
    }
    
    public Object[] toDataRow() {
        return new Object[]{ma, ten, gioiTinh, ngaySinh, diaChi, email, sdt,matKhau, chucVu, trangThai};
    }
}
