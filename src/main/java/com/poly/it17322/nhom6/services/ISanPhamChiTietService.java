/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17322.nhom6.services;

import com.poly.it17322.nhom6.domainmodels.Imei;
import com.poly.it17322.nhom6.responses.CPURespone;
import com.poly.it17322.nhom6.responses.ImeiSPRespone;
import com.poly.it17322.nhom6.responses.ManHinhRespone;
import com.poly.it17322.nhom6.responses.PinRespone;
import com.poly.it17322.nhom6.responses.MauSacRespone;
import com.poly.it17322.nhom6.responses.RamRespone;
import com.poly.it17322.nhom6.responses.RomRespone;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author admin
 */
public interface ISanPhamChiTietService {

    public List<ManHinhRespone> getlistManHinh();

    public boolean insertManHinh(ManHinhRespone manhinh);

    public boolean updateManHinh(ManHinhRespone manhinh);

    public List<RomRespone> getlistRom();

    public boolean insertRom(RomRespone rom);

    public boolean updateRom(RomRespone rom);

    public List<RamRespone> getlistRam();

    public boolean insertRam(RamRespone ram);

    public boolean updateRam(RamRespone ram);

    public List<MauSacRespone> getlistMauSac();

    public boolean insertMauSac(MauSacRespone ms);

    public boolean updateMauSac(MauSacRespone ms);

    public List<PinRespone> getlistPin();

    public boolean insertPin(PinRespone pin);

    public boolean updatePin(PinRespone pin);

    public List<CPURespone> getlistCPU();

    public boolean insertCPU(CPURespone cpu);

    public boolean updateCPU(CPURespone cpu);

    public List<ImeiSPRespone> getListImei(UUID Idctsp);
    
    

}
