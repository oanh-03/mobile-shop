/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17322.nhom6.services;

import com.poly.it17322.nhom6.responses.DonHangRespone;
import com.poly.it17322.nhom6.responses.GioHangRespone;
import com.poly.it17322.nhom6.responses.HoaDonBanHangRespone;
import com.poly.it17322.nhom6.responses.ImeiBanHangRespone;
import com.poly.it17322.nhom6.responses.ImeiDaBanRespone;
import com.poly.it17322.nhom6.responses.SanPhamBanHangResponse;
import com.poly.it17322.nhom6.responses.khachHangBanHangRespone;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author LiamTrieu
 */
public interface IBanHangService {

    List<HoaDonBanHangRespone> getALLHoaDonBanHang(UUID idNV, int dk, boolean cv, String text);
    
    void updateKM(UUID idhdct, BigDecimal km);

    khachHangBanHangRespone getkh(UUID ma);

    List<SanPhamBanHangResponse> getAllSpBh(String text);

    List<ImeiDaBanRespone> getImeiBan(UUID idHDCT, String text);
    

    boolean deleteImeiBan(UUID idImeiBan);
    boolean HoanImeiBan(UUID idImeiBan, UUID hd, GioHangRespone gh);

    boolean updateGHXoa(UUID idHDCT);

    List<GioHangRespone> getAllGH(UUID id);

    boolean unGH(UUID idHD);

    List<ImeiBanHangRespone> getImei(UUID id, String text);

    boolean addSpSanner(String maImei, UUID idHD);

    DonHangRespone getDonHang(UUID id);

    GioHangRespone getGH(UUID idhd, UUID idsp);

    boolean updateGH(UUID idhd, UUID idsp, int sl);

    boolean createHoaDon(UUID idNV, int trangThai);

    boolean clearHoaDon (DonHangRespone dh);

    boolean createImeiBan(String maImei, UUID hoaDon);

    boolean updateDonHang(DonHangRespone dh);

    public void updatRank(UUID id);
}
