package pers.luchuan.mail.dto;

import lombok.Data;

/**
 * 邮件基本信息
 */
@Data
public class CommonContent {
    /**
     * 发送方名称
     */
    private String sender;
    /**
     * 接受方邮件账户
     */
    private String receiver;
}
