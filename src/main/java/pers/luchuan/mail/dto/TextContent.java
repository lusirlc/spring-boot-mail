package pers.luchuan.mail.dto;

import lombok.Data;

/**
 * 邮件文本内容
 */
@Data
public class TextContent extends CommonContent {
    /**
     * 邮件主题
     */
    private String subject;
    /**
     * 邮件文本内容
     */
    private String text;
}
