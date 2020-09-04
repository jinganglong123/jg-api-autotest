package com.jingang.springinterfacetest.cases.demoCaseModule;

import com.jingang.springinterfacetest.utils.JGJsonSchemaByFge;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

/**
 * @program: jg-api-autotest
 * @description: json schema Demo演示
 * @author: LiuGang
 * @create: 2019-11-07 08:01
 **/
@Slf4j
public class JsonSchemaDemo {

    @Test(description ="对字符串形式的json进行处理")
    void test01(){

        String json = "{" +
                "  \"checked\": false," +
                "  \"dimensions\": {" +
                "    \"width\": 5," +
                "    \"height\": 10" +
                "  }," +
                "  \"id\": 1," +
                "  \"name\": \"A green door\"," +
                "  \"price\": 12.5," +
                "  \"tags\": [" +
                "    \"home\"," +
                "    \"green\"" +
                "  ]" +
                "}";

        String schemaJson = " {" +
                "  \"definitions\": {}, " +
                "  \"$schema\": \"http://json-schema.org/draft-07/schema#\", " +
                "  \"$id\": \"http://example.com/root.json\", " +
                "  \"type\": \"object\", " +
                "  \"title\": \"The Root Schema\", " +
                "  \"required\": [" +
                "    \"checked\", " +
                "    \"dimensions\", " +
                "    \"id\", " +
                "    \"name\", " +
                "    \"price\", " +
                "    \"tags\"" +
                "  ], " +
                "  \"properties\": {" +
                "    \"checked\": {" +
                "      \"$id\": \"#/properties/checked\", " +
                "      \"type\": \"boolean\", " +
                "      \"title\": \"The Checked Schema\", " +
                "      \"default\": false, " +
                "      \"examples\": [" +
                "        false" +
                "      ]" +
                "    }, " +
                "    \"dimensions\": {" +
                "      \"$id\": \"#/properties/dimensions\", " +
                "      \"type\": \"object\", " +
                "      \"title\": \"The Dimensions Schema\", " +
                "      \"required\": [" +
                "        \"width\", " +
                "        \"height\"" +
                "      ], " +
                "      \"properties\": {" +
                "        \"width\": {" +
                "           \"$id\": \"#/properties/dimensions/properties/width\", " +
                "           \"type\": \"integer\", " +
                "           \"title\": \"The Width Schema\", " +
                "           \"default\": 0, " +
                "           \"examples\": [" +
                "             5" +
                "           ]" +
                "         }, " +
                "         \"height\": {" +
                "           \"$id\": \"#/properties/dimensions/properties/height\", " +
                "           \"type\": \"integer\", " +
                "           \"title\": \"The Height Schema\", " +
                "           \"default\": 0, " +
                "           \"examples\": [" +
                "             10" +
                "           ]" +
                "         }" +
                "       }" +
                "     }, " +
                "     \"id\": {" +
                "       \"$id\": \"#/properties/id\", " +
                "    \"type\": \"integer\", " +
                "    \"title\": \"The Id Schema\", " +
                "    \"default\": 0, " +
                "    \"examples\": [" +
                "      1" +
                "    ]" +
                "  }, " +
                "  \"name\": {" +
                "    \"$id\": \"#/properties/name\", " +
                "    \"type\": \"string\", " +
                "    \"title\": \"The Name Schema\", " +
                "    \"default\": \"\", " +
                "    \"examples\": [" +
                "      \"A green door\"" +
                "    ], " +
                "    \"pattern\": \"^(.*)$\"" +
                "  }, " +
                "  \"price\": {" +
                "    \"$id\": \"#/properties/price\", " +
                "    \"type\": \"number\", " +
                "    \"title\": \"The Price Schema\", " +
                "    \"default\": 0.0, " +
                "    \"examples\": [" +
                "      12.5" +
                "    ]" +
                "  }, " +
                "  \"tags\": {" +
                "    \"$id\": \"#/properties/tags\", " +
                "    \"type\": \"array\", " +
                "    \"title\": \"The Tags Schema\", " +
                "    \"items\": {" +
                "      \"$id\": \"#/properties/tags/items\", " +
                "      \"type\": \"string\", " +
                "        \"title\": \"The Items Schema\", " +
                "        \"default\": \"\", " +
                "        \"examples\": [" +
                "          \"home\", " +
                "          \"green\"" +
                "        ], " +
                "        \"pattern\": \"^(.*)$\"" +
                "      }" +
                "    }" +
                "  }" +
                "}";

        log.info(Boolean.toString(JGJsonSchemaByFge.AssertJsonSchemaByJsonString(json,schemaJson)) );


        }

    @Test
    void test02(){
        log.info(Boolean.toString(JGJsonSchemaByFge.AssertJsonSchemaByJsonFile("src/main/resources/jsonSchema/demoApiJson.json","src/main/resources/jsonSchema/demoApiJsonSchema.json")));
    }

    @Test
    void test03(){
        String json = "{" +
                "  \"checked\": false," +
                "  \"dimensions\": {" +
                "    \"width\": null," +
                "    \"height\": 10" +
                "  }," +
                "  \"id\": 1," +
                "  \"name\": \"A green door\"," +
                "  \"price\": 12.5," +
                "  \"tags\": [" +
                "    \"home\"," +
                "    \"green\"" +
                "  ]" +
                "}";
        log.info(Boolean.toString(JGJsonSchemaByFge.AssertJsonSchemaByJsonStringAndJsonFile(json,"src/main/resources/jsonSchema/demoApiJsonSchema.json")));
    }


}
