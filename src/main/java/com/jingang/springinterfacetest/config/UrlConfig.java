package com.jingang.springinterfacetest.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: uc-interface-test
 * @description: 路径类配置实体类
 * @author: LiuGang
 * @create: 2019-11-01 19:15
 **/
@Component
@ConfigurationProperties(prefix = "url")
@Data
public class UrlConfig {

    // 演示用的demo
    public String demoUrl;
    public String demoUrl2;
    public String demoApi;
    public String demoApi2;

    // 正式项目
    // apibank门户地址
    public String apibankUrl;
    // 控制台后端地址
    public String openUrl;
    // 超级账户的passport地址
    public String passport;
    // 控制台登录接口的uri
    public String login;
    // 获取我的应用列表
    public String appList;
    // 控制台-获取全部产品接口
    public String allproductList;

    // 门户
    // 获取产品的详情
    public String productDetail;
    // 获取产品是否需要支付信息
    public String productValidneedpay;
    // 获取产品的列表
    public String featuredList;

}
