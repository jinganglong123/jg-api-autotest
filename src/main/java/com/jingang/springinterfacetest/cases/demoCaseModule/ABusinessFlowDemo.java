package com.jingang.springinterfacetest.cases.demoCaseModule;

import com.jingang.springinterfacetest.cases.TestNGSpringBootCaseConfig;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: jg-api-autotest
 * @description: com.jingang.springinterfacetest.cases.apiBankPortal.productAndService模块下的业务流用例
 * @author: liugang
 * @create: 2020-08-12 17:39
 **/
@Slf4j
@Data
public class ABusinessFlowDemo extends TestNGSpringBootCaseConfig {
    /** 业务流用例的指导原则：
     *  1）测试单独某个接口的场景，前置依赖较多的相关接口，可将多个接口串成业务流用例
     *  2）接口所测业务场景的业务流属性较强，适合多个接口串在一起测试
     *  3）原则上业务流用例不要跨模块，需要依赖其他模块接口的，通过维护前置条件方法来准备
     *  4）其他情况不太适合一个一个接口独立测试的case，可维护成业务流用例
     *
     **/
    /**
     * 步骤1：统一维护自动装配用到的接口对象
     **/

//    eg: 业务用例需要使用ApiList接口
//    @Autowired
//    public ApiList apiList;
//    @Autowired
//    public FeaturedListDemo featuredList;
//    @Autowired
//    public ProductDetail productDetail;
//    @Autowired
//    public ProductValidneedpay productValidneedpay;

    /**
     * 步骤2：维护本类下所有业务流用例执行前需要准备的前置条件
     **/
//    @BeforeClass
//    public void beforeClass() {
//        log.info("提示：在该类（com.jingang.springinterfacetest.cases.demoCaseModule.ABusinessFlowDemo）下所有用例执行前前执行");
//        // 前置条件准备
//
//    }

    /**
     * 步骤3：准备某业务流用例需要的测试数据
     **/
//    @DataProvider
//    public Object[][] dataT1() {
//        int row = 1;
//        int col = 3;
//        Object[][] objects = new Object[row][col];
//        // 数据处理如下
//        objects[0][0] = "正例：检查所有推荐到门户的产品是否正常";
//        objects[0][1] = "";
//        objects[0][2] = "PRODUCT";
//        //    for (int i = 0;i < row;i++){
//        //
//        //    }
//        return objects;
//    }

    /**
     * 步骤4：维护业务流用例case模块
     **/
//    @Test(dataProvider = "dataT1", priority = 1, groups = {"default"})
//    public void testT1(String title, String cookie, String type) {
//        // 打印用例标题
//        log.info(title);
//        // 业务流处理
//        // 1. 查询产品列表
//        Assert.assertTrue(featuredList.caseTrue(cookie, type));
//        JSONArray jsonArray = JSONObject.parseObject(featuredList.httpresult.getResponseBody()).getJSONObject("resultData").getJSONArray("list");
//        Integer id = 0;
//        Integer resourceId = 0;
//        String skuId = "";
//        String productCode = "";
//        int i = 0;
//        for (i = 0; i < jsonArray.size(); i++) {
//            id = jsonArray.getJSONObject(i).getInteger("id");
//            resourceId = jsonArray.getJSONObject(i).getInteger("resourceId");
//            Assert.assertTrue(productDetail.caseTrue(cookie, resourceId, id));
//            skuId = JSONArray.parseObject(productDetail.httpresult.getResponseBody()).getJSONObject("resultData").getString("skuId");
//            productCode = JSONArray.parseObject(productDetail.httpresult.getResponseBody()).getJSONObject("resultData").getString("productCode");
//            Assert.assertTrue(productValidneedpay.caseTrue(cookie, productCode, skuId));
//
//            // 检查是否需要付费返回的是否正确
//            Boolean isNeedPay = JSONArray.parseObject(productValidneedpay.httpresult.getResponseBody()).getJSONObject("resultData").getBoolean("isNeedPay");
//            log.info("产品Id：" + skuId + "  是否允许支付：" + isNeedPay.toString());
//
//
//        }
//        log.info("## 总共检查的产品个数：" + i);
//        if(i != 15){
//            Assert.assertTrue(false,"产品数量不是15个，请检查");
//        }
//
//
//    }

    /**
     * 步骤5：维护本类下所有业务流用例执行后需要进行的后置处理
     **/
//    @AfterClass
//    public void afterClass() {
//        log.info("提示：在该类（com.jingang.springinterfacetest.cases.demoCaseModule.ABusinessFlowDemo）下所有用例执行完毕后执行");
//        // 后置处理
//
//    }

}

