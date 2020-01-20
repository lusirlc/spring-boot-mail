package pers.luchuan.mail.service;

import pers.luchuan.mail.dto.FileContent;
import pers.luchuan.mail.dto.TextContent;

/**
 * 邮件服务
 */
public interface MailService {
    /**
     * 发送文本邮件
     * @param textContent
     */
    void sendText(TextContent textContent);

    /**
     * 发送附件文件
     * @param fileContent
     */
    void sendFile(FileContent fileContent);
}
