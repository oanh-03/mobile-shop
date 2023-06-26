/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.services.impl;

import com.poly.it17322.nhom6.domainmodels.CPU;
import com.poly.it17322.nhom6.domainmodels.ChiTietSP;
import com.poly.it17322.nhom6.domainmodels.Imei;
import com.poly.it17322.nhom6.domainmodels.ManHinh;
import com.poly.it17322.nhom6.domainmodels.Pin;
import com.poly.it17322.nhom6.domainmodels.MauSac;
import com.poly.it17322.nhom6.domainmodels.Ram;
import com.poly.it17322.nhom6.domainmodels.Rom;
import com.poly.it17322.nhom6.repositories.CPURepository;
import com.poly.it17322.nhom6.repositories.ChiTietSPRepository;
import com.poly.it17322.nhom6.repositories.ImeiRepository;
import com.poly.it17322.nhom6.repositories.ManHinhRepository;
import com.poly.it17322.nhom6.repositories.MauSacRepository;
import com.poly.it17322.nhom6.repositories.PinRepository;
import com.poly.it17322.nhom6.repositories.RamRepositry;
import com.poly.it17322.nhom6.repositories.RomRepository;
import com.poly.it17322.nhom6.repositories.SpCTSPRepository;
import com.poly.it17322.nhom6.responses.CPURespone;
import com.poly.it17322.nhom6.responses.ImeiSPRespone;
import com.poly.it17322.nhom6.responses.ManHinhRespone;
import com.poly.it17322.nhom6.responses.PinRespone;
import com.poly.it17322.nhom6.responses.MauSacRespone;
import com.poly.it17322.nhom6.responses.RamRespone;
import com.poly.it17322.nhom6.responses.RomRespone;
import com.poly.it17322.nhom6.services.ISanPhamChiTietService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 *
 * @author admin
 */
public class SanPhamChiTietServiceImpl implements ISanPhamChiTietService {

    RomRepository romrepo = new RomRepository();
    RamRepositry ramrepo = new RamRepositry();
    MauSacRepository mausacrepo = new MauSacRepository();
    CPURepository cpurepo = new CPURepository();
    ManHinhRepository mhrepo = new ManHinhRepository();
    PinRepository pinrepo = new PinRepository();
    SpCTSPRepository imelrepo = new SpCTSPRepository();
    ImeiRepository imrepo = new ImeiRepository();
    ChiTietSPRepository spct = new ChiTietSPRepository();

    @Override
    public List<RomRespone> getlistRom() {
        List<Rom> roms = romrepo.selectALLRom();
        return roms.stream().map(RomRespone::new).collect(Collectors.toList());
    }

    @Override
    public boolean insertRom(RomRespone rom) {
        Rom r = new Rom();
        int so = (romrepo.selectALLRom().size() + 1);
        String maRom = "RO" + so;
        r.setMa(maRom);
        r.setTen(rom.getTen());
        return romrepo.InsertRom(r);
    }

    @Override
    public boolean updateRom(RomRespone rom) {
        Rom r = romrepo.SelectRomById(rom.getId());
        r.setTen(rom.getTen());
        return romrepo.UpdateRom(r);
    }

    @Override
    public List<RamRespone> getlistRam() {
        List<Ram> rams = ramrepo.selectALLRam();
        return rams.stream().map(RamRespone::new).collect(Collectors.toList());
    }

    @Override
    public boolean insertRam(RamRespone ram) {
        Ram r = new Ram();
        int so = (ramrepo.selectALLRam().size() + 1);
        String maRam = "RA" + so;
        r.setMa(maRam);
        r.setTen(ram.getTen());
        return ramrepo.InsertRam(r);
    }

    @Override
    public boolean updateRam(RamRespone ram) {
        Ram r = ramrepo.SelectRamById(ram.getId());
        r.setTen(ram.getTen());
        return ramrepo.UpdateRam(r);
    }

    @Override
    public List<MauSacRespone> getlistMauSac() {
        List<MauSac> mausacs = mausacrepo.selectALLMauSac();
        return mausacs.stream().map(MauSacRespone::new).collect(Collectors.toList());
    }

