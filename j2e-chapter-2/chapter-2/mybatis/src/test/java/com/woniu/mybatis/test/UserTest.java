package com.woniu.mybatis.test;

import com.woniu.mybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 离歌笑
 * @desc
 * @date 2020-06-14
 */
public class UserTest {

    private SqlSession sqlSession;

    @Before
    public void before() throws IOException {
        //1.加载配置文件
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        //2.得到SqlSesssionFactory对象
        SqlSessionFactory sqlSessionFactory = builder.build(is);
        is.close();
        is=null;
        sqlSession = sqlSessionFactory.openSession();
    }

    @After
    public void after(){
        if(sqlSession!=null){
            sqlSession.close();
        }
    }

    @Test
    public void saveUserInfo(){
        User user=new User();
        user.setCnname("张三2");
        user.setEmail("fasdfasf");
        user.setMobile("110");
        user.setNote("fadsfad");
        user.setSex('0');
        user.setUser_name("fasdfa");

        sqlSession.insert("test.saveUserInfo", user);
        sqlSession.commit();
    }

    @Test
    public void delteById(){
        sqlSession.delete("test.deleteById", 4);
        sqlSession.commit();
    }

    @Test
    public void updateUser(){
        User user=new User();
        user.setCnname("张三2");
        user.setId(1);

        int update = sqlSession.update("test.updateUserInfo", user);
        System.out.println(update);
    }

    @Test
    public void queryById(){
        try {
            /**
             * 第一个参数:执行的SQL语句的id:namespace.id
             * 第二个参数:传入SQL语句的参数
             */
            User user= sqlSession. selectOne ("test.queryById", 1);
            System.out.println(user.getCnname());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void queryByName(){
        try {
            /**
             * 第一个参数:执行的SQL语句的id:namespace.id
             * 第二个参数:传入SQL语句的参数
             */
            List<User> users = sqlSession. selectList ("test.queryByName", "张");
            System.out.println(users.get(0).getCnname());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
