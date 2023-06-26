/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17322.nhom6.services;

import com.poly.it17322.nhom6.responses.KhuyenMaiResponse;
import java.util.Date;
import java.util.List;

/**
 *
 * @author TUYEN
 */
public interface IKhuyenMaiService {

    List<KhuyenMaiResponse> SelectKhuyenMai();

    List<KhuyenMaiResponse> getByCodeAndCreateDate(String ma, Date from, Date to);

    List<KhuyenMaiResponse> getByCodeAndUpdateDate(String ma, Date from, Date to);
}
