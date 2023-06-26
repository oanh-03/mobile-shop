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
@Table(name = "HoaDonChiTiet")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HoaDonChiTiet implements Serializable {

    @Id
    @Column(name = "Id")
    @GeneratedValue
    private UUID Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdHoaDon", nullable = false)
    private HoaDon hoaDon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdChiTietSP", nullable = false)
    private ChiTietSP chiTietSP;

    @Nationalized
    @Column(name = "TenSP", length = 100, nullable = false)
    private String tenSP;
    
    @Column(name = "DonGia", nullable = true)
    private BigDecimal donGia;
    
    @Column(name = "Thanhtien", nullable = true)
    private BigDecimal thanhTien;
    
    @Column(name = "SoLuong", nullable = false)
    private int soLuong;
    
    @Column(name = "TrangThai")
    private int trangThai;
    
    @Column(name = "KhuyenMai", nullable = true)
    private BigDecimal khuyenMai;

    @Column(name = "CreatedDate", insertable = false, updatable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdDate;

    @Column(name = "lastModifiedDate", insertable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastModifiedDate;
}
