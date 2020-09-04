package com.jingang.springinterfacetest.model;

import com.jingang.springinterfacetest.config.YamlPropertyLoaderFactory;
import groovy.beans.Bindable;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: jg-api-autotest
 * @description: 基于yaml初始化bean对象的示例
 * @author: LiuGang
 * @create: 2020-09-01 00:01
 **/

/**
* 数据结构：
 * reqMethod: String
 * protocolType: String
 * resCodeNamespace: String
 * uriNamespace: String
 * uriPath: String
 * apiName: String
 * protectFlag: Integer
 * apiDesc: String
 * transpondFlag: String
 * projectCode: String
 * categoryCode: String
 * resParamType: String
 * resJsonRoot: String
 * serviceLocation: String
 * samples: Array
 *     req: SamplesBean
 *     res: SamplesBeans
 *     msg: SamplesBeans
 * params:<ParamsBean>
 *     reqHeader: Array[ParamBean]
 *     resHeader: Array[ParamBean]
 *     reqArgs: Array[ParamBean]
 *     resArgs: Array[ParamBean]
 *     reqPath: Array[?]
 *     resQuery: Array[?]
 *
 *
*
* */
@Data
@Component
//通过@PropertySource注解指定要读取的yaml配置文件，默认读取src\main\resources\application.yml配置
@PropertySource(value = {"classpath:config/apiManage/apiConfig.yaml","classpath:config/apiManage/createMockApi.yaml"}, factory = YamlPropertyLoaderFactory.class)
@ConfigurationProperties()
public class ApiInfoModelDemo {

    /**
     * reqMethod : POST
     * protocolType : HTTP
     * resCodeNamespace : test_code
     * uriNamespace : test_url
     * uriPath : 12343456
     * apiName : test1
     * protectFlag : 0
     * apiDesc :
     * transpondFlag : 0
     * projectCode : 733f7c5b1ee0446f937675954315a225
     * categoryCode : api
     * samples : [{"sampleType":"message","subType":"req","sampleInfo":"{\"req1\":{\"req11\":\"\"}}"},{"sampleType":"message","subType":"res","sampleInfo":"{\"res1\":{\"res11\":\"\"}}"},{"sampleType":"message","subType":"err","sampleInfo":"{\n      \"jdd-response-ts\":\"20200407200731686\",\n      \"jdd-response-code\":\"40000100\",\n      \"jdd-response-message\":\"报文验签失败\"\n  }"}]
     * params : {"reqHeader":[{"paramCode":"9ec662c5aac27c4f3b18e94833475c6b","parentCode":"0","parentLocation":"request.header","paramSeq":0,"paramName":"jdd-request-ts","paramCnName":"时间戳","paramType":"timestamp","paramDesc":"时间戳","paramPublic":1,"paramRequired":1,"regularExpression":""},{"paramCode":"ded22f05e93ae24bae2888e8092a7b73","parentCode":"0","parentLocation":"request.header","paramSeq":1,"paramName":"jdd-app-id","paramCnName":"应用ID","paramType":"string","paramDesc":"应用ID","paramPublic":1,"paramRequired":1,"regularExpression":""},{"paramCode":"25ea0feb300bca46d579271da490c833","parentCode":"0","parentLocation":"request.header","paramSeq":2,"paramName":"jdd-sign-type","paramCnName":"签名方式","paramType":"enum","paramDesc":"签名方式","paramPublic":1,"paramRequired":1,"regularExpression":""},{"paramCode":"29de347d917c3c4530688b84f4915bf9","parentCode":"0","parentLocation":"request.header","paramSeq":3,"paramName":"jdd-sign","paramCnName":"签名","paramType":"string","paramDesc":"签名","paramPublic":1,"paramRequired":1,"regularExpression":""},{"paramCode":"212dce3253838c426bca2d3290844666","parentCode":"0","parentLocation":"request.header","paramSeq":4,"paramName":"jdd-encrypt-type","paramCnName":"加密方式","paramType":"enum","paramDesc":"加密方式","paramPublic":1,"paramRequired":1,"regularExpression":""},{"paramCode":"c7777be66cbe5a40fbcbb1ed9f6c4a8a","parentCode":"0","parentLocation":"request.header","paramSeq":5,"paramName":"jdd-env-key","paramCnName":"秘钥","paramType":"string","paramDesc":"秘钥","paramPublic":1,"paramRequired":0,"regularExpression":""},{"paramCode":"93bcba3c7bc78e4201b92b83ab6498aa","parentCode":"0","parentLocation":"request.header","paramSeq":6,"paramName":"jdd-api-version","paramCnName":"API版本号","paramType":"string","paramDesc":"API版本号","paramPublic":1,"paramRequired":0,"regularExpression":""}],"reqPath":[],"reqQuery":[],"resHeader":[{"paramCode":"7fdd48bdbbd76649192abf7381c7dc78","parentCode":"0","parentLocation":"response.header","paramSeq":0,"paramName":"jdd-response-code","paramCnName":"返回码","paramType":"string","paramDesc":"返回码","paramPublic":1,"paramRequired":1,"regularExpression":""},{"paramCode":"817a9c0204f2e64fc249fdce1d53e1b3","parentCode":"0","parentLocation":"response.header","paramSeq":1,"paramName":"jdd-response-message","paramCnName":"返回码描述","paramType":"string","paramDesc":"返回码描述","paramPublic":1,"paramRequired":0,"regularExpression":""},{"paramCode":"6936d6b69f601842c1a900fc5a2a71ba","parentCode":"0","parentLocation":"response.header","paramSeq":2,"paramName":"jdd-response-ts","paramCnName":"时间戳","paramType":"timestamp","paramDesc":"时间戳","paramPublic":1,"paramRequired":1,"regularExpression":""},{"paramCode":"2fc6df5ca64e59497d78c2a62c787a0b","parentCode":"0","parentLocation":"response.header","paramSeq":3,"paramName":"jdd-encrypt-type","paramCnName":"加密方式","paramType":"enum","paramDesc":"加密方式","paramPublic":1,"paramRequired":1,"regularExpression":""},{"paramCode":"0f9917f695d6f24667192fd197109906","parentCode":"0","parentLocation":"response.header","paramSeq":4,"paramName":"jdd-env-key","paramCnName":"密钥","paramType":"string","paramDesc":"密钥","paramPublic":1,"paramRequired":0,"regularExpression":""},{"paramCode":"81c5ac41bb98ce44cd897a25b4b210c9","parentCode":"0","parentLocation":"response.header","paramSeq":5,"paramName":"jdd-sign-type","paramCnName":"签名方式","paramType":"enum","paramDesc":"签名方式","paramPublic":1,"paramRequired":1,"regularExpression":""},{"paramCode":"74951c8ea37c4c4acb38ce00e909328d","parentCode":"0","parentLocation":"response.header","paramSeq":6,"paramName":"jdd-sign","paramCnName":"签名","paramType":"string","paramDesc":"签名","paramPublic":1,"paramRequired":1,"regularExpression":""},{"paramCode":"3c7169a81a8cc14cd4b8498fc66e4765","parentCode":"0","parentLocation":"response.header","paramSeq":7,"paramName":"jdd-trace-id","paramCnName":"检索日志ID","paramType":"string","paramDesc":"检索日志ID","paramPublic":1,"paramRequired":1,"regularExpression":""}],"resArgs":[{"paramCode":"387defbb5f574943c9882ed688df1b4b","parentCode":"0","parentLocation":"response.body","paramSeq":0,"paramName":"res1","paramType":"object","paramDesc":"","paramPublic":0,"paramRequired":1,"maxLength":0,"className":"","paramMultiple":1,"defaultValue":"","mockValue":"","regularExpression":"","fields":[{"paramCode":"3b877ba63368794581599a28a5fa4c81","parentCode":"387defbb5f574943c9882ed688df1b4b","parentLocation":"response.body.res1","paramSeq":0,"paramName":"res11","paramType":"string","paramDesc":"","paramPublic":0,"paramRequired":1,"maxLength":0,"className":"","paramMultiple":1,"defaultValue":"","mockValue":"","regularExpression":"","fields":[]}]}],"reqArgs":[{"paramCode":"e8af8af022f052446a492b3002cffe66","parentCode":"0","parentLocation":"request.body","paramSeq":0,"paramName":"req1","paramType":"object","paramDesc":"","paramPublic":0,"paramRequired":1,"maxLength":0,"className":"","paramMultiple":1,"defaultValue":"","mockValue":"","regularExpression":"","fields":[{"paramCode":"019330d8aeed8c4a0528a42daa776e64","parentCode":"e8af8af022f052446a492b3002cffe66","parentLocation":"request.body.req1","paramSeq":0,"paramName":"req11","paramType":"string","paramDesc":"","paramPublic":0,"paramRequired":1,"maxLength":0,"className":"","paramMultiple":1,"defaultValue":"","mockValue":"","regularExpression":"","fields":[]}]}]}
     * resParamType : json
     * resJsonRoot : Object
     * serviceLocation : {"uri":"test_url/12343456","timeout":60000,"method":"POST","protocolType":"HTTP","resParamType":"json","resJsonRoot":"Object","reqParamType":"json","reqJsonRoot":"Object","contentType":"application/json"}
     */

