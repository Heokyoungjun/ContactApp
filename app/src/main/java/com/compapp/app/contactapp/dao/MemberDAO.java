package com.compapp.app.contactapp.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.compapp.app.contactapp.domain.MemberBean;

import java.util.ArrayList;

/**
 * Created by hb2008 on 2017-02-11.
 */

public class MemberDAO extends SQLiteOpenHelper{

    public MemberDAO(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = String.format("%s","CREATE TABLE Member (" +
                                         "id text(10) PRIMARY KEY, " +
                                         "password text(10), " +
                                         "name text(10), " +
                                         "phone text(13), " +
                                         "addr text(10), " +
                                         "profile text(10));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //CREATE
    public void add(MemberBean bean){
        String sql = String.format("INSERT INTO Member " +
                                   "(id, password, name, phone, addr, profile) VALUES " +
                                   "('%s','%s','%s','%s','%s','%s');",
                                    bean.getId(), bean.getPassword(), bean.getName(),
                                    bean. getPhone(), bean.getAddr(), bean.getProfile());
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
        String sql = String.format("UPDATE Member SET " +
                                   "password = '%s', phone = '%s', " +
                                   "addr = '%s', profile = '%s' " +
                                   "WHERE id = '%s';",
                                   bean.getPassword(), bean.getPhone(),
                                   bean.getAddr(), bean.getProfile(),
                                   bean.getId());
    }

    //DELETE
    public void delete(MemberBean bean){
        String sql = String.format("DELETE FROM Member WHERE id = '%s';", bean.getId());
    }
}
