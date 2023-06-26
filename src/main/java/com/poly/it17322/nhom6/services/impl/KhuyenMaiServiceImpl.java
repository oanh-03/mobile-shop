/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.services.impl;

import com.poly.it17322.nhom6.domainmodels.ChiTietSP;
import com.poly.it17322.nhom6.domainmodels.KhuyenMai;
import com.poly.it17322.nhom6.repositories.ChiTietSPRepository;
import com.poly.it17322.nhom6.repositories.KhuyenMaiRepository;
import com.poly.it17322.nhom6.responses.KhuyenMaiDateRespone;
import com.poly.it17322.nhom6.responses.KhuyenMaiResponse;
import com.poly.it17322.nhom6.responses.SanPhamBanHangResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 *
 * @author LiamTrieu
 */
public class KhuyenMaiServiceImpl {

    private KhuyenMaiRepository kmrepo = new KhuyenMaiRepository();
    private ChiTietSPRepository sprepo = new ChiTietSPRepository();

    public List<KhuyenMaiResponse> getList(int trangThai, String text) {
        return kmrepo.selectALLKhuyenMai(trangThai, text).stream().map(KhuyenMaiResponse::new).collect(Collectors.toList());
    }

    public List<KhuyenMaiDateRespone> getListDate() {
        return kmrepo.selectALLKhuyenMai(3, "").stream().map(KhuyenMaiDateRespone::new).collect(Collectors.toList());
    }

    public boolean createKM(KhuyenMaiResponse km, List<UUID> idSP) {
        KhuyenMai k = new KhuyenMai();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            k.setMa("KM" + sdf.format(new Date()));
            k.setTen(km.getTen());
            k.setGiaTri(km.getGiaTri());
            k.setLoaiKM(km.getLoai());
            k.setNgayBD(km.getNgayBD());
            k.setNgayKT(km.getNgayKT());
            k.setTrangThai(0);
            if (kmrepo.InsertKhuyenMai(k) && !idSP.isEmpty()) {
                KhuyenMai khuyenMai = kmrepo.SelectKhuyenMaiById(k.getMa());
                for (UUID s : idSP) {
                    ChiTietSP sp = sprepo.SelectChiTietSPById(s);
                    sp.setKhuyenMai(khuyenMai);
                    sprepo.UpdateChiTietSP(sp);
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateKM(KhuyenMaiResponse km, List<UUID> spbo, List<UUID> spthem) {
        KhuyenMai k = kmrepo.SelectKhuyenMaiById(km.getId());
        try {
            k.setTen(km.getTen());
            k.setGiaTri(km.getGiaTri());
            k.setLoaiKM(km.getLoai());
            k.setNgayBD(km.getNgayBD());
            k.setNgayKT(km.getNgayKT());
            if (kmrepo.UpdateKhuyenMai(k)) {
                for (UUID u : spbo) {
                    ChiTietSP ctsp = sprepo.SelectChiTietSPById(u);
                    ctsp.setKhuyenMai(null);
                    sprepo.UpdateChiTietSP(ctsp);
                }
                for (UUID u2 : spthem) {
                    ChiTietSP ctsp = sprepo.SelectChiTietSPById(u2);
                    ctsp.setKhuyenMai(k);
                    sprepo.UpdateChiTietSP(ctsp);
                }
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateTTKM(int tt, UUID id) {
        KhuyenMai k = kmrepo.SelectKhuyenMaiById(id);
        try {
            k.setTrangThai(tt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kmrepo.UpdateKhuyenMai(k);
    }

    public boolean KTKM(UUID id) {
        KhuyenMai k = kmrepo.SelectKhuyenMaiById(id);
        try {
            k.setTrangThai(2);
            k.setNgayKT(new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kmrepo.UpdateKhuyenMai(k);
    }

    public List<SanPhamBanHangResponse> getAllSp(int dk, String text) {
        List<SanPhamBanHangResponse> lstSP = new BanHangServiceIml().getAllSpBh(text);
        List<SanPhamBanHangResponse> lstSPs = new ArrayList<>();
        for (SanPhamBanHangResponse s : lstSP) {
            switch (dk) {
                case 0 ->
                    lstSPs.add(s);
                case 1 -> {
                    if ("".equals(s.getKhuyenMai())) {
                        lstSPs.add(s);
                    }
                }
                default -> {
                    if (!"".equals(s.getKhuyenMai())) {
                        lstSPs.add(s);
                    }
                }
            }
        }
        return lstSPs;
    }

    public boolean updateCTSP(UUID idsp, UUID idKM) {
        ChiTietSP ctsp = sprepo.SelectChiTietSPById(idsp);
        KhuyenMai km = kmrepo.SelectKhuyenMaiById(idKM);
        ctsp.setKhuyenMai(km);
        return sprepo.UpdateChiTietSP(ctsp);
    }

    public List<SanPhamBanHangResponse> SelectIDSPBYKM(UUID idKhuyenmai, String text) {
        return sprepo.SelectIDSPBYKM(idKhuyenmai, text).stream().map(SanPhamBanHangResponse::new).collect(Collectors.toList());
    }
}
