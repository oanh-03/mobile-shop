/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.HoaDonChiTiet;
import com.poly.it17322.nhom6.utilities.HibernatUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.Query;

/**
 *
 * @author LiamTrieu
 */
public class HoaDonChiTietRepository {

    private Session session = HibernatUtil.getSession();

    public List<HoaDonChiTiet> selectALLHoaDonChiTiet() {
        List<HoaDonChiTiet> listHoaDonChiTiet = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM HoaDonChiTiet", HoaDonChiTiet.class);
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
                listHoaDonChiTiet = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDonChiTiet;
    }

    public List<HoaDonChiTiet> SelectByHoaDonCTID(UUID id) {
        List<HoaDonChiTiet> listHoaDonChiTiet = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM HoaDonChiTiet where IdHoaDon = :id", HoaDonChiTiet.class);
            query.setParameter("id", id);
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
                listHoaDonChiTiet = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDonChiTiet;
    }

    public HoaDonChiTiet SelectHoaDonChiTietById(UUID Id) {
        HoaDonChiTiet hdct = new HoaDonChiTiet();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM HoaDonChiTiet where Id = :Id", HoaDonChiTiet.class);
            query.setParameter("Id", Id);
            hdct = (HoaDonChiTiet) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hdct;
    }

    public Boolean InsertHoaDonChiTiet(HoaDonChiTiet hdct) {
        try {
            session = HibernatUtil.getSession();
            Transaction tran = session.getTransaction();
            tran.begin();
            session.save(hdct);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean UpdateHoaDonChiTiet(HoaDonChiTiet hdct) {
        Transaction tran = null;
        try {
            session = HibernatUtil.getSession();
            tran = session.beginTransaction();
            hdct.setLastModifiedDate(new Date());
            session.saveOrUpdate(hdct);
            tran.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete(HoaDonChiTiet hdct) {
        Transaction transaction = null;
        try {
            session = HibernatUtil.getSession();
            transaction = session.beginTransaction();
            session.delete(hdct);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public HoaDonChiTiet getGH(UUID idhd, UUID idsp) {
        HoaDonChiTiet hds = new HoaDonChiTiet();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM HoaDonChiTiet WHERE IdHoaDon = :idhd and IdChiTietSP = :idsp and TrangThai = 1", HoaDonChiTiet.class);
            query.setParameter("idhd", idhd);
            query.setParameter("idsp", idsp);
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
                hds = (HoaDonChiTiet) query.getSingleResult();
            }
            return hds;
        } catch (NoResultException e) {
            return hds;
        }
    }

    public HoaDonChiTiet getGHTra(UUID idhd, UUID idsp) {
        HoaDonChiTiet hds = new HoaDonChiTiet();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM HoaDonChiTiet WHERE IdHoaDon = :idhd and IdChiTietSP = :idsp and TrangThai = 0", HoaDonChiTiet.class);
            query.setParameter("idhd", idhd);
            query.setParameter("idsp", idsp);
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
                hds = (HoaDonChiTiet) query.getSingleResult();
            }
            return hds;
        } catch (NoResultException e) {
            return hds;
        }
    }

}
