/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.TaiKhoan;
import com.poly.it17322.nhom6.responses.NhanVienRespone;
import com.poly.it17322.nhom6.utilities.HibernatUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author tuan0
 */
public class ChucNangNhanVienRepository {

    private Session session = HibernatUtil.getSession();
    
    public List<TaiKhoan> timKiem(String ten, int trangThai) {
        List<TaiKhoan> listTaiKhoan = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM TaiKhoan WHERE HoTen like :ten and TrangThai = :trangThai order by Ma desc", TaiKhoan.class);
            query.setParameter("ten","%" + ten + "%");
            query.setParameter("trangThai", trangThai);
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
                listTaiKhoan = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTaiKhoan;
    }

    public List<TaiKhoan> selectTaiKhoan(int trangThai) {
        List<TaiKhoan> listTaiKhoan = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM TaiKhoan WHERE TrangThai = :trangThai order by Ma desc", TaiKhoan.class);
            query.setParameter("trangThai", trangThai);
            listTaiKhoan = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTaiKhoan;
    }
}
