package cn.study.dao;

import cn.study.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements IUserDao {
    //    对PO的操作，必须在SqlSession的管理下，才能够同步到数据库。即SqlSession对象是mybatis执行数据持久化的关键对象
    private SqlSession session;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public void save(){
        //在DatabaseSession类中通过getSqlSession方法来获取数据库session，需要UserRepository类继承DatabaseSession类
        try{
            this.session = sqlSessionFactory.openSession();
            User user = new User("hello","123");
            user.setLoginname("hello");
            this.session.insert("cn.study.mapper.UserMapper.save",user);
            this.session.commit();
        }catch(Exception e){
            e.printStackTrace();
            this.session.rollback();
        }finally {
            this.session.close();
        }
    }

    public void findByUsername(){
        try{
            this.session = sqlSessionFactory.openSession();
            User user = session.selectOne("cn.study.mapper.UserMapper.select_username","hello");
            System.out.println(user);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
    }

}


