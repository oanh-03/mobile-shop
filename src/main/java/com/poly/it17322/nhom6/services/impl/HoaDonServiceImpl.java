/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.services.impl;

import com.poly.it17322.nhom6.domainmodels.HoaDon;
import com.poly.it17322.nhom6.domainmodels.HoaDonChiTiet;
import com.poly.it17322.nhom6.repositories.HoaDonRepository;
import com.poly.it17322.nhom6.repositories.HoaDonRepository1;
import com.poly.it17322.nhom6.responses.HoaDonChiTietResponse;
import com.poly.it17322.nhom6.responses.HoaDonResponse;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Id;
import com.poly.it17322.nhom6.services.IHoaDonService;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 *
 * @author Rùa
 */
public class HoaDonServiceImpl implements IHoaDonService {

    private HoaDonRepository1 hoadonRepository = new HoaDonRepository1();

    @Override
    public List<HoaDonResponse> SelectHoaDon() {
        List<HoaDon> hoadons = hoadonRepository.selectALLHoaDon();
        return hoadons.stream().map(HoaDonResponse::new).collect(Collectors.toList());
    }

    @Override
    public List<HoaDonResponse> getByCodeAndCreateDate(String ma, Date from, Date to) {
        List<HoaDon> hoadons = hoadonRepository.getByCodeAndCreateDate(ma, from, to);
        return hoadons.stream().map(HoaDonResponse::new).collect(Collectors.toList());
    }

    @Override
    public List<HoaDonResponse> getByCodeAndUpdateDate(String ma, Date from, Date to) {
        List<HoaDon> hoadons = hoadonRepository.getByCodeAndUpdateDate(ma, from, to);
        return hoadons.stream().map(HoaDonResponse::new).collect(Collectors.toList());
    }

    @Override
    public List<HoaDonChiTietResponse> SelectByHoaDonCTID(UUID IdHoaDon) {
        List<HoaDonChiTiet> hoaDonList = hoadonRepository.SelectByHoaDonCTID(IdHoaDon);
        List<HoaDonChiTietResponse> response = hoaDonList.stream().map(hoaDon -> new HoaDonChiTietResponse(hoaDon)).collect(Collectors.toList());
        return response;
    }
}
