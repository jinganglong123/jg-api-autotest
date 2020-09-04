package com.jingang.springinterfacetest.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jackson.JsonNodeReader;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @program: jg-api-autotest
 * @description: 通过fge实现JSON Schema
 * @author: LiuGang
 * @create: 2019-11-07 17:41
 **/
@Slf4j
public class JGJsonSchemaByFge {

    /**
    * @Description: 以JsonNode的形式对json进行校验
    * @Param: [jsonSchemaNode, jsonNode]
    * @return: boolean
    * @Author: LiuGang
    * @Date: 2019/11/7
    */ 
    public static boolean AssertJsonSchemaByJsonNode(JsonNode jsonNode,JsonNode jsonSchemaNode){

        
        log.info("校验规则 JsonSchema 串："+ jsonSchemaNode.toString());
        log.info("被校验的目标 Json 串：" +  jsonNode.toString());

        try {
            ProcessingReport report = null;
            report = JsonSchemaFactory.byDefault().getValidator().validate(jsonSchemaNode,jsonNode);
            if (report.isSuccess()){
                log.info("schema校验结果：校验成功");
                return true;

            }else{
                log.info("schema校验结果：校验失败");
                return false;
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
    * @Description: 以字符串的形式对json进行校验
    * @Param: [jsonSchema, json]
    * @return: boolean
    * @Author: LiuGang
    * @Date: 2019/11/7
    */
    public static boolean AssertJsonSchemaByJsonString(String json,String jsonSchema){
        JsonNode jsonNode = null;
        JsonNode schemaNode = null;
        

        try {
            jsonNode = JsonLoader.fromString(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            schemaNode = JsonLoader.fromString(jsonSchema);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return AssertJsonSchemaByJsonNode(jsonNode,schemaNode);
    }
    
    /**
    * @Description: 从文件中获取json数据的形式对json进行校验
    * @Param: [jsonSchemaFilePath, jsonFilePath]
    * @return: boolean
    * @Author: LiuGang
    * @Date: 2019/11/7
    */ 
    public static boolean AssertJsonSchemaByJsonFile(String jsonFilePath,String jsonSchemaFilePath){
        JsonNode jsonNode = null;
        JsonNode schemaNode = null;
        
        try {
            jsonNode = new JsonNodeReader().fromReader(new FileReader(jsonFilePath));
            schemaNode = new JsonNodeReader().fromReader(new FileReader(jsonSchemaFilePath));

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return AssertJsonSchemaByJsonNode( jsonNode,schemaNode);
        

    }
    /**
    * @Description: json来自字符串，jsonSchema来自文件
    * @Param: [json, jsonSchemaFilePath]
    * @return: boolean
    * @Author: LiuGang
    * @Date: 2019/11/7
    */ 
    public static boolean AssertJsonSchemaByJsonStringAndJsonFile(String json,String jsonSchemaFilePath){
        JsonNode jsonNode = null;
        JsonNode schemaNode = null;

        try {
            jsonNode =  JsonLoader.fromString(json);
            schemaNode = new JsonNodeReader().fromReader(new FileReader(jsonSchemaFilePath));

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return AssertJsonSchemaByJsonNode( jsonNode,schemaNode);


    }



}
