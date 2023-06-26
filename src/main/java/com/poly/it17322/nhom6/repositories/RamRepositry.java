/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.Ram;
import com.poly.it17322.nhom6.utilities.HibernatUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RamRepositry {

    private Session session = HibernatUtil.getSession();

    public List<Ram> selectALLRam() {
        List<Ram> listRam = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM Ram", Ram.class);
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
                listRam = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listRam;
    }

    public Ram SelectRamById(UUID Id) {
        Ram ram = new Ram();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM Ram where Id = :Id", Ram.class);
            query.setParameter("Id", Id);
            ram = (Ram) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ram;
    }

    public Boolean InsertRam(Ram ram) {
        try {
            session = HibernatUtil.getSession();
            Transaction tran = session.getTransaction();
            tran.begin();
            session.save(ram);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean UpdateRam(Ram ram) {
       Transaction tran = null;
        try {
            session = HibernatUtil.getSession();
            tran = session.beginTransaction();
            ram.setLastModifiedDate(new Date());
            session.saveOrUpdate(ram);
            tran.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
