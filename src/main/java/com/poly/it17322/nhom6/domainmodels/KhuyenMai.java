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
@Table(name = "KhuyenMai")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class KhuyenMai {

    @Id
    @Column(name = "Id")
    @GeneratedValue
    private UUID Id;

    @Column(name = "Ma", unique = true, length = 20)
    private String ma;

    @Nationalized
    @Column(name = "Ten", length = 30, nullable = false)
    private String ten;

    @Column(name = "NgayBD")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date ngayBD;

    @Column(name = "NgayKT")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date ngayKT;

    @Column(name = "GiaTri")
    private int giaTri;

    @Column(name = "TrangThai")
    private int trangThai;
    
    @Column(name = "LoaiKM")
    private int loaiKM;

    @Column(name = "CreatedDate", insertable = false, updatable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdDate;

    @Column(name = "lastModifiedDate", insertable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastModifiedDate;


}
