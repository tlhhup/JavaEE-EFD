package com.woniu.mybatis.dao.impl;

import com.woniu.mybatis.dao.UserDao;
import com.woniu.mybatis.entity.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author 离歌笑
 * @desc
 * @date 2020-06-14
 */
public class UserDaoImpl implements UserDao {

    private SqlSession sqlSession;

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void saveUserInfo(User user) {
        sqlSession.insert("test.saveUserInfo", user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updateUser(User user) {
        sqlSession.update("test.updateUserInfo", user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteById(int id) {
        sqlSession.delete("test.deleteById", id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public User findById(int id) {
        User user = sqlSession.selectOne("test.queryById", id);
        sqlSession.close();
        return user;
    }

    @Override
    public List<User> findByUser(String name) {
        List<User> users = sqlSession.selectList("test.queryByName", name);
        sqlSession.close();
        return users;
    }


}
