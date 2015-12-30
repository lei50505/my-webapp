package cn.springmvc.util;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Component;

@Component
public class EmailUtils {

    private static final String hostName = ConfigUtils
            .getString("email.host_name");
    private static final String userName = ConfigUtils
            .getString("email.user_name");
    private static final String password = ConfigUtils
            .getString("email.password");
    private static final String from = ConfigUtils.getString("email.from");

    public static void sendEmail(String subject, String msg, String fileName,
            String toEmail) {
        MultiPartEmail multiPartEmail = new MultiPartEmail();
        multiPartEmail.setHostName(hostName);
        multiPartEmail.setAuthentication(userName, password);
        multiPartEmail.setSubject(subject);
        EmailAttachment emailAttachment = new EmailAttachment();
        emailAttachment.setPath(fileName);
        emailAttachment.setDisposition(EmailAttachment.ATTACHMENT);
        emailAttachment.setDescription(fileName);
        try {
            multiPartEmail.setFrom(from);
            multiPartEmail.addTo(toEmail);
            multiPartEmail.setMsg(msg);
            multiPartEmail.attach(emailAttachment);
            multiPartEmail.send();
        } catch (EmailException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sendSimpleEmail(String subject, String msg,
            String toEmail) {
        SimpleEmail simpleEmail = new SimpleEmail();
        simpleEmail.setHostName(hostName);
        simpleEmail.setAuthentication(userName, password);
        simpleEmail.setSubject(subject);
        try {
            simpleEmail.addTo(toEmail);
            simpleEmail.setFrom(from);
            simpleEmail.setMsg(msg);
            simpleEmail.send();
        } catch (EmailException e) {
            throw new RuntimeException(e);
        }
    }

}
