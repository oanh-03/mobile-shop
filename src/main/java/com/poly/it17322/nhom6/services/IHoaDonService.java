/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17322.nhom6.services;

import com.poly.it17322.nhom6.domainmodels.HoaDon;
import com.poly.it17322.nhom6.responses.HoaDonChiTietResponse;
import com.poly.it17322.nhom6.responses.HoaDonResponse;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Rùa
 */
public interface IHoaDonService {
   List<HoaDonResponse>SelectHoaDon();
    List<HoaDonResponse> getByCodeAndCreateDate(String ma, Date from, Date to);
    List<HoaDonResponse> getByCodeAndUpdateDate(String ma, Date from, Date to);
    List<HoaDonChiTietResponse> SelectByHoaDonCTID(UUID IdHoaDon);
}
