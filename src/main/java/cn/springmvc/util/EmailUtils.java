package cn.springmvc.util;

import java.util.HashSet;

import org.apache.commons.lang3.StringUtils;
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

    /**
     * @param subject
     * @param msg
     * @param filePath
     * @param description
     * @param toEmail
     * @throws EmailException
     */
    public static void sendEmail(String subject, String msg, String filePath,
            String description, String toEmail) throws EmailException {
        MultiPartEmail multiPartEmail = new MultiPartEmail();
        multiPartEmail.setHostName(hostName);
        multiPartEmail.setAuthentication(userName, password);
        multiPartEmail.setSubject(subject);
        EmailAttachment emailAttachment = new EmailAttachment();
        emailAttachment.setPath(filePath);
        emailAttachment.setDisposition(EmailAttachment.ATTACHMENT);
        emailAttachment.setDescription(description);

        multiPartEmail.setFrom(from);
        multiPartEmail.addTo(toEmail);
        multiPartEmail.setMsg(msg);
        multiPartEmail.attach(emailAttachment);
        multiPartEmail.send();
    }

    /**
     * @param subject
     * @param msg
     * @param toEmail
     * @throws EmailException
     */
    public static void sendSimpleEmail(String subject, String msg,
            String toEmail) throws EmailException {
        SimpleEmail simpleEmail = new SimpleEmail();
        simpleEmail.setHostName(hostName);
        simpleEmail.setAuthentication(userName, password);
        simpleEmail.setSubject(subject);

        simpleEmail.setFrom(from);
        simpleEmail.addTo(toEmail);
        simpleEmail.setMsg(msg);
        simpleEmail.send();
    }
    
    public static String[] getEmails(String emailStr) {
        if (StringUtils.isBlank(emailStr)) {
            return new String[0];
        }
        String[] strs = emailStr.trim().split("\\s*,+\\s*");
        HashSet<String> hashEmails = new HashSet<String>();
        for (String str : strs) {
            if (str.matches("^.+@.+$")) {
                hashEmails.add(str);
            }
        }
        if(hashEmails.size()==0){
            return new String[0];
        }
        String[] emails =  hashEmails.toArray(new String[0]);
        return emails;
    }
}
