/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.KhuyenMai;
import com.poly.it17322.nhom6.utilities.HibernatUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author LiamTrieu
 */
public class KhuyenMaiRepository {

    private Session session = HibernatUtil.getSession();

    public List<KhuyenMai> selectALLKhuyenMai(int trangThai, String text) {
        List<KhuyenMai> listKhuyenMai = new ArrayList<>();
        try {
            Query query;
            session = HibernatUtil.getSession();
            if (trangThai == 3) {
                query = session.createQuery("FROM KhuyenMai Where ten like concat('%', :text ,'%') or ma like concat('%', :text ,'%')order by ma", KhuyenMai.class);
                query.setParameter("text", text);
            } else {
                query = session.createQuery("FROM KhuyenMai where trangThai = :trangThai and ten like concat('%', :text ,'%') order by ma", KhuyenMai.class);
                query.setParameter("trangThai", trangThai);
                query.setParameter("text", text);
            }
            listKhuyenMai = query.getResultList();
        } catch (NullPointerException e) {
            return new ArrayList<>();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKhuyenMai;
    }

    public KhuyenMai SelectKhuyenMaiById(UUID Id) {
        KhuyenMai sanPham = new KhuyenMai();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM KhuyenMai where Id = :Id", KhuyenMai.class);
            query.setParameter("Id", Id);
            sanPham = (KhuyenMai) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sanPham;
    }

    public KhuyenMai SelectKhuyenMaiById(String ma) {
        KhuyenMai sanPham = new KhuyenMai();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM KhuyenMai where ma = :ma", KhuyenMai.class);
            query.setParameter("ma", ma);
            sanPham = (KhuyenMai) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sanPham;
    }

    public Boolean InsertKhuyenMai(KhuyenMai sanPham) {
        try {
            session = HibernatUtil.getSession();
            Transaction tran = session.getTransaction();
            tran.begin();
            session.save(sanPham);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean UpdateKhuyenMai(KhuyenMai sanPham) {
        Transaction tran = null;
        try {
            session = HibernatUtil.getSession();
            tran = session.beginTransaction();
            sanPham.setLastModifiedDate(new Date());
            session.saveOrUpdate(sanPham);
            tran.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<KhuyenMai> getByCodeAndCreateDate(String ma, Date from, Date to) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<KhuyenMai> getByCodeAndUpdateDate(String ma, Date from, Date to) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
