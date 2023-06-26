/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.utilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author LiamTrieu
 */
public class MD5Util {

    public static String md5EnCode(String text) throws NoSuchAlgorithmException {
        String encodeText;
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(text.getBytes());
        byte[] digest = md.digest();
        encodeText = DatatypeConverter.printHexBinary(digest);
        return encodeText;
    }
}
