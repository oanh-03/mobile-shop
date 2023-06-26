/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.utilities;

import com.poly.it17322.nhom6.domainmodels.*;
import java.util.Properties;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author LiamTrieu
 */
public class HibernatUtil {

    private static final SessionFactory FACTORY;
    private static Session SESSION = null;

    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=Nhom6_IT17322_QuanLyCuaHangDienThoai;encrypt=true;trustServerCertificate=true");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "sa");
        properties.put(Environment.SHOW_SQL, "true");

        conf.setProperties(properties);
        conf.addAnnotatedClass(HoaDon.class);
        conf.addAnnotatedClass(HoaDonChiTiet.class);
        conf.addAnnotatedClass(ChiTietSP.class);
        conf.addAnnotatedClass(CPU.class);
        conf.addAnnotatedClass(ManHinh.class);
        conf.addAnnotatedClass(Pin.class);
        conf.addAnnotatedClass(Imei.class);
        conf.addAnnotatedClass(KhachHang.class);
        conf.addAnnotatedClass(KhuyenMai.class);
        conf.addAnnotatedClass(MauSac.class);
        conf.addAnnotatedClass(Ram.class);
        conf.addAnnotatedClass(Rom.class);
        conf.addAnnotatedClass(SanPham.class);
        conf.addAnnotatedClass(TaiKhoan.class);
        conf.addAnnotatedClass(ImeiBan.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static Session getSession() {
        if (SESSION == null || !SESSION.isConnected()) {
            SESSION = FACTORY.openSession();
        }
        return SESSION;
    }
}
