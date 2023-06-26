/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17322.nhom6.services;

import com.poly.it17322.nhom6.domainmodels.TaiKhoan;
import com.poly.it17322.nhom6.responses.NhanVienRespone;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author tuan0
 */
public interface INhanVienService {
    
    public List<NhanVienRespone> getlist();

    public TaiKhoan SelectNhanVienById(UUID id);

    public boolean Insert(NhanVienRespone nhanVien);

    public boolean Update(NhanVienRespone nhanVien);
    
    public List<TaiKhoan> timKiem(String ten, int trangThai);
    
    public List<TaiKhoan> selectTaiKhoan(int trangThai);
    
    public boolean Delete(NhanVienRespone nhanVien);
    
}
