/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.ManHinh;
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
public class ManHinhRepository {

    private Session session = HibernatUtil.getSession();

    public List<ManHinh> SelectAllManHinh() {
        List<ManHinh> lstManhinh = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM ManHinh", ManHinh.class);
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
            lstManhinh = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstManhinh;
    }

    public ManHinh SelectManHinhById(UUID id) {
        ManHinh manhinh = new ManHinh();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM ManHinh WHERE id =:id", ManHinh.class);
            query.setParameter("id", id);
            manhinh = (ManHinh) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return manhinh;
    }

    public Boolean InsertManHinh(ManHinh manhinh) {
        try{
            session = HibernatUtil.getSession();
            Transaction tran = session.getTransaction();
            tran.begin();
            session.save(manhinh);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean UpdateManHinh(ManHinh manhinh) {
        Transaction tran = null;
        try {
            session = HibernatUtil.getSession();
            tran = session.beginTransaction();
            manhinh.setLastModifiedDate(new Date());
            session.saveOrUpdate(manhinh);
            tran.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
