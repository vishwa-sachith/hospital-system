/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasess;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Asus
 */
public class Send_Email {
    public static void sendMail(String ID,String Password) {
        String host = "smtp.gmail.com";
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", "adpasindupriyashan@gmail.com");
        props.put("mail.smtp.password", "Mclean19950722@");
        props.put("mail.smtp.port", 25);
        props.put("mail.smtp.auth", "true");
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.socketFactory.port", 25);

        Session session = Session.getDefaultInstance(props, null);
        session.setDebug(true);
        MimeMessage mimeMessage = new MimeMessage(session);
        try {
            mimeMessage.setFrom(new InternetAddress("adpasindupriyashan@gmail.com"));
            InternetAddress[] toAddress = new InternetAddress[new String[]{"adpasindupriyashan@outlook.com"}.length];
            for (int i = 0; i < new String[]{"adpasindupriyashan@gmail.com"}.length; i++) {
                toAddress[i] = new InternetAddress(new String[]{"adpasindupriyashan@outlook.com"}[i]);
            }
            for (int i = 0; i < toAddress.length; i++) {
                mimeMessage.addRecipient(RecipientType.TO, toAddress[i]);
            }
            mimeMessage.setSubject("Password Recovery for "+ID+"v");// subject of email
            mimeMessage.setText("System genarated Password is > "+Password);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, "adpasindupriyashan@gmail.com", "Mclean19950722@");
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            transport.close();
        } catch (MessagingException me) {
            JOptionPane.showMessageDialog(null, "Please connect your computer to internet for send random password for admin");
        }
    }
}
