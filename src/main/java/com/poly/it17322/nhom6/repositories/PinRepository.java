/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.Pin;
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
public class PinRepository {

    private Session session = HibernatUtil.getSession();

    public List<Pin> selectALLPin() {
        List<Pin> listPin = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM Pin", Pin.class);
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
                listPin = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPin;
    }

    public Pin SelectPinById(UUID Id) {
        Pin pin = new Pin();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM Pin where Id = :Id", Pin.class);
            query.setParameter("Id", Id);
            pin = (Pin) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pin;
    }

    public Boolean InsertPin(Pin pin) {
        try {
            session = HibernatUtil.getSession();
            Transaction tran = session.getTransaction();
            tran.begin();
            session.save(pin);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean UpdatePin(Pin pin) {
        Transaction tran = null;
        try {
            session = HibernatUtil.getSession();
            tran = session.beginTransaction();
            pin.setLastModifiedDate(new Date());
            session.saveOrUpdate(pin);
            tran.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
