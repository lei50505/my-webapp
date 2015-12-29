package cn.springmvc.util;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.springframework.stereotype.Component;

@Component
public class EmailUtils {
    
    private static final String hostName = ConfigUtils
            .getString("email.host_name");
    private static final String userName = ConfigUtils
            .getString("email.user_name");
    private static final String password = ConfigUtils
            .getString("email.password");
    private static final String to = ConfigUtils.getString("email.to");
    private static final String from = ConfigUtils.getString("email.from");
    
    public static void sendEmail(String subject, String msg,String path,String description) throws EmailException{
        MultiPartEmail multiPartEmail = new MultiPartEmail();
        multiPartEmail.setHostName(hostName);
        multiPartEmail.setAuthentication(userName, password);
        multiPartEmail.addTo(to);
        multiPartEmail.setFrom(from);
        multiPartEmail.setSubject(subject);
        multiPartEmail.setMsg(msg);
        EmailAttachment emailAttachment = new EmailAttachment();
        emailAttachment.setPath(path);
        emailAttachment.setDisposition(EmailAttachment.ATTACHMENT);
        emailAttachment.setDescription(description);
        multiPartEmail.attach(emailAttachment);
        
        multiPartEmail.send();
   }
    
    public static void main(String[] args) throws EmailException {
        MultiPartEmail multiPartEmail = new MultiPartEmail();
        multiPartEmail.setHostName("smtp.163.com");
        multiPartEmail.setAuthentication("caolei_0409@163.com", "kzyjmaexqogddvve");
        multiPartEmail.addTo("183515951@qq.com");
        multiPartEmail.setFrom("caolei_0409@163.com");
        multiPartEmail.setSubject("aaa");
        multiPartEmail.setMsg("aaa");
        EmailAttachment emailAttachment = new EmailAttachment();
        emailAttachment.setPath("/Users/admin/Downloads/物流红包系统.pdf");
        emailAttachment.setDisposition(EmailAttachment.ATTACHMENT);
        emailAttachment.setDescription("物流红包系统.pdf");
        multiPartEmail.attach(emailAttachment);
        
        multiPartEmail.send();
    }
}
