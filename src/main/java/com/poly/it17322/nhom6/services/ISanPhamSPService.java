/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17322.nhom6.services;

import com.poly.it17322.nhom6.domainmodels.ChiTietSP;
import com.poly.it17322.nhom6.responses.ImeiAoSPRespone;
import com.poly.it17322.nhom6.responses.ImeiSPRespone;
import com.poly.it17322.nhom6.responses.SanPhamSPRespone;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author admin
 */
public interface ISanPhamSPService {

    public List<SanPhamSPRespone> getlist();

    public boolean insert(SanPhamSPRespone sp,UUID idcpu,UUID idrom,UUID idram,UUID idms,UUID idmh,UUID idpin,List<ImeiAoSPRespone> lstao);

    public boolean update(SanPhamSPRespone spr, UUID idcpu, UUID idrom, UUID idram, UUID idms, UUID idmh, UUID idpin, List<ImeiAoSPRespone> lstao);
    
    public List<SanPhamSPRespone> getlistTimKiem(String ten);
//    
//    public List<ImeiSPRespone> getlistTimKiemImei(String ma);
    
    public List<SanPhamSPRespone> selectALLChiTietSPXoa();
}
