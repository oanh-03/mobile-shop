/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.Rom;
import com.poly.it17322.nhom6.utilities.HibernatUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RomRepository {

    private Session session = HibernatUtil.getSession();

    public List<Rom> selectALLRom() {
        List<Rom> listRom = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM Rom", Rom.class);
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
            listRom = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listRom;
    }

    public Rom SelectRomById(UUID Id) {
        Rom rom = new Rom();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM Rom where Id = :Id", Rom.class);
            query.setParameter("Id", Id);
            rom = (Rom) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rom;
    }

    public Boolean InsertRom(Rom rom) {
        try {
            session = HibernatUtil.getSession();
            Transaction tran = session.getTransaction();
            tran.begin();
            session.save(rom);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean UpdateRom(Rom rom) {
        Transaction tran = null;
        try {
            session = HibernatUtil.getSession();
            tran = session.beginTransaction();
            rom.setLastModifiedDate(new Date());
            session.saveOrUpdate(rom);
            tran.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
