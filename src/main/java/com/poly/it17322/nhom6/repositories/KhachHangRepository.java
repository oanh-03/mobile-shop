/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.KhachHang;
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
public class KhachHangRepository {

    private Session session = HibernatUtil.getSession();

    public List<KhachHang> selectALLKhachHang() {
        List<KhachHang> listKhachHang = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM KhachHang where ma != 'MacDinh' order by ma desc", KhachHang.class);
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
                listKhachHang = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKhachHang;
    }
    public List<KhachHang> selectKHBH() {
        List<KhachHang> listKhachHang = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM KhachHang order by ma desc", KhachHang.class);
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
                listKhachHang = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKhachHang;
    }

    public KhachHang SelectKhachHangById(UUID Id) {
        KhachHang kh = new KhachHang();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM KhachHang where id = :Id", KhachHang.class);
            query.setParameter("Id", Id);
            kh = (KhachHang) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kh;
    }

    public Boolean InsertKhachHang(KhachHang kh) {
        try {
            session = HibernatUtil.getSession();
            Transaction tran = session.getTransaction();
            tran.begin();
            session.save(kh);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean UpdateKhachHang(KhachHang kh) {
        Transaction tran = null;
        try {
            session = HibernatUtil.getSession();
            tran = session.beginTransaction();
            kh.setLastModifiedDate(new Date());
            session.saveOrUpdate(kh);
            tran.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public KhachHang SelectKHByMa(String ma) {
        KhachHang kh = new KhachHang();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM KhachHang WHERE Ma = :ma", KhachHang.class);
            query.setParameter("ma", ma);
            kh = (KhachHang) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kh;
    }

}
