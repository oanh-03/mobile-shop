/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.Imei;
import com.poly.it17322.nhom6.utilities.HibernatUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author LiamTrieu
 */
public class ImeiRepository {

    private Session session = HibernatUtil.getSession();

    public List<Imei> selectALLImei() {
        List<Imei> listImei = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM Imei", Imei.class);
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
                listImei = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listImei;
    }

    public Imei SelectImeiById(UUID Id) {
        Imei imel = new Imei();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM Imei where Id = :Id", Imei.class);
            query.setParameter("Id", Id);
            imel = (Imei) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imel;
    }

    public Boolean InsertImei(Imei imel) {
        try {
            session = HibernatUtil.getSession();
            Transaction tran = session.getTransaction();
            tran.begin();
            session.save(imel);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean UpdateImei(Imei imel) {
        Transaction tran = null;
        try {
            session = HibernatUtil.getSession();
            tran = session.beginTransaction();
            imel.setLastModifiedDate(new Date());
            session.saveOrUpdate(imel);
            tran.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Imei> Selectmamel(UUID ctSP, String text) {
        List<Imei> lstImei = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM Imei WHERE IdChiTietSP = :ctsp and TrangThai = 1 and ma LIKE concat('%', :text ,'%')", Imei.class);
            query.setParameter("ctsp", ctSP);
            query.setParameter("text", text);
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
                lstImei = query.getResultList();
            }
        } catch (Exception e) {
            return new ArrayList<>();
        }
        return lstImei;
    }

    public Imei SelectImeiBanByMa(String ma) {
        Imei imel = new Imei();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM Imei where ma = :ma", Imei.class);
            query.setParameter("ma", ma);
            imel = (Imei) query.getSingleResult();
        } catch (NoResultException e) {
        } catch (Exception e) {
        }
        return imel;
    }
    
     public Boolean delete(Imei imel) {
        Transaction transaction = null;
        try {
            session = HibernatUtil.getSession();
            transaction = session.beginTransaction();
            session.delete(imel);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }
    
}
