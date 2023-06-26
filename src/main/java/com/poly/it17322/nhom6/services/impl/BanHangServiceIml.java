/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.services.impl;

import com.poly.it17322.nhom6.domainmodels.ChiTietSP;
import com.poly.it17322.nhom6.domainmodels.HoaDon;
import com.poly.it17322.nhom6.domainmodels.HoaDonChiTiet;
import com.poly.it17322.nhom6.domainmodels.Imei;
import com.poly.it17322.nhom6.domainmodels.ImeiBan;
import com.poly.it17322.nhom6.domainmodels.KhachHang;
import com.poly.it17322.nhom6.repositories.ChiTietSPRepository;
import com.poly.it17322.nhom6.repositories.HoaDonChiTietRepository;
import com.poly.it17322.nhom6.repositories.HoaDonRepository;
import com.poly.it17322.nhom6.repositories.ImeiBanRepository;
import com.poly.it17322.nhom6.repositories.ImeiRepository;
import com.poly.it17322.nhom6.repositories.KhachHangRepository;
import com.poly.it17322.nhom6.repositories.TaiKhoanRepository;
import com.poly.it17322.nhom6.responses.DonHangRespone;
import com.poly.it17322.nhom6.responses.GioHangRespone;
import com.poly.it17322.nhom6.responses.HoaDonBanHangRespone;
import com.poly.it17322.nhom6.responses.ImeiBanHangRespone;
import com.poly.it17322.nhom6.responses.ImeiDaBanRespone;
import com.poly.it17322.nhom6.responses.SanPhamBanHangResponse;
import com.poly.it17322.nhom6.responses.khachHangBanHangRespone;
import com.poly.it17322.nhom6.services.IBanHangService;
import java.math.BigDecimal;
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
public class BanHangServiceIml implements IBanHangService {

    ChiTietSPRepository ctsprepo = new ChiTietSPRepository();
    HoaDonChiTietRepository hdctrepo = new HoaDonChiTietRepository();
    HoaDonRepository hdrepo = new HoaDonRepository();
    TaiKhoanRepository tkrepo = new TaiKhoanRepository();
    KhachHangRepository khrepo = new KhachHangRepository();
    ImeiBanRepository imlbrepo = new ImeiBanRepository();
    ImeiRepository imelrepo = new ImeiRepository();

    @Override
    public List<HoaDonBanHangRespone> getALLHoaDonBanHang(UUID idNV, int dk, boolean cv, String text) {
        List<HoaDonBanHangRespone> lstHd = new ArrayList<>();
        List<HoaDon> hds = hdrepo.getALLHDTaiQuay(idNV, dk, cv, text);
        lstHd = hds.stream().map(HoaDonBanHangRespone::new).collect(Collectors.toList());
        List<HoaDonBanHangRespone> lstHDBH = new ArrayList<>();
        return lstHd;
    }

    @Override
    public List<SanPhamBanHangResponse> getAllSpBh(String text) {
        List<ChiTietSP> ctsp = ctsprepo.getSP();
        List<SanPhamBanHangResponse> spbh = ctsp.stream().map(SanPhamBanHangResponse::new).collect(Collectors.toList());
        List<SanPhamBanHangResponse> lstSP = new ArrayList<>();
        for (SanPhamBanHangResponse s : spbh) {
            if (s.getTenSanPham().contains(text)) {
                lstSP.add(s);
            }
        }
        return lstSP;
    }

    @Override
    public List<GioHangRespone> getAllGH(UUID id) {
        HoaDon hd = hdrepo.SelectHoaDonById(id);
        List<HoaDonChiTiet> hdcts = hdctrepo.SelectByHoaDonCTID(hd.getId());
        List<GioHangRespone> gh = hdcts.stream().map(GioHangRespone::new).collect(Collectors.toList());
        return gh;
    }

