package pers.luchuan.mail.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pers.luchuan.mail.dto.FileContent;
import pers.luchuan.mail.dto.TextContent;
import pers.luchuan.mail.service.MailService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Override
    public void sendText(TextContent textContent) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(textContent.getSender());
        message.setTo(textContent.getReceiver());
        message.setSubject(textContent.getSubject());
        message.setText(textContent.getText());
        javaMailSender.send(message);
    }

    @Override
    public void sendFile(FileContent fileContent) {
        // MimeMessage 本身的 API 有些笨重，我们可以使用 MimeMessageHelper
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        // 第二个参数是 true ，表明这个消息是 multipart类型的/
        MimeMessageHelper mimeMessageHelper = null;
        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(fileContent.getSender());
            mimeMessageHelper.setTo(fileContent.getReceiver());
            mimeMessageHelper.setSubject(fileContent.getSubject());
            mimeMessageHelper.setText(fileContent.getText());
            //添加附件,第一个参数表示添加到 Email 中附件的名称，第二个参数是图片资源
            mimeMessageHelper.addAttachment(fileContent.getFileName(), new File(fileContent.getFilePath()));
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
