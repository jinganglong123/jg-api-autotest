package com.jingang.springinterfacetest.utils;

//import com.esotericsoftware.yamlbeans.YamlException;
//import com.esotericsoftware.yamlbeans.YamlReader;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.ParameterizedType;

/**
 * @program: jg-api-autotest
 * @description: yaml解析处理相关工具方法
 * @author: LiuGang
 * @create: 2019-12-25 16:28
 **/

public class JGYamlUntil {
    /**
    * @Description: 从字符串中获取yaml，解析为yaml Java对象
    * @Param: [yamlString]
    * @return: java.lang.Iterable<java.lang.Object>
    * @Author: LiuGang
    * @Date: 2019/12/25
    */
    public static Iterable<Object> yamlObjectByString(String yamlString) {
        Yaml yaml = new Yaml();
        Iterable<Object> ret= yaml.loadAll(yamlString);
        return ret;
    }

    /**
    * @Description: 根据yaml路径[filePath],解析到对应的java类型.[class]
    * @Param: [filePath, clazz]
    * @return: T
    * @Author: LiuGang
    * @Date: 2020/6/3
    */
    public static <T> T getConfigFromYaml(String filePath,Class<T> clazz){
        try {
//            YamlReader reader = new YamlReader(new FileReader(filePath));
//            T t = (T) reader.read(clazz);
            Yaml yaml = new Yaml();
            T t = yaml.loadAs(new FileReader(filePath),clazz);
            return t;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
