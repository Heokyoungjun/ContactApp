package com.compapp.app.contactapp.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.compapp.app.contactapp.domain.MemberBean;

import java.util.ArrayList;

/**
 * Created by hb2008 on 2017-02-11.
 */

public class MemberDAO extends SQLiteOpenHelper{

    public MemberDAO(Context context) {
        super(context, "hanbit.db", null, 1);
        this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql=String.format("%s","CREATE TABLE IF NOT EXISTS Member\n" +
                "(\n" +
                "id text(10) PRIMARY KEY,\n" +
                "pw text(10),\n" +
                "name text(10),\n" +
                "email text(20),\n" +
                "phone text(13),\n" +
                "profile text(10),\n" +
                "addr text(10));");
        db.execSQL(sql);
        db.execSQL("CREATE TABLE IF NOT EXISTS Message(\n" +
                "    _id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    sender TEXT(20),\n" +
                "    receiver TEXT(20),\n" +
                "    content TEXT(20),\n" +
                "    writeTime TEXT(20),\n" +
                "    id TEXT(20),\n" +
                "    FOREIGN KEY(id) REFERENCES Member(id)\n" +
                ");\n");

//        db.execSQL("INSERT INTO Member(id,pw,name,email,phone,profile,addr)\n" +
//                "VALUES('hong','1','홍길동','hong@test.com','010-1234-5678','default','서울');");
//        db.execSQL("INSERT INTO Member(id,pw,name,email,phone,profile,addr)\n" +
//                "VALUES('kim','1','김유신','kim@test.com','010-1234-5678','default','서울');");
//        db.execSQL("INSERT INTO Member(id,pw,name,email,phone,profile,addr)\n" +
//                "VALUES('lee','1','이순신','lee@test.com','010-1234-5678','default','서울');");
//        db.execSQL("INSERT INTO Member(id,pw,name,email,phone,profile,addr)\n" +
//                "VALUES('park','1','박지성','park@test.com','010-1234-5678','default','서울');");
//        db.execSQL("INSERT INTO Member(id,pw,name,email,phone,profile,addr)\n" +
//                "VALUES('yoo','1','유비','yoo@test.com','010-1234-5678','default','서울');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //CREATE
    public void add(MemberBean bean){
        String sql = String.format("INSERT INTO Member " +
                                   "(id, pw, name, email, phone, addr, profile) VALUES " +
                                   "('%s','%s','%s','%s','%s','%s');",
                                    bean.getId(), bean.getPw(), bean.getName(), bean.getEmail(),
                                    bean. getPhone(), bean.getAddr(), bean.getProfile());
    }

    //READ ONE
    public MemberBean findOne(MemberBean bean){
        MemberBean resultBean = new MemberBean();
        String sql = String.format("SELECT id, pw, name, email, phone, addr, profile " +
                                   "FROM Member " +
                                   "WHERE id = '%s';",bean.getId());
        Log.d("Login SQL = " ,sql);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToNext()) {
            Log.d("ID Result = " ,cursor.getString(0));

            resultBean.setId(cursor.getString(0));
            resultBean.setPw(cursor.getString(1));
            resultBean.setName(cursor.getString(2));
            resultBean.setEmail(cursor.getString(3));
            resultBean.setPhone(cursor.getString(4));
            resultBean.setAddr(cursor.getString(5));
            resultBean.setProfile(cursor.getString(6));
        } else {
            resultBean.setId("fail");
        }

        return resultBean;
    }

    //READ SOME
    public ArrayList<MemberBean> findSome(String key){
        ArrayList<MemberBean> resultList = new ArrayList<MemberBean>();
        String sql = String.format("SELECT id, pw, name, email, phone, addr, profile " +
                                   "FROM Member " +
                                   "WHERE name = '%s';",key);
        return resultList;
    }

    //READ ALL
    public ArrayList<MemberBean> selectAll(){
        ArrayList<MemberBean> resultList = new ArrayList<MemberBean>();
        String sql ="SELECT id, pw, name, email, phone, addr, profile " +
                    "FROM Member;";

        return resultList;
    }

    //UPDATE
    public void update(MemberBean bean){
        String sql = String.format("UPDATE Member SET " +
                                   "pw = '%s', phone = '%s', " +
                                   "addr = '%s', profile = '%s' " +
                                   "email = '%s' " +
                                   "WHERE id = '%s';",
                                   bean.getPw(), bean.getPhone(),
                                   bean.getAddr(), bean.getProfile(),
                                   bean.getEmail(),
                                   bean.getId());
    }

    //DELETE
    public void delete(MemberBean bean){
        String sql = String.format("DELETE FROM Member WHERE id = '%s';", bean.getId());
    }
}
