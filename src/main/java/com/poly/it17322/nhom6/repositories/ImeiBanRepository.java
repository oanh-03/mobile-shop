/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.HoaDon;
import com.poly.it17322.nhom6.domainmodels.ImeiBan;
import com.poly.it17322.nhom6.utilities.HibernatUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author LiamTrieu
 */
public class ImeiBanRepository {

    private Session session = HibernatUtil.getSession();

    public List<ImeiBan> selectALLImeiBan() {
        List<ImeiBan> listImeiBan = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM ImeiBan", ImeiBan.class);
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
                listImeiBan = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listImeiBan;
    }

    public ImeiBan SelectImeiBanById(UUID Id) {
        ImeiBan imelBan = new ImeiBan();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM ImeiBan where Id = :Id", ImeiBan.class);
            query.setParameter("Id", Id);
            imelBan = (ImeiBan) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imelBan;
    }

    public ImeiBan SelectImeiBanByMa(String ma) {
        ImeiBan imelBan = new ImeiBan();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM ImeiBan where Ma = :ma", ImeiBan.class);
            query.setParameter("ma", ma);
            imelBan = (ImeiBan) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imelBan;
    }

    public Boolean InsertImeiBan(ImeiBan imelBan) {
        try(Session session = HibernatUtil.getSession()) {
            Transaction tran = session.getTransaction();
            tran.begin();
            session.save(imelBan);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean UpdateImeiBan(ImeiBan imelBan) {
        Transaction tran = null;
        try {
            session = HibernatUtil.getSession();
            tran = session.beginTransaction();
            imelBan.setLastModifiedDate(new Date());
            session.saveOrUpdate(imelBan);
            tran.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete(ImeiBan imelb) {
        Transaction transaction = null;
        try {
            session = HibernatUtil.getSession();
            transaction = session.beginTransaction();
            session.delete(imelb);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public List<ImeiBan> selectALLImeiBan(UUID hdct, String text) {
        List<ImeiBan> listImeiBan = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM ImeiBan WHERE IdHoaDonChiTiet = :hdct and TrangThai = 1 "
                    + "and ma LIKE concat('%', :text ,'%')", ImeiBan.class);
            query.setParameter("hdct", hdct);
            query.setParameter("text", text);
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
                listImeiBan = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listImeiBan;
    }
    public List<ImeiBan> selectALLImeiTra(UUID hdct) {
        List<ImeiBan> listImeiBan = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM ImeiBan WHERE IdHoaDonChiTiet = :hdct and TrangThai = 0", ImeiBan.class);
            query.setParameter("hdct", hdct);
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
                listImeiBan = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listImeiBan;
    }
}
