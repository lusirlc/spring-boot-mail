package pers.luchuan.mail.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.luchuan.mail.dto.TextContent;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MailServiceImplTest {
    @Autowired
    MailServiceImpl mailService;

    @Test
    public void sendText() {
        TextContent textContent = new TextContent();
        textContent.setSender("luchuan365@126.com");
        textContent.setReceiver("luchuan365@126.com");
        textContent.setSubject("服务异常通知");
        textContent.setText("xxx服务异常");
        mailService.sendText(textContent);
    }

    @Test
    public void sendFile() {
    }
}