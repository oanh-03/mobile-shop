/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.HoaDon;
import com.poly.it17322.nhom6.domainmodels.HoaDonChiTiet;
import com.poly.it17322.nhom6.utilities.HibernatUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author Rùa
 */
public class HoaDonRepository1 {

    private Session session = HibernatUtil.getSession();

    public List<HoaDon> selectALLHoaDon() {
        List<HoaDon> listHoaDon = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM HoaDon", HoaDon.class);
            listHoaDon = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

    public List<HoaDon> getByCodeAndCreateDate(String ma, Date from, Date to) {
        List<HoaDon> list = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            if (from != null && to != null) {
                Query query = session.createQuery("FROM HoaDon where ma like :ma and NgayTao >= :from and NgayTao <= :to", HoaDon.class);
                query.setParameter("ma", "%" + ma + "%");
                query.setParameter("from", from);
                query.setParameter("to", to);
                list = query.getResultList();
            } else {
                Query query = session.createQuery("FROM HoaDon where ma like :ma", HoaDon.class);
                query.setParameter("ma", "%" + ma + "%");
                list = query.getResultList();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public List<HoaDon> getByCodeAndUpdateDate(String ma, Date from, Date to) {
        List<HoaDon> list = new ArrayList<>();
        try  {
            session = HibernatUtil.getSession();
            if (from != null && to != null) {
                Query query = session.createQuery("FROM HoaDon where ma like :ma and NgayThanhToan >= :from and NgayThanhToan <= :to", HoaDon.class);
                query.setParameter("ma", "%" + ma + "%");
                query.setParameter("from", from);
                query.setParameter("to", to);
                list = query.getResultList();
            } else {
                Query query = session.createQuery("FROM HoaDon where ma like :ma", HoaDon.class);
                query.setParameter("ma", "%" + ma + "%");
                list = query.getResultList();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public List<HoaDonChiTiet> SelectByHoaDonCTID(UUID IdHoaDon) {
        List<HoaDonChiTiet> listHoaDonChiTiet = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM HoaDonChiTiet where IdHoaDon = :IdHoaDon", HoaDonChiTiet.class);
            query.setParameter("IdHoaDon", IdHoaDon);
            listHoaDonChiTiet = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDonChiTiet;
    }
    public List<HoaDonChiTiet> SelectByHoaDonCTID2(UUID IdHoaDon) {
        List<HoaDonChiTiet> listHoaDonChiTiet = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM HoaDonChiTiet where IdHoaDon = :IdHoaDon", HoaDonChiTiet.class);
            query.setParameter("IdHoaDon", IdHoaDon);
            listHoaDonChiTiet = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDonChiTiet;
    }
}
