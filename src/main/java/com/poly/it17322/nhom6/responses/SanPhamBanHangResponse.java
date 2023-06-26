/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.responses;

import com.poly.it17322.nhom6.domainmodels.ChiTietSP;
import java.math.BigDecimal;
import java.text.DecimalFormat;
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
public class SanPhamBanHangResponse {
    private UUID id;
    private String tenSanPham;
    private String manHinh;
    private String cpu;
    private String pin;
    private int soLuong;
    private BigDecimal giaBan;
    private String khuyenMai;

    public SanPhamBanHangResponse(ChiTietSP sp) {
        this.id = sp.getId();
        this.tenSanPham = sp.getSanPham().getTen()+ " " + sp.getMauSac().getTen() + " " + sp.getRam().getTen()+"/"+sp.getRom().getTen()+" "+(sp.getLoaiHang()==0?"Mới":"Cũ");
        this.manHinh = sp.getManHinh().getTen();
        this.cpu = sp.getCpu().getTen();
        this.pin = sp.getPin().getTen();
        this.soLuong = sp.getSoLuong();
        this.giaBan = sp.getGia();
        try {
            this.khuyenMai = sp.getKhuyenMai().getTen();
        } catch (Exception e) {
            this.khuyenMai = "";
        }
    }
    
    public Object[] toDataRow(){
        DecimalFormat df = new DecimalFormat("#,### vnđ");
        return new Object[]{this.tenSanPham,this.manHinh,this.cpu,this.pin,this.soLuong,df.format(this.giaBan)};
    }
}