    private String reqMethod;
    private String protocolType;
    private String resCodeNamespace;
    private String uriNamespace;
    private String uriPath;
    private String apiName;
    private int protectFlag;
    private String apiDesc;
    private int transpondFlag;
    private String projectCode;
    private String categoryCode;
    private ParamsBean params;
    private String resParamType;
    private String resJsonRoot;
    private String serviceLocation;
    private List<SamplesBean> samples;


    @Data
    public static class ParamsBean   {
        private List<ParamBean> reqHeader;
        private List<?> reqPath = null;
        private List<?> reqQuery = null;
        private List<ParamBean> resHeader;
        private List<ParamBean> resArgs;
        private List<ParamBean> reqArgs;

        @Data
        public static class ParamBean{
            private int id;
            private String paramCode;
            private String parentCode;
            private String parentLocation;
            private int paramSeq;
            private String paramName;
            private String paramType;
            private String paramDesc;
            private int paramPublic;
            private int paramRequired;
            private int maxLength;
            private String className;
            private int paramMultiple;
            private String defaultValue;
            private String mockValue;
            private String regularExpression;
            private List<ParamBean> fields;
            private String paramCnName;
            private String categoryCode;
            private String reqResFlag;
            private String paramAlias;
            private String paramLocation;
            private boolean paramStatus;
            private String remark;
        }
    }
    @Data
    public static class SamplesBean   {
        /**
         * sampleType : message
         * subType : req
         * sampleInfo : {"req1":{"req11":""}}
         */
        private String sampleType;
        private String subType;
        private String sampleInfo;
    }
}

