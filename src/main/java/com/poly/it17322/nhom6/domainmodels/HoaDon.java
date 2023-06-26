/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.domainmodels;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "HoaDon")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HoaDon implements Serializable {

    @Id
    @Column(name = "Id")
    @GeneratedValue
    private UUID Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdKH", referencedColumnName = "id")
    private KhachHang khachHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdTK", referencedColumnName = "id")
    private TaiKhoan taiKhoan;

    @Column(name = "Ma", unique = true, nullable = false, length = 20)
    private String ma;
    
    @Column(name = "MaGiaoDich",length = 20)
    private String maGiaoDich;

    @Column(name = "NgayTao")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngayTao;

    @Column(name = "NgayThanhToan")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngayThanhToan;
    
    @Column(name = "NgayNhanHang")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngayNhanHang;
    
    @Column(name = "NgayShip")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngayShip;

    @Column(name = "NgayNhanMongMuon")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date ngayNhanMongMuon;

    @Column(name = "TienShip")
    private BigDecimal tienShip;

    @Column(name = "TienThua")
    private BigDecimal tienThua;

    @Column(name = "TienMat")
    private BigDecimal tienMat;

    @Column(name = "ChuyenKhoan")
    private BigDecimal chuyenKhoan;

    @Nationalized
    @Column(name = "TenKH", length = 50)
    private String tenKH;

    @Nationalized
    @Column(name = "DiaChi", length = 100)
    private String diaChi;

    @Column(name = "TongTien")
    private BigDecimal tongTien;

    @Column(name = "TrangThai")
    private int trangThai;
    
    @Column(name = "SoLanShip")
    private int soLanShip;

    @Column(name = "SdtNguoiShip", length = 30)
    private String sdtNguoiShip;

    @Nationalized
    @Column(name = "TenNguoiShip", length = 50)
    private String tenNguoiShip;

    @Column(name = "SdtNguoiNhan", length = 30)
    private String sdtNguoiNhan;

    @Column(name = "LoaiThanhToan")
    private int loaiThanhToan;

    @Column(name = "GiamGia")
    private BigDecimal giamGia;

    @Nationalized
    @Column(name = "LyDo", length = 100)
    private String lyDo;

    @Column(name = "lastModifiedDate", insertable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastModifiedDate;
}
