package com.jingang.testng;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoTests {
    @BeforeClass
    public  void beforTest(){
        System.out.println("DemoTests 测试用例集开始执行~");

    }

    @Test
    public void test01(){
        System.out.println("test01  exec……");
    }

    @Test
    public void test02(){
        System.out.println("test02 exec……");
    }

    @DataProvider
    public Object[][] dataProvider(){
        return new Object[][]{{"101"},{"201"}};
    }

    @Test(dataProvider = "dataProvider")
    public void test03(String str){
        System.out.println("test03 exec……  str:" + str);
    }

//    @Test(groups = "loginTrue",description = "用户登录接口测试Demo")
//    public void loginTrue() throws IOException{
//        HttpClient httpClient = new DecompressingHttpClient();
//        HttpResponse response;
//        HttpEntity entiy;
//        HttpGet get = new HttpGet("http://10.10.201.137/login");
//        get.setHeader("content-type","application/json");
//        String result;
//
//        response = httpClient.execute(get);
//        entiy = response.getEntity();
//        result = EntityUtils.toString(entiy,"UTF-8");
//        System.out.println("查看登录接口请求返回的结果：" + result);
//
//
//
//    }



}
