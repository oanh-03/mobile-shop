/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.HoaDon;
import com.poly.it17322.nhom6.domainmodels.KhachHang;
import com.poly.it17322.nhom6.responses.KhachHangResponse;
import com.poly.it17322.nhom6.utilities.HibernatUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.hibernate.Session;
import javax.persistence.Query;

/**
 *
 * @author ACER
 */
public class ChucNangKHRepository extends KhachHangRepository {

    private Session session = HibernatUtil.getSession();

    public List<KhachHang> timkiem(String sdt) {
        List<KhachHang> lstKH = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM KhachHang where Sdt LIKE :sdt and Ma != 'MacDinh'", KhachHang.class);
            query.setParameter("sdt", "%" + sdt + "%");
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
                lstKH = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstKH;
    }

    public List<KhachHang> LocKH(int gioitinh) {
        List<KhachHang> lstKH = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM KhachHang where GioiTinh = :gioitinh and Ma != 'MacDinh'", KhachHang.class);
            query.setParameter("gioitinh", gioitinh);
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
                lstKH = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstKH;
    }

    public List<HoaDon> selectallhoadon(UUID IdKH) {
        List<HoaDon> lstHD = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM HoaDon where IdKH = :IdKH", HoaDon.class);
            query.setParameter("IdKH", IdKH);
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
                lstHD = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstHD;
    }

    public List<KhachHang> loctheohang(int capdo) {
        List<KhachHang> lstKH = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("From KhachHang where CapDo = :capdo and Ma != 'MacDinh'", KhachHang.class);
            query.setParameter("capdo", capdo);
            lstKH = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstKH;
    }
}