    @Override
    public boolean insertMauSac(MauSacRespone ms) {
        MauSac m = new MauSac();
        int so = (mausacrepo.selectALLMauSac().size() + 1);
        String maMS = "MS" + so;
        m.setMa(maMS);
        m.setTen(ms.getTen());
        return mausacrepo.InsertMauSac(m);
    }

    @Override
    public boolean updateMauSac(MauSacRespone ms) {
        MauSac m = mausacrepo.SelectMauSacById(ms.getId());
        m.setTen(ms.getTen());
        return mausacrepo.UpdateMauSac(m);
    }

    @Override
    public List<CPURespone> getlistCPU() {
        List<CPU> cpu = cpurepo.selectALLCPU();
        return cpu.stream().map(CPURespone::new).collect(Collectors.toList());
    }

    @Override
    public boolean insertCPU(CPURespone cpu) {
        CPU c = new CPU();
        int so = (cpurepo.selectALLCPU().size() + 1);
        String maCPU = "CPU" + so;
        c.setMa(maCPU);
        c.setTen(cpu.getTen());
        return cpurepo.InsertCPU(c);
    }

    @Override
    public boolean updateCPU(CPURespone cpu) {
        CPU c = cpurepo.SelectCPUById(cpu.getId());
        c.setTen(cpu.getTen());
        return cpurepo.UpdateCPU(c);
    }

    @Override
    public List<ManHinhRespone> getlistManHinh() {
        List<ManHinh> mahinhs = mhrepo.SelectAllManHinh();
        return mahinhs.stream().map(ManHinhRespone::new).collect(Collectors.toList());
    }

    @Override
    public boolean insertManHinh(ManHinhRespone manhinh) {
        ManHinh m = new ManHinh();
        int so = (mhrepo.SelectAllManHinh().size() + 1);
        String maMH = "MH" + so;
        m.setMa(maMH);
        m.setTen(manhinh.getTen());
        return mhrepo.InsertManHinh(m);
    }

    @Override
    public boolean updateManHinh(ManHinhRespone manhinh) {
        ManHinh m = mhrepo.SelectManHinhById(manhinh.getId());
        m.setTen(manhinh.getTen());
        return mhrepo.UpdateManHinh(m);
    }

    @Override
    public List<PinRespone> getlistPin() {
        List<Pin> pins = pinrepo.selectALLPin();
        return pins.stream().map(PinRespone::new).collect(Collectors.toList());
    }

    @Override
    public boolean insertPin(PinRespone pin) {
        Pin p = new Pin();
        int so = (pinrepo.selectALLPin().size() + 1);
        String maPin = "PI" + so;
        p.setMa(maPin);
        p.setTen(pin.getTen());
        return pinrepo.InsertPin(p);
    }

    @Override
    public boolean updatePin(PinRespone pin) {
        Pin p = pinrepo.SelectPinById(pin.getId());
        p.setTen(pin.getTen());
        return pinrepo.UpdatePin(p);
    }

    @Override
    public List<ImeiSPRespone> getListImei(UUID Idctsp) {
        List<Imei> imeis = imelrepo.SelectCBOImeiById(Idctsp);
        return imeis.stream().map(ImeiSPRespone::new).collect(Collectors.toList());
    }

    public boolean updateImei(ImeiSPRespone imel) {
        Imei im = imrepo.SelectImeiById(imel.getId());
        im.setMa(imel.getMa());
        return imrepo.UpdateImei(im);
    }
    public List<ImeiSPRespone> getlistImel() {
        List<Imei> imei = imrepo.selectALLImei();
        return imei.stream().map(ImeiSPRespone::new).collect(Collectors.toList());
    }
    public List<ImeiSPRespone> getlistImelbyMa(String ma) {
        List<Imei> imei = imelrepo.SelectImeiByMa(ma);
        return imei.stream().map(ImeiSPRespone::new).collect(Collectors.toList());
    }
    
    public void deleteImei(String ma, UUID ctsp){
        Imei i = imrepo.SelectImeiBanByMa(ma);
        ChiTietSP sp = spct.SelectChiTietSPById(ctsp);
        sp.setSoLuong(sp.getSoLuong()-1);
        imrepo.delete(i);
        spct.UpdateChiTietSP(sp);
    }
    
}
