/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.domainmodels;

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
@Table(name = "BaoHanh")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BaoHanh {

    @Id
    @Column(name = "Id")
    @GeneratedValue
    private UUID Id;

    @Column(name = "Ma", unique = true, length = 20)
    private String ma;

    @Column(name = "TrangThai", nullable = false)
    private int trangThai;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdImel", referencedColumnName = "id")
    private Imei imel;

    @Column(name = "NgayBaoHanh")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngayBaoHanh;
    
    @Column(name = "NgayHoanThanh")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngayHoanThanh;
    
    @Column(name = "NgayKhachLay ")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngayKhachLay;
    
    @Nationalized
    @Column(name = "LyDo", length = 100)
    private String lyDo;
    
    @Nationalized
    @Column(name = "MoTa", length = 100)
    private String moTa;
    
    @Column(name = "CreatedDate", insertable = false, updatable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdDate;

    @Column(name = "lastModifiedDate", insertable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastModifiedDate;
}
