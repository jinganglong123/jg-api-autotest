package com.jingang.springinterfacetest.config;

import com.jingang.springinterfacetest.common.SendNotification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * @program: jg-api-autotest
 * @description: 自定义的testNg的监听类，实现某些后续操作
 * @author: LiuGang
 * @create: 2019-11-18 17:12
 **/
@Slf4j
public class JGTestNgListener extends TestListenerAdapter {
    @Autowired
    SendNotification sendNotification;

    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
        Object[] parameters = tr.getParameters();
        String message = tr.getName();
        if (parameters.length > 0){
            message = message + "（"+parameters[0].toString() +"）";
        }

        log.info("用例：" + message +   "，执行结果： Failure");
        sendNotification.sendWarningOfWeiXin("用例执行失败：" + message,"自动化测试--告警");


    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        super.onTestSkipped(tr);

        Object[] parameters = tr.getParameters();
        String message = tr.getName();
        if (parameters.length > 0){
            message = message + "（"+parameters[0].toString() +"）";
        }

        log.info("用例：" + message +   "，执行结果： Skipped");

    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);
        Object[] parameters = tr.getParameters();
        String message = tr.getName();
        if (parameters.length > 0){
            message = message + "（"+parameters[0].toString() +"）";
        }

        log.info("用例：" + message +   "，执行结果： Success");
    }

    @Override
    public void onTestStart(ITestResult tr) {
        super.onTestStart(tr);
        Object[] parameters = tr.getParameters();
        String message = tr.getName();
        if (parameters.length > 0){
            message = message + "（"+parameters[0].toString() +"）";
        }

        log.info("用例：" + message +   "，执行进展： Start");
    }

    @Override
    public void onFinish(ITestContext testContext) {
        super.onFinish(testContext);
        log.info(testContext.getName() + "，执行进展： Finish");
//        Object[] parameters = testContext.getFailedTests();
//        String message = testContext.getName();
//        if (parameters.length > 0){
//            message = message + "（"+parameters[0].toString() +"）";
//        }
//
//        log.info("用例：" + message +   "，执行进展： Start");
    }

}
