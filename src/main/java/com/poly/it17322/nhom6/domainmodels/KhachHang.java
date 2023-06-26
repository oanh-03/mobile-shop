/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.domainmodels;

import java.io.Serializable;
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
@Table(name = "KhachHang")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class KhachHang implements Serializable {

    @Id
    @Column(name = "Id")
    @GeneratedValue
    private UUID id;

    @Column(name = "Ma", unique = true, length = 20)
    private String ma;

    @Nationalized
    @Column(name = "HoTen", length = 50, nullable = false)
    private String hoTen;

    @Column(name = "GioiTinh", nullable = true)
    private int gioiTinh;
    
    @Column(name = "CapDo", nullable = true)
    private int capDo;

    @Column(name = "Sdt", length = 15, nullable = false)
    private String sdt;
    
    @Nationalized
    @Column(name = "DiaChi", length = 100, nullable = true)
    private String diaChi;

    @Column(name = "NgayTutHang")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngayTutHang;

    @Column(name = "NgaySinh")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngaySinh;

    @Column(name = "CreatedDate", insertable = false, updatable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdDate;

    @Column(name = "lastModifiedDate", insertable = false)
    private Date lastModifiedDate;

    @Column(name = "Deleted", insertable = false)
    private boolean deleted;
}
