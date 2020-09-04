package com.jingang.springinterfacetest.config;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: TestConfig
 * @description: 笨方式，用于ResourceBundle读取属性配置，设置静态的配置实体类
 * @author: LiuGang
 * @create: 2019/2/25
 **/
@Component
@ConfigurationProperties(prefix = "config")
@Data
public class TestConfig {

    //  -- 样例参考
//    public static String uriCreate = "/application/create";  // 创建应用接口
//    public static String uriQueryByPage = "/application/queryByPage"; //  查询应用列表接口
//    public static Integer lobIdDefault = 21;  // 21-测试专用

    // 全局
    // 控制是否发送企业微信通知的开关
    public String notificationSwitch;
    // 环境标签
    public String env;


}