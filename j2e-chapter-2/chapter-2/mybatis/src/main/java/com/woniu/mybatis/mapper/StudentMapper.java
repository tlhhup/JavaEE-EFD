package com.woniu.mybatis.mapper;

import com.woniu.mybatis.entity.Student;

/**
 * @author 离歌笑
 * @desc
 * @date 2020-06-14
 */
public interface StudentMapper {

    Student findById(int id);

    Student findHealthInfo(int id);

}
