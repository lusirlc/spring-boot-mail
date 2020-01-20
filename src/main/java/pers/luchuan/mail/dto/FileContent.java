package pers.luchuan.mail.dto;

import lombok.Data;

/**
 * 邮件附件内容
 */
@Data
public class FileContent extends TextContent {
    /**
     * 附件名称
     */
    private String fileName;
    /**
     * 附件地址
     */
    private String filePath;
}
