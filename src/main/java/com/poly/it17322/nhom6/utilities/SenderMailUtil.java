/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.utilities;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author LiamTrieu
 */
public class SenderMailUtil {

    private final String mailSender = "cuahangmobiking@gmail.com";
    private final String password = "wethnshaqtadrouq";

    public boolean sendMail(String subject, String text, String toMail) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mailSender, password);
            }
        };
        Session session = Session.getInstance(props, auth);
        MimeMessage msg = new MimeMessage(session);
        try {
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.setFrom(new InternetAddress(mailSender));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toMail, false));
            msg.setSubject(subject,"utf-8");
            msg.setSentDate(new Date());
            msg.setText(text, "utf-8");
            Transport.send(msg);
            return false;
        } catch (Exception e) {
        }
        return true;
    }
}
