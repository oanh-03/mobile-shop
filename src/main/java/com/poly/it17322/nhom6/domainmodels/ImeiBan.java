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
 * @author admin
 */
@Entity
@Table(name = "ImeiBan")
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ImeiBan implements Serializable {

    @Id
    @Column(name = "Id")
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdHoaDonChiTiet",nullable = true)
    private HoaDonChiTiet hoaDonChiTiet;

    @Column(name = "Ma", length = 15)
    private String ma;

    @Column(name = "TrangThai")
    private int trangThai;
    
    @Nationalized
    @Column(name = "LyDo", length = 100)
    private String lyDo;

    @Column(name = "CreatedDate", insertable = false, updatable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdDate;

    @Column(name = "lastModifiedDate", insertable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastModifiedDate;
}
