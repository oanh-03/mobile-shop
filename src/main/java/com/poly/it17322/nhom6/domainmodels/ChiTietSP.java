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

/**
 *
 * @author LiamTrieu
 */
@Entity
@Table(name = "ChiTietSP")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietSP implements Serializable {

    @Id
    @Column(name = "Id")
    @GeneratedValue
    private UUID Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdRom", referencedColumnName = "id")
    private Rom rom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdRam", referencedColumnName = "id")
    private Ram ram;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdMauSac", referencedColumnName = "id")
    private MauSac mauSac;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCPU", referencedColumnName = "id")
    private CPU cpu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdManHinh", referencedColumnName = "id")
    private ManHinh manHinh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdPin", referencedColumnName = "id")
    private Pin pin;

    @Column(name = "LoaiHang")
    private int loaiHang;

    @Column(name = "Gia")
    private BigDecimal gia;

    @Column(name = "SoLuong")
    private int soLuong;
    
    @Column(name = "MoTa")
    private String moTa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdKhuyenMai", referencedColumnName = "id")
    private KhuyenMai khuyenMai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdSP", referencedColumnName = "id")
    private SanPham sanPham;

    @Column(name = "CreatedDate", insertable = false, updatable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdDate;

    @Column(name = "lastModifiedDate", insertable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastModifiedDate;

    @Column(name = "Deleted", insertable = false)
    private boolean deleted;
}
