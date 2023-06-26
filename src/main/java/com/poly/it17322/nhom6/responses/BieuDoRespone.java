/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.responses;

import java.math.BigDecimal;
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
public class BieuDoRespone {
    private String date;
    private BigDecimal tongTien;

    public BieuDoRespone(String date, BigDecimal tongTien) {
        this.date = date;
        this.tongTien = tongTien;
    }
}
