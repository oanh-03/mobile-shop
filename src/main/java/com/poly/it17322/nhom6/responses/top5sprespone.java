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
public class top5sprespone {
    private String ten;
    private String sl;
    private String tongTien;

    public top5sprespone(String ten, String sl, String tongTien) {
        this.ten = ten;
        this.sl = sl;
        this.tongTien = tongTien;
    }
    
    
}
