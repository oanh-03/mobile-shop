/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.TaiKhoan;
import com.poly.it17322.nhom6.utilities.HibernatUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author LiamTrieu
 */
public class TaiKhoanRepository {

    private Session session = HibernatUtil.getSession();

    public List<TaiKhoan> selectALLTaiKhoan() {
        List<TaiKhoan> listTaiKhoan = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM TaiKhoan", TaiKhoan.class);
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
            listTaiKhoan = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTaiKhoan;
    }

    public TaiKhoan SelectTaiKhoanById(UUID Id) {
        TaiKhoan tk = new TaiKhoan();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM TaiKhoan where Id = :Id", TaiKhoan.class);
            query.setParameter("Id", Id);
            tk = (TaiKhoan) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tk;
    }

    public Boolean InsertTaiKhoan(TaiKhoan tk) {
        try {
            session = HibernatUtil.getSession();
            Transaction tran = session.getTransaction();
            tran.begin();
            session.save(tk);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean UpdateTaiKhoan(TaiKhoan tk) {
        Transaction tran = null;
        try {
            session = HibernatUtil.getSession();
            tran = session.beginTransaction();
            tk.setLastModifiedDate(new Date());
            session.saveOrUpdate(tk);
            tran.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public TaiKhoan checkTK(String tk, String mk) {
        session = HibernatUtil.getSession();
        Query query = session.createQuery("FROM TaiKhoan WHERE email = :tk and matKhau = :mk");
        query.setParameter("tk", tk);
        query.setParameter("mk", mk);
        try {
            return (TaiKhoan) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public UUID checkEmail(String mail) {
        session = HibernatUtil.getSession();
        Query query = session.createQuery("FROM TaiKhoan WHERE email = :mail");
        query.setParameter("mail", mail);
        TaiKhoan result = new TaiKhoan();
        try {
            return ((TaiKhoan) query.getSingleResult()).getId();
        } catch (NoResultException e) {
            return null;
        }
    }
}
