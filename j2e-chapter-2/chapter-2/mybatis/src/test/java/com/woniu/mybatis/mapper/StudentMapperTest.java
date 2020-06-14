package com.woniu.mybatis.mapper;

import com.woniu.mybatis.entity.Student;
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
public class StudentMapperTest {

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
    public void findById() {
        StudentMapper studentMapper =sqlSession.getMapper(StudentMapper.class);
        Student student = studentMapper.findById(1);
        System.out.println(student.getIdCard().getNatives());
    }

    @Test
    public void oneByMany(){
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = studentMapper.findHealthInfo(1);
        System.out.println(student.getHelthInfos().get(0).getHeart());
    }
}