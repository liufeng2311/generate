# generate
代码生成器
   
一、目录结构

    │
    ├─java                                       java目录
    │  ├─demo                                   默认生成java的位置
    │  ├─generate                               生成器代码所在包
    │  │    ├─domain                            定义表和字段信息
    │  │    ├─factory                           定义数据库连接和freemarker配置
    │  │    ├─utils                             定义加载模板和配置的工具类
    │ 
    ├─GenerateApplication                       通过Spring测试生成文件
    ├─GenerateFile                              生成文件启动类(核心)
    ├─MybatisConnection                         通过Mybatis测试生成文件
    │  
    ├─resources                                 resources目录
    │  ├─mapper                                 默认生成xml的位置
    │  ├─templates                              模板位置
    │  │    ├─properties                        定义了生成类包名和实体类与数据库字段转换
    │  │    ├─template                          模板
    │  ├─application.yml                        项目配置文件
    │  ├─mybatis-config.xml                     mybatis配置文件
    
二、使用说明(生成代码步骤)
* 1.项目启动类com.generate.GenerateFile
  2.指定数据库连接、指定数据库schema、指定需要生成的表名(支持模糊匹配)
  3.默认生成的java代码位于src/main/java/com.generate.demo目录下
  3.默认生成的xml代码位于src/main/resources/mapper目录下