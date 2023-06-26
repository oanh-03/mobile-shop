/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.services.impl;

import com.poly.it17322.nhom6.domainmodels.HoaDon;
import com.poly.it17322.nhom6.domainmodels.HoaDonChiTiet;
import com.poly.it17322.nhom6.repositories.ChiTietSPRepository;
import com.poly.it17322.nhom6.repositories.HoaDonChiTietRepository;
import com.poly.it17322.nhom6.repositories.HoaDonRepository;
import com.poly.it17322.nhom6.responses.BieuDoRespone;
import com.poly.it17322.nhom6.responses.HoaDonThongKeRespone;
import com.poly.it17322.nhom6.responses.top5sprespone;
import com.poly.it17322.nhom6.utilities.HibernatUtil;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

/**
 *
 * @author LiamTrieu
 */
public class ThongKeServiceIml {

    private HoaDonRepository hd = new HoaDonRepository();
    private HoaDonChiTietRepository hdct = new HoaDonChiTietRepository();
    private ChiTietSPRepository ctspr = new ChiTietSPRepository();

    public List<HoaDonThongKeRespone> getHDByDate(Date from, Date to) {
        List<HoaDon> lstHd = hd.getHDByDate(from, to);
        List<HoaDonThongKeRespone> lsthdtk = new ArrayList<>();
        for (HoaDon s : lstHd) {
            List<HoaDonChiTiet> lsthdct = hdct.SelectByHoaDonCTID(s.getId());
            HoaDonThongKeRespone hd = new HoaDonThongKeRespone(s, lsthdct);
            lsthdtk.add(hd);
        }
        return lsthdtk;
    }

    public List<top5sprespone> getTop(Date from, Date to) {
        List<top5sprespone> lstTop5 = new ArrayList<>();
        try {
            Session session = HibernatUtil.getSession();
            NativeQuery query = session.createNativeQuery("Select B.Ten as ten, C.Ten as mausac, D.Ten as ram,E.Ten as rom,\n"
                    + "SUM(G.SoLuong) as soluong, SUM(H.TongTien) as tongtien\n"
                    + "From ChiTietSP A\n"
                    + "join SanPham B on A.IdSP = B.Id\n"
                    + "join MauSac C on C.Id = A.IdMauSac\n"
                    + "join Ram D on D.Id = A.IdRam\n"
                    + "join Rom E on E.Id = A.IdRom\n"
                    + "join HoaDonChiTiet G on G.IdChiTietSP = A.Id\n"
                    + "join HoaDon H on G.IdHoaDon = H.Id\n"
                    + "where ngayThanhToan >= :from and ngayThanhToan <= :to and H.TrangThai in (3,4)\n"
                    + "Group by B.Ten, C.Ten, D.Ten,E.Ten\n"
                    + "order by SUM(G.SoLuong) desc");
            query.setParameter("from", from.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            query.setParameter("to", to.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            List<Object[]> lsto = query.getResultList();
            for (Object[] o : lsto) {
                String ten = o[0].toString();
                String mausac = o[1].toString();
                String ram = o[2].toString();
                String rom = o[3].toString();
                String sl = o[4].toString();
                String tongTien = o[5].toString();
                lstTop5.add(new top5sprespone(ten, sl, tongTien));
            }
        } catch (Exception e) {
        }

        return lstTop5;
    }

    public BigDecimal getChartYear(int year) {
        Session session = HibernatUtil.getSession();
        Query query = session.createQuery("from HoaDon where YEAR(NgayThanhToan) = :year and TrangThai in (3,4)", HoaDon.class);
        query.setParameter("year", year);
        BigDecimal tien = new BigDecimal(0);
        try {
            for (HoaDon s : (List<HoaDon>) query.getResultList()) {
                tien = tien.add(s.getTongTien());
            }
        } catch (Exception e) {
        }
        return tien;
    }

    public BigDecimal getChartMonth(int year, int month) {
        Session session = HibernatUtil.getSession();
        Query query = session.createQuery("from HoaDon where MONTH(NgayThanhToan) = :month and YEAR(NgayThanhToan) = :year and TrangThai in (3,4)", HoaDon.class);
        query.setParameter("month", month);
        query.setParameter("year", year);
        BigDecimal tien = new BigDecimal(0);
        try {
            for (HoaDon s : (List<HoaDon>) query.getResultList()) {
                tien = tien.add(s.getTongTien());
            }
        } catch (Exception e) {
        }
        return tien;
    }

    public BigDecimal getChartDay(int year, int month, int day) {
        Session session = HibernatUtil.getSession();
        Query query = session.createQuery("from HoaDon where MONTH(NgayThanhToan) = :month and YEAR(NgayThanhToan) = :year and DAY(NgayThanhToan) = :day and TrangThai in (3,4)", HoaDon.class);
        query.setParameter("day", day);
        query.setParameter("month", month);
        query.setParameter("year", year);
        BigDecimal tien = new BigDecimal(0);
        try {
            for (HoaDon s : (List<HoaDon>) query.getResultList()) {
                tien = tien.add(s.getTongTien());
            }
        } catch (Exception e) {
        }
        return tien;
    }

    public Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }

    public List<BieuDoRespone> getChartKhoang(Date from, Date to) {
        List<BieuDoRespone> lstBieuDo = new ArrayList<>();
        Date d = from;
        while (d.compareTo(to) <= 0) {
            List<HoaDon> list = hd.getHDByDate(d, d);
            BigDecimal tongTien = new BigDecimal(0);
            for (HoaDon s : list) {
                tongTien = tongTien.add(s.getTongTien());
            }
            lstBieuDo.add(new BieuDoRespone(new SimpleDateFormat("dd-MM-yyyy").format(d), tongTien));
            d = addDays(d, 1);
        }
        return lstBieuDo;
    }

}
