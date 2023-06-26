/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.domainmodels;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Nationalized;

/**
 *
 * @author LiamTrieu
 */
@Entity
@Table(name = "TaiKhoan")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TaiKhoan {

    @Id
    @Column(name = "Id")
    @GeneratedValue
    private UUID Id;

    @Column(name = "Ma", unique = true, length = 20)
    private String ma;

    @Column(name = "HoTen", length = 50, nullable = false)
    @Nationalized
    private String hoTen;

    @Column(name = "GioiTinh", nullable = true)
    private int gioiTinh;

    @Column(name = "NgaySinh", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngaySinh;

    @Column(name = "DiaChi", length = 100, nullable = true)
    @Nationalized
    private String diaChi;

    @Column(name = "Email", length = 100, nullable = false)
    private String email;

    @Column(name = "Sdt", length = 15, nullable = true)
    private String sdt;

    @Column(name = "MatKhau", length = 100, nullable = false)
    private String matKhau;

    @Column(name = "ChucVu", nullable = false)
    private int chucVu;

    @Column(name = "TrangThai", nullable = false)
    private int trangThai;
    
    @Column(name = "HinhAnh")
    private String hinhAnh;


    @Column(name = "CreatedDate", insertable = false, updatable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdDate;

    @Column(name = "lastModifiedDate", insertable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastModifiedDate;
}
