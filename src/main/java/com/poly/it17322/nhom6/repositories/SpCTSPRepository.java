/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.ChiTietSP;
import com.poly.it17322.nhom6.domainmodels.Imei;
import com.poly.it17322.nhom6.domainmodels.ImeiBan;
import com.poly.it17322.nhom6.domainmodels.SanPham;
import com.poly.it17322.nhom6.responses.ImeiSPRespone;
import com.poly.it17322.nhom6.responses.SanPhamSPRespone;
import com.poly.it17322.nhom6.utilities.HibernatUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author admin
 */
public class SpCTSPRepository {

    private Session session = HibernatUtil.getSession();

    public List<Imei> SelectCBOImeiById(UUID Idctsp) {
        List<Imei> lstimel = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM Imei where trangThai = 1 and IdChiTietSP = :Idctsp", Imei.class);
            query.setParameter("Idctsp", Idctsp);
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
            }
            lstimel = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstimel;
    }

    public Boolean deleteImei(Imei imei) {
        Transaction transaction = null;
        try {
            session = HibernatUtil.getSession();
            transaction = session.beginTransaction();
            session.delete(imei);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public List<Imei> timKiemImei(String ma) {
        List<Imei> lstimel = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM Imei where Ma Like :ma", Imei.class);
            query.setParameter("ma", ma + "%");
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
                lstimel = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstimel;
    }

    public List<ChiTietSP> selectALLChiTietSPXoa() {
        List<ChiTietSP> listChiTietSP = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            javax.persistence.Query query = session.createQuery("FROM ChiTietSP WHERE Deleted = 1 ", ChiTietSP.class);

            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
                listChiTietSP = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listChiTietSP;
    }

    public List<Imei> SelectImeiByMa(String ma) {
        List<Imei> lstimeima = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            javax.persistence.Query query = session.createQuery("FROM Imei where ma = :ma", Imei.class);
            query.setParameter("ma", ma);
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
            lstimeima = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstimeima;
    }

    public List<ChiTietSP> selectALLChiTietSP() {
        List<ChiTietSP> listChiTietSP = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            javax.persistence.Query query = session.createQuery("FROM ChiTietSP WHERE Deleted = 0 ", ChiTietSP.class);

            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
                listChiTietSP = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listChiTietSP;
    }

    public ChiTietSP SelectChiTietSPById(UUID Id) {
        ChiTietSP ctsp = new ChiTietSP();
        try {
            session = HibernatUtil.getSession();
            javax.persistence.Query query = session.createQuery("FROM ChiTietSP where id = :Id", ChiTietSP.class);
            query.setParameter("Id", Id);
            ctsp = (ChiTietSP) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ctsp;
    }

    public List<ChiTietSP> TimKiemSP(String input) {
        List<ChiTietSP> list = new ArrayList<>();
        try {
            Session session = HibernatUtil.getSession();
            String hql = "FROM ChiTietSP a Where a.sanPham.ten LIKE concat('%', :input ,'%')";
            Query query = session.createQuery(hql, ChiTietSP.class);
            query.setParameter("input", input);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<ChiTietSP> TimKiemSPBH(String input) {
        List<ChiTietSP> list = new ArrayList<>();
        try {
            Session session = HibernatUtil.getSession();
            String hql = "FROM ChiTietSP a Where "
                    + "(a.sanPham.ten LIKE concat('%', :input ,'%') "
                    + "or a.ram.ten LIKE concat('%', :input ,'%') "
                    + "or a.rom.ten LIKE concat('%', :input ,'%') "
                    + "or a.mauSac.ten LIKE concat('%', :input ,'%')) "
                    + "and a.soLuong > 0";
            Query query = session.createQuery(hql, ChiTietSP.class);
            query.setParameter("input", input);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
