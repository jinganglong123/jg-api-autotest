package com.jingang.springinterfacetest.cases.demoCaseModule;

import com.alibaba.fastjson.JSONObject;
import com.jingang.springinterfacetest.cases.TestNGSpringBootCaseConfig;
import com.jingang.springinterfacetest.utils.*;
import com.jingang.springinterfacetest.utils.vo.ExcelDataVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @program: jg-api-autotest
 * @description: 从excel读取静态数据的用例demo
 * @author: LiuGang
 * @create: 2020-05-18 20:51
 **/
@Slf4j
@Component
public class StaticExcelDataCase extends TestNGSpringBootCaseConfig {


    public JGHttpResult httpresult;

    public boolean caseTrue(String apiUrl, String caseType, String caseData, String results) {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json;charset=UTF-8");
        headers.put("Cookie","JSESSIONID=308C034E4D7040B552E2685AE1DC64FF; BIGipServerpool_passport=283968010.50215.0000; RAIL_EXPIRATION=1590165583791; RAIL_DEVICEID=EkjdRntmBHJzX13NxAAweuHzjjMvtGkXN5UjWPtOq6xPiWxyAWInwLjafo1DH8xKPNpQmaEUR-S8XNXQlU5iu1fSSt4yYNGmeA1BTwaX4azRVS6SoO9iJA5QTAB7FMAn7NnD90zu66UnidRgnKpU3Xr7dUJYYKfG; route=495c805987d0f5c8c84b14f60212447d; _jc_save_fromStation=%u5317%u4EAC%2CBJP; _jc_save_toStation=%u6DC4%u535A%2CZBK; _jc_save_wfdc_flag=dc; BIGipServerpassport=954728714.50215.0000; _jc_save_fromDate=2020-05-22; _jc_save_toDate=2020-05-22; BIGipServerotn=49283594.24610.0000");
//        String param = String.format("", );
        httpresult = JGHttp.doGet(apiUrl + "?" + caseData, null,headers);
        if (httpresult.getResponseCode() != 200) {
            return false;
        }
        //        if (JSONObject.parseObject(httpresult.getResponseBody()).getInteger("code") != 0){
        //            return false;
        //        }
        if (JSONObject.parseObject(httpresult.getResponseBody()).getBoolean("status") != true) {
            return false;
        }
        if (caseType.equals("A")) {
            if (!JGString.matchString(results, httpresult.getResponseBody())) {
                return false;
            }
        }

        return true;
    }


    // 测试一下通过JGExcel的方法功能
    @Test()
    public void testT() {
        //读取Excel中的数据
        List<ExcelDataVO> excelDataVOS = JGExcel.readExcel("src/main/resources/excelFiles/staticCaseDemo.xlsx");
        ExcelDataVO excelDataVO = excelDataVOS.get(0);
        log.info(excelDataVO.getApiName());
        // 依据接口名获取该接口的URL
        log.info("对应的URL：" + JGJavaObjectUtil.getFieldValueByName(excelDataVO.getApiName(), urlConfig).toString());
        log.info(excelDataVO.getCaseTitle());
        log.info(excelDataVO.getCaseType());
        log.info(excelDataVO.getCaseData());
        log.info(excelDataVO.getResults());
        log.info("excel的数据行数：" + String.valueOf(excelDataVOS.size()));
        //断言
        log.info("################");
        log.info(JGExcel.readExcelCell("src/main/resources/excelFiles/staticCaseDemo.xlsx",0,0,0));


    }

    @DataProvider
    public Object[][] dataT1() {
        int row = 1;
        int col = 5;

        List<ExcelDataVO> excelDataVOS = JGExcel.readExcel("src/main/resources/excelFiles/staticCaseDemo.xlsx");
        row = excelDataVOS.size();
        Object[][] objects = new Object[row][col];
        for (int i = 0; i < excelDataVOS.size(); i++) {
            ExcelDataVO excelDataVO = excelDataVOS.get(i);
            objects[i][0] = excelDataVO.getCaseTitle();
            objects[i][1] = urlConfig.demoUrl2 + JGJavaObjectUtil.getFieldValueByName(excelDataVO.getApiName(), urlConfig).toString(); // 接口路径
            objects[i][2] = excelDataVO.getCaseType(); // 用例类型
            objects[i][3] = excelDataVO.getCaseData(); // 测试数据
            objects[i][4] = excelDataVO.getResults(); // 预期结果
        }


        return objects;
    }

    @Test(dataProvider = "dataT1", priority = 1, groups = {"default"})
    public void testT1(String title, String apiUrl, String caseType, String caseData, String results) {
        // 打印用例标题
        log.info("标题：" + title);
        //中间处理
        log.info("接口路径：" + apiUrl);
        log.info("用例类型：" + caseType);
        log.info("测试数据：" + caseData);
        log.info("测试结果：" + results);

        //断言
//        Assert.assertTrue(caseTrue(, token));
        Assert.assertTrue(caseTrue(apiUrl, caseType, caseData, results));

    }


}
