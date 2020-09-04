package com.jingang.springinterfacetest.utils;

import com.jingang.springinterfacetest.utils.vo.MailVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * @program: jg-api-autotest
 * @description: 邮件处理相关的工具类
 * @author: LiuGang
 * @create: 2020-01-09 16:43
 **/

//如何通过JavaMailSenderImpl发送邮件？
//        非常简单，直接在业务类注入JavaMailSenderImpl并调用send方法发送邮件。
//        其中简单邮件可以通过SimpleMailMessage来发送邮件，
//        而复杂的邮件（例如添加附件）可以借助MimeMessageHelper来构建MimeMessage发送邮件。
//
@Slf4j
//@Component
public class JGEmail {
//    @Autowired
    private JavaMailSenderImpl mailSender = new JavaMailSenderImpl();  // 注入邮件工具类

    /**
     * @Description: 进行邮件发送
     * @Param: [mailVo]
     * @return: com.jingang.springinterfacetest.utils.vo.MailVo
     * @Author: 金刚（email：jinganglong123@126.com；WeChat:jinganglong123）
     * @Date: 2020/1/9
     */
    @Async
    public MailVo sendMail(MailVo mailVo) {
        try {
            checkMail(mailVo);  // 检测邮件
            sendMimeMail(mailVo);  // 发送邮件
            return saveMail(mailVo);  // 保存邮件
        } catch (Exception e) {
            mailVo.setStatus("发送失败");
            log.error("发送失败");
            mailVo.setError(e.getMessage());
            log.info(e.toString());
            return mailVo;
        }

    }

    /**
     * @Description:检查邮件信息
     * @Param: [mailVo]
     * @return: void
     * @Author: LiuGang(jinganglong123 @ 126.com)
     * @Date: 2020/1/9
     */
    private void checkMail(MailVo mailVo) {
        if (StringUtils.isEmpty(mailVo.getTo())) {
            throw new RuntimeException("邮件收信人不能为空");
        }
        if (StringUtils.isEmpty(mailVo.getSubject())) {
            throw new RuntimeException("邮件主题不能为空");
        }
        if (StringUtils.isEmpty(mailVo.getText())) {
            throw new RuntimeException("邮件内容不能为空");
        }
    }

    /**
     * @Description: 构建复杂邮件信息并进行发送
     * @Param: [mailVo]
     * @return: void
     * @Author: 金刚（email：jinganglong123@126.com；WeChat:jinganglong123）
     * @Date: 2020/1/9
     */
    private void sendMimeMail(MailVo mailVo) {
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mailSender.createMimeMessage(), true); // true 表示支持复杂类型
            mailVo.setFrom(getMailSendFrom()); // 邮件发信人从配置项中读取
            messageHelper.setFrom(mailVo.getFrom());  // 邮件发信人
            messageHelper.setTo(mailVo.getTo().split(","));  // 邮件收信人
            messageHelper.setSubject(mailVo.getSubject()); // 邮件主题
            messageHelper.setText(mailVo.getText()); // 邮件内容
//            log.info("设置邮件内容完毕");
            if (!StringUtils.isEmpty(mailVo.getCc())) {
                messageHelper.setCc(mailVo.getCc().split(","));  // 添加抄送人
            }
            if (!StringUtils.isEmpty(mailVo.getBcc())) {
                messageHelper.setBcc(mailVo.getBcc().split(","));  // 密送
            }
//            log.info("设置密送完毕");
            if (mailVo.getMultipartFiles() != null) {  // 添加邮件附件
                for (MultipartFile multipartFile : mailVo.getMultipartFiles()) {
                    messageHelper.addAttachment(multipartFile.getOriginalFilename(), multipartFile);
                }

            }
//            log.info("设置附件完毕");
            if (mailVo.getSentDate() == null) {  // 添加发送时间
                mailVo.setSentDate(new Date());
            }
//            log.info("设置发送时间完毕");
//            log.info("邮件的发送时间：" + mailVo.getSentDate().toString());
            messageHelper.setSentDate(mailVo.getSentDate());


            mailSender.send(messageHelper.getMimeMessage());  // 正式发送邮件
            mailVo.setStatus("发送完毕");
            log.info("发送完毕");
        } catch (Exception e) {
            log.info(e.toString());
            throw new RuntimeException(e); // 发送失败

        }
        mailVo.setStatus("发送成功");


    }

    /**
     * @Description: 保存邮件
     * @Param: [mailVo]
     * @return: com.jingang.springinterfacetest.utils.vo.MailVo
     * @Author: 金刚（email：jinganglong123@126.com；WeChat:jinganglong123）
     * @Date: 2020/1/9
     */
    private MailVo saveMail(MailVo mailVo) {
        // 用于后续扩展，将邮件保存在数据库中
        log.info("保存邮件中……");
        return mailVo;
    }

    /**
     * @Description: 从配置文件中获取邮件发信人
     * @Param: []
     * @return: java.lang.String
     * @Author: 金刚（email：jinganglong123@126.com；WeChat:jinganglong123）
     * @Date: 2020/1/9
     */
    public String getMailSendFrom() {
        return mailSender.getJavaMailProperties().getProperty("from");
    }


}
