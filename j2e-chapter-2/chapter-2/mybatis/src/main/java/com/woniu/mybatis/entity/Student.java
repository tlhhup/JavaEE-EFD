package com.woniu.mybatis.entity;

import java.util.List;

/**
 * @author 离歌笑
 * @desc
 * @date 2020-06-14
 */
public class Student {

    private int id;
    private String cnname;
    private char sex;
    private String note;

    private IdCard idCard;

    private List<HelthInfo> helthInfos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCnname() {
        return cnname;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public IdCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IdCard idCard) {
        this.idCard = idCard;
    }

    public List<HelthInfo> getHelthInfos() {
        return helthInfos;
    }

    public void setHelthInfos(List<HelthInfo> helthInfos) {
        this.helthInfos = helthInfos;
    }
}
