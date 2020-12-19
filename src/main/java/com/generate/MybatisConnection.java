package com.generate;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @Author: liufeng
 * @Date: 2020/12/9
 * @desc
 */
public class MybatisConnection {

  public static void main(String[] args) throws IOException {
    //第一步：读取配置文件(解析xml中的所有节点)
    InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
    //第二步：构造SqlSessionFactoryBuilder
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    //第三步：解析配置文件生成Configuration和SqlSessionFactory
    SqlSessionFactory factory = builder.build(stream);
    //第四步：获取SqlSession
    SqlSession sqlSession = factory.openSession();

  }
}
