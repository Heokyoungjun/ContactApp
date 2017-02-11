package com.compapp.app.contactapp.dao;

import com.compapp.app.contactapp.domain.MemberBean;

import java.util.ArrayList;

/**
 * Created by hb2008 on 2017-02-11.
 */

public class MemberDAO {
    //CREATE
    public void add(MemberBean bean){
        String sql = String.format("INSERT INTO Member " +
                                   "(id, password, name, phone, addr, profile) VALUES " +
                                   "('%s','%s','%s','%s','%s','%s');",
                                    bean.getId(),bean.getPassword(),bean.getName(),
                                    bean.getPhone(),bean.getAddr(),bean.getProfile());
    }
    //READ ONE
    public MemberBean findOne(MemberBean bean){
        MemberBean resultBean = new MemberBean();
        String sql = String.format("SELECT id, password, name, phone, addr, profile " +
                                   "FROM Member " +
                                   "WHERE id = '%s';",bean.getId());
        return resultBean;
    }
    //READ SOME
    public ArrayList<MemberBean> findSome(String key){
        ArrayList<MemberBean> resultList = new ArrayList<MemberBean>();
        String sql = String.format("SELECT id, password, name, phone, addr, profile " +
                                   "FROM Member " +
                                   "WHERE name = '%s';",key);
        return resultList;
    }
    //READ ALL
    public ArrayList<MemberBean> selectAll(){
        ArrayList<MemberBean> resultList = new ArrayList<MemberBean>();
        String sql ="SELECT id, password, name, phone, addr, profile " +
                    "FROM Member;";

        return resultList;
    }
    //UPDATE
    public void update(MemberBean bean){

    }
    //DELETE
    public void delete(MemberBean bean){

    }
}
