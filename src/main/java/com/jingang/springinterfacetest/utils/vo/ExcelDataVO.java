package com.jingang.springinterfacetest.utils.vo;

import lombok.Data;

/**
 * @program: jg-api-autotest
 * @description: 读取或写入Excel每一行的数据对象
 * @author: LiuGang
 * @create: 2020-05-13 22:34
 **/
@Data
public class ExcelDataVO {
    /**
     * 接口别名
     */
    private String apiName;

    /**
     * 用例标题
     */
    private String caseTitle;

    /**
     * 用例类型
     */
    private String caseType;

    /**
     * 测试数据
     */
    private String caseData;
    /**
     * 预期结果
     */
    private String results;


}
