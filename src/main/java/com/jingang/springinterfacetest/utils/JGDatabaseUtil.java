package com.jingang.springinterfacetest.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
/**
* @program: JGDatabaseUtil
* @description: 数据库相关的工具类
* @author: LiuGang
* @create: 2020/5/13-20:50
**/
public class JGDatabaseUtil {

    public static SqlSession getSqlsession() throws IOException{
        // 获取配置资源文件
        Reader reader = Resources.getResourceAsReader("databaseConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

        // sqlSession 就是能够执行配置文件中的sql语句
        SqlSession sqlSession = factory.openSession();
        return sqlSession;
    }

}
