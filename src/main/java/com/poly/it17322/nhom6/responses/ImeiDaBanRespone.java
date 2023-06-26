/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.responses;

import com.poly.it17322.nhom6.domainmodels.ImeiBan;
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
public class ImeiDaBanRespone {

    private UUID id;
    private String ma;
    private String lyDo;
    

    public ImeiDaBanRespone(ImeiBan imel) {
        this.id = imel.getId();
        this.ma = imel.getMa();
        if (imel.getLyDo() != null) {
            this.lyDo = imel.getLyDo();
        }
    }
}
