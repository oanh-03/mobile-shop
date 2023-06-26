/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.responses;

import com.poly.it17322.nhom6.domainmodels.KhuyenMai;
import java.util.Date;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author LiamTrieu
 */
@Getter
@Setter
@NoArgsConstructor
public class KhuyenMaiDateRespone {

    private UUID id;
    private Date ngayBD;
    private Date ngayKT;

    public KhuyenMaiDateRespone(KhuyenMai km) {
        try {
            this.id = km.getId();
            this.ngayBD = km.getNgayBD();
            this.ngayKT = km.getNgayKT();
        } catch (Exception e) {
        }
    }
}
