package com.woniu.mybatis.mapper;

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

import static org.junit.Assert.*;

/**
 * @author 离歌笑
 * @desc
 * @date 2020-06-14
 */
public class UserMapperTest {

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
    public void saveUserInfo() {
        //通过sqlSession中的方法获取mapper的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user=new User();
        user.setCnname("fasdfasdf");
        user.setUser_name("fadsf");
        user.setEmail("fasdf");
        user.setSex('1');
        user.setMobile("fasdf");
        user.setNote("fadsf");
        //调用mapper中的方法完成数据的持久化
        userMapper.saveUserInfo(user);

        sqlSession.commit();
    }
}