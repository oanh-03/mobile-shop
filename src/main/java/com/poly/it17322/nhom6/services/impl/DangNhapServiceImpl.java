/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.services.impl;

import com.poly.it17322.nhom6.domainmodels.TaiKhoan;
import com.poly.it17322.nhom6.repositories.TaiKhoanRepository;
import com.poly.it17322.nhom6.responses.UserResponse;
import com.poly.it17322.nhom6.services.IDangNhapService;
import java.util.UUID;

/**
 *
 * @author LiamTrieu
 */
public class DangNhapServiceImpl implements IDangNhapService {

    private TaiKhoanRepository tkdnRepo = new TaiKhoanRepository();

    @Override
    public UserResponse checkTK(String tk, String pass) {
        try {
            UserResponse user = new UserResponse(tkdnRepo.checkTK(tk, pass));
            if (user.getTrangThai() == 0) {
                return user;
            }
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public UUID checkMail(String mail) {
        return tkdnRepo.checkEmail(mail);
    }

    @Override
    public boolean resetPass(String pass, String mail) {
        UUID id = tkdnRepo.checkEmail(mail);
        TaiKhoan tk = tkdnRepo.SelectTaiKhoanById(id);
        tk.setMatKhau(pass);
        return tkdnRepo.UpdateTaiKhoan(tk);
    }
}
