/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.CPU;
import com.poly.it17322.nhom6.domainmodels.CPU;
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
public class CPURepository {

    private Session session = HibernatUtil.getSession();

    public List<CPU> selectALLCPU() {
        List<CPU> listCPU = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM CPU", CPU.class);
            if (query.getResultList() != null) {
                listCPU = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCPU;
    }

    public CPU SelectCPUById(UUID Id) {
        CPU cpu = new CPU();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM CPU where Id = :Id", CPU.class);
            query.setParameter("Id", Id);
            if (query.getSingleResult() != null) {
            cpu = (CPU) query.getSingleResult();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cpu;
    }

    public Boolean InsertCPU(CPU cpu) {
        try {
            session = HibernatUtil.getSession();
            Transaction tran = session.getTransaction();
            tran.begin();
            session.save(cpu);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean UpdateCPU(CPU cpu) {
        Transaction tran = null;
        try {
            session = HibernatUtil.getSession();
            tran = session.beginTransaction();
            cpu.setLastModifiedDate(new Date());
            session.saveOrUpdate(cpu);
            tran.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
