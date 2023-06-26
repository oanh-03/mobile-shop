/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.responses;

import com.poly.it17322.nhom6.domainmodels.MauSac;
import com.poly.it17322.nhom6.domainmodels.Rom;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author admin
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class MauSacRespone {

    private UUID id;
    private String ma;
    private String ten;

    public MauSacRespone(MauSac mausac) {
        this.id = mausac.getId();
        this.ma = mausac.getMa();
        this.ten = mausac.getTen();
    }

    public Object[] toDataRow() {
        return new Object[]{ma, ten};
    }
}
