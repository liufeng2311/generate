package com.generate;

import com.generate.demo.mapper.ThirdWorkSchemaMapper;
import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @Author: liufeng
 * @Date: 2020/7/8
 * @desc
 */
public class MybatisConnection {

  public static void main(String[] args) throws IOException {
    //第一步：读取配置文件
    InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
    //第二步：构造SqlSessionFactoryBuilder
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    //第三步：解析配置文件生成SqlSessionFactory
    SqlSessionFactory factory = builder.build(stream);
    //第四步：获取SqlSession
    SqlSession sqlSession = factory.openSession(true);
    //第五步：获取需要操作的Mapper的实例
    ThirdWorkSchemaMapper mapper = sqlSession.getMapper(ThirdWorkSchemaMapper.class);
    //第六步：查询并返回结果
    mapper.findById("1");
  }

}
