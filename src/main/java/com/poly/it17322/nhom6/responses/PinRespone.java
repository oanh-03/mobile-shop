/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.responses;

import com.poly.it17322.nhom6.domainmodels.Pin;
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
public class PinRespone {

    private UUID id;
    private String ma;
    private String ten;

    public PinRespone(Pin pin) {
        this.id = pin.getId();
        this.ma = pin.getMa();
        this.ten = pin.getTen();
    }

    public Object[] toDataRow() {
        return new Object[]{ma, ten};
    }
}
