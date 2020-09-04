package com.jingang.springinterfacetest.utils.vo;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * @program: jg-api-autotest
 * @description: 邮件信息类对象
 * @author: LiuGang
 * @create: 2020-01-09 17:08
 **/
@Data
public class MailVo {

    private String id; //邮件id
    private String from; //邮件发送人
    private String to; //邮件接收人
    private String subject; //邮件主题
    private String text; //邮件内容
    private Date sentDate; //发送时间
    private String cc; //抄送
    private String bcc; //密送
    private String status; //状态
    private String error; //报错信息
    //    @JsonIgnore    -- jackson的排除属性不进行序列号的注解
    @JSONField(serialize = false)
    private MultipartFile[] multipartFiles; //邮件附件


}
