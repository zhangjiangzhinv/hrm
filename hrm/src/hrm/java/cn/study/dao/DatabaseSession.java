package cn.study.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * 获取MyBatis操作数据库的session
 */
public class DatabaseSession {
    /**
     * SqlSessionFactory是数据库编译后的内存映像，通过读取mybatis-config.xml配置文件获得，这是传统的方式
     * @return
     * @throws Exception
     */
    public SqlSession getSqlSession() throws Exception{
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sessionFactory.openSession();
        return session;
    }
}