    @Override
    public boolean createHoaDon(UUID idNV, int trangThai) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        HoaDon hd = new HoaDon();
        try {
            String maHD = "HD" + sdf.format(new Date());
            if (trangThai == 0) {
                KhachHang kh = khrepo.SelectKHByMa("MacDinh");
                hd.setDiaChi("Tại cửa hàng");
                hd.setKhachHang(kh);
                hd.setTenKH(kh.getHoTen());
                hd.setSdtNguoiNhan(kh.getSdt());
            }
            hd.setMa(maHD);
            hd.setTaiKhoan(tkrepo.SelectTaiKhoanById(idNV));
            hd.setTrangThai(trangThai);
            hd.setNgayTao(new Date());
            hd.setTongTien(new BigDecimal(0));
            hd.setTienShip(new BigDecimal(0));
            hd.setTienThua(new BigDecimal(0));
            hd.setTienMat(new BigDecimal(0));
            hd.setChuyenKhoan(new BigDecimal(0));
            hd.setGiamGia(new BigDecimal(0));
            hd.setLoaiThanhToan(0);
            hdrepo.InsertHoaDon(hd);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean clearHoaDon(DonHangRespone dh) {
        HoaDon hd = hdrepo.SelectHoaDonById(dh.getId());
        try {
            hd.setDiaChi(null);
            hd.setSdtNguoiShip(null);
            hd.setTenNguoiShip(null);
            hd.setNgayNhanMongMuon(null);
            hd.setTenKH(null);
            if (dh.getTrangThai() == 0) {
                hd.setKhachHang(khrepo.SelectKHByMa("MacDinh"));
            } else {
                hd.setKhachHang(null);
            }
            hd.setNgayTao(new Date());
            hd.setTongTien(new BigDecimal(0));
            hd.setTienShip(new BigDecimal(0));
            hd.setTienMat(new BigDecimal(0));
            hd.setChuyenKhoan(new BigDecimal(0));
            hd.setGiamGia(new BigDecimal(0));
            hd.setLoaiThanhToan(0);
            hdrepo.UpdateHoaDon(hd);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean unGH(UUID idHD) {
        try {
            List<HoaDonChiTiet> hdcts = hdctrepo.SelectByHoaDonCTID(idHD);
            for (HoaDonChiTiet s : hdcts) {
                for (ImeiBan i : imlbrepo.selectALLImeiBan(s.getId(), "")) {
                    Imei imel = imelrepo.SelectImeiBanByMa(i.getMa());
                    imel.setTrangThai(1);
                    imelrepo.UpdateImei(imel);
                    imlbrepo.delete(i);
                }
                UUID idSP = s.getChiTietSP().getId();
                int sl = s.getSoLuong();
                ChiTietSP ctsp = ctsprepo.SelectChiTietSPById(idSP);
                int slSP = ctsp.getSoLuong();
                ctsp.setSoLuong(slSP + sl);
                ctsprepo.UpdateChiTietSP(ctsp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public DonHangRespone getDonHang(UUID id) {
        HoaDon hd = hdrepo.SelectHoaDonById(id);
        DonHangRespone dh = new DonHangRespone(hd);
        return dh;
    }

    @Override
    public boolean updateDonHang(DonHangRespone dh) {
        try {
            HoaDon hd = hdrepo.SelectHoaDonById(dh.getId());
            if (dh.getTrangThai() == 5) {
                hd.setLyDo(dh.getLyDo());
            }
            if (dh.getIdKH() != null) {
                hd.setKhachHang(khrepo.SelectKhachHangById(dh.getIdKH()));
            }
            hd.setTaiKhoan(tkrepo.SelectTaiKhoanById(dh.getIdNV()));
            hd.setTongTien(dh.getTongTien());
            hd.setTienThua(dh.getTienThua());
            hd.setGiamGia(dh.getGiamGia());
            hd.setLoaiThanhToan(dh.getHinhThuc());
            hd.setTienMat(dh.getTienMat());
            hd.setChuyenKhoan(dh.getChuyenKhoan());
            hd.setTenKH(dh.getTenkhachHang());
            hd.setDiaChi(dh.getDiaChi());
            hd.setTenKH(dh.getTenkhachHang());
            hd.setSdtNguoiNhan(dh.getSdtKH());
            hd.setSoLanShip(dh.getSoLanShip());
            if (dh.getTrangThai() == 3 || dh.getTrangThai() == 4) {
                hd.setNgayThanhToan(new Date());
                if (hd.getTrangThai() != 6) {
                    hd.setNgayNhanHang(new Date());
                } else {
                    hd.setNgayNhanHang(dh.getNgayNhan());
                }
            }
            hd.setTrangThai(dh.getTrangThai());
            if (dh.getTrangThai() == 2) {
                hd.setNgayShip(new Date());
                hd.setTienShip(dh.getPhiShip());
                hd.setSdtNguoiShip(dh.getSdtship());
                hd.setTenNguoiShip(dh.getTenship());
                hd.setNgayNhanMongMuon(dh.getNgayNhanMongMuon());
            }
            return hdrepo.UpdateHoaDon(hd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public GioHangRespone getGH(UUID idhd, UUID idsp) {
        HoaDonChiTiet hdcts = hdctrepo.getGH(idhd, idsp);
        if (hdcts.getId() == null) {
            return null;
        }
        return new GioHangRespone(hdcts);
    }

    @Override
    public boolean updateGH(UUID idhd, UUID idsp, int sl) {
        HoaDonChiTiet hdct = new HoaDonChiTiet();
        GioHangRespone gh = getGH(idhd, idsp);
        HoaDon hd = hdrepo.SelectHoaDonById(idhd);
        ChiTietSP ctsp = ctsprepo.SelectChiTietSPById(idsp);
        try {
            if (gh == null) {
                String tensp = ctsp.getSanPham().getTen() + " " + ctsp.getMauSac().getTen() + " " + ctsp.getRam().getTen() + "/" + ctsp.getRom().getTen() + " " + (ctsp.getLoaiHang() == 1 ? "Cũ" : "Mới");
                hdct.setChiTietSP(ctsp);
                hdct.setCreatedDate(new Date());
                hdct.setDonGia(ctsp.getGia());
                hdct.setHoaDon(hd);
                hdct.setSoLuong(sl);
                hdct.setKhuyenMai(new BigDecimal(0));
                hdct.setThanhTien(ctsp.getGia().multiply(new BigDecimal(sl)));
                hdct.setTenSP(tensp);
                hdct.setTrangThai(1);
            } else {
                hdct = hdctrepo.SelectHoaDonChiTietById(gh.getId());
                int soLuong = hdct.getSoLuong();
                hdct.setSoLuong(soLuong + sl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (hdctrepo.UpdateHoaDonChiTiet(hdct)) {
            int solg = ctsp.getSoLuong();
            ctsp.setSoLuong(solg - sl);
        }
        return ctsprepo.UpdateChiTietSP(ctsp);
    }

    @Override
    public boolean updateGHXoa(UUID idHDCT) {
        HoaDonChiTiet hdct = hdctrepo.SelectHoaDonChiTietById(idHDCT);
        ChiTietSP ctsp = ctsprepo.SelectChiTietSPById(hdct.getChiTietSP().getId());
        int solg = ctsp.getSoLuong();
        ctsp.setSoLuong(solg + 1);
        ctsprepo.UpdateChiTietSP(ctsp);
        int soLuong = hdct.getSoLuong();
        hdct.setSoLuong(soLuong - 1);
        soLuong = hdct.getSoLuong();
        if (soLuong <= 0) {
            hdctrepo.delete(hdct);
            return true;
        }
        return hdctrepo.UpdateHoaDonChiTiet(hdct);
    }

    @Override
    public List<ImeiBanHangRespone> getImei(UUID id, String text) {
        List<Imei> imels = imelrepo.Selectmamel(id, text);
        return imels.stream().map(ImeiBanHangRespone::new).collect(Collectors.toList());
    }

    @Override
    public List<ImeiDaBanRespone> getImeiBan(UUID idHDCT, String text) {
        List<ImeiBan> imels = imlbrepo.selectALLImeiBan(idHDCT, text);
        return imels.stream().map(ImeiDaBanRespone::new).collect(Collectors.toList());
    }

    @Override
    public boolean createImeiBan(String maImei, UUID hoaDon) {
        try {
            ImeiBan imelb = new ImeiBan();
            imelb.setMa(maImei);
            imelb.setTrangThai(1);
            imelb.setHoaDonChiTiet(hdctrepo.SelectHoaDonChiTietById(hoaDon));
            if (imlbrepo.InsertImeiBan(imelb)) {
                Imei imel = imelrepo.SelectImeiBanByMa(maImei);
                imel.setTrangThai(0);
                return imelrepo.UpdateImei(imel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public khachHangBanHangRespone getkh(UUID id) {
        return new khachHangBanHangRespone(khrepo.SelectKhachHangById(id));
    }

    @Override
    public boolean addSpSanner(String maImei, UUID idHD) {
        try {
            Imei imel = imelrepo.SelectImeiBanByMa(maImei);
            if (imel.getId() == null) {
                return false;
            } else if (imel.getTrangThai() == 0) {
                return false;
            }
            if (updateGH(idHD, imel.getChiTietSP().getId(), 1)) {
                if (createImeiBan(maImei, getGH(idHD, imel.getChiTietSP().getId()).getId())) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteImeiBan(UUID idImeiBan) {
        ImeiBan iml = imlbrepo.SelectImeiBanById(idImeiBan);
        Imei im = imelrepo.SelectImeiBanByMa(iml.getMa());
        if (imlbrepo.delete(iml)) {
            im.setTrangThai(1);
        }
        return imelrepo.UpdateImei(im);
    }

    @Override
    public boolean HoanImeiBan(UUID idImeiBan, UUID hd, GioHangRespone gh) {
        ImeiBan iml = imlbrepo.SelectImeiBanById(idImeiBan);
        Imei im = imelrepo.SelectImeiBanByMa(iml.getMa());
        HoaDonChiTiet hdct = new HoaDonChiTiet();
        HoaDonChiTiet hdct2 = new HoaDonChiTiet();
        ChiTietSP ctsp = ctsprepo.SelectChiTietSPById(gh.getIdSP());
        try {
            if (gh.getTrangThai() == 1) {
                hdct = hdctrepo.getGHTra(hd, gh.getIdSP());
                hdct2 = hdctrepo.getGH(hd, gh.getIdSP());
                im.setTrangThai(1);
                hdct.setTrangThai(0);
                ctsp.setSoLuong(ctsp.getSoLuong() + 1);
            } else {
                hdct = hdctrepo.getGH(hd, gh.getIdSP());
                hdct2 = hdctrepo.getGHTra(hd, gh.getIdSP());
                im.setTrangThai(0);
                hdct.setTrangThai(1);
                ctsp.setSoLuong(ctsp.getSoLuong() - 1);
            }
            hdct.setHoaDon(hdrepo.SelectHoaDonById(hd));
            hdct.setChiTietSP(ctsp);
            hdct.setTenSP(gh.getTenSanPham());
            hdct.setDonGia(gh.getGiaBan());
            hdct.setKhuyenMai(gh.getKhuyenMai());
        } catch (Exception e) {
            return false;
        }
        if (hdct.getId() == null) {
            hdct.setSoLuong(1);
            hdct.setThanhTien((hdct.getDonGia().subtract(hdct.getKhuyenMai())).multiply(new BigDecimal(hdct.getSoLuong())));
            hdctrepo.InsertHoaDonChiTiet(hdct);
        } else {
            hdct.setSoLuong(hdct.getSoLuong() + 1);
            hdct.setThanhTien((hdct.getDonGia().subtract(hdct.getKhuyenMai())).multiply(new BigDecimal(hdct.getSoLuong())));
            hdctrepo.UpdateHoaDonChiTiet(hdct);
        }
        hdct2.setSoLuong(hdct2.getSoLuong() - 1);
        iml.setHoaDonChiTiet(hdct);
        boolean check = imelrepo.UpdateImei(im) && imlbrepo.UpdateImeiBan(iml) && ctsprepo.UpdateChiTietSP(ctsp);
        if (hdct2.getSoLuong() <= 0) {
            return hdctrepo.delete(hdct2);
        } else {
            return hdctrepo.UpdateHoaDonChiTiet(hdct2);
        }
    }

    @Override
    public void updatRank(UUID id) {
        KhachHang kh = khrepo.SelectKhachHangById(id);
        if (kh.getMa().equals("MacDinh")) {
            return;
        }
        BigDecimal tongTien = hdrepo.getTienByKH(id);
        int rank = 0;
        while (tongTien.compareTo(new BigDecimal(20000000)) >= 0) {
            if (rank < 3) {
                rank++;
            }
            tongTien = tongTien.subtract(new BigDecimal(20000000));
        }
        if (kh.getCapDo() != rank) {
            kh.setNgayTutHang(new Date());
        }
        kh.setCapDo(rank);
        khrepo.UpdateKhachHang(kh);
    }

    @Override
    public void updateKM(UUID idhdct, BigDecimal km) {
        HoaDonChiTiet hdct = hdctrepo.SelectHoaDonChiTietById(idhdct);
        hdct.setKhuyenMai(km);
        hdctrepo.UpdateHoaDonChiTiet(hdct);
    }
}
