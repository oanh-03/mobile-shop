/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.responses;

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
public class ImeiAoSPRespone {
    private String ma;

    public ImeiAoSPRespone(String ma) {
        this.ma = ma;
    }
    
    public Object[] toDaTaRow(){
        return new Object[]{ma,false};
    }
}
