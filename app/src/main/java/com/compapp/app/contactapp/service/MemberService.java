package com.compapp.app.contactapp.service;

import com.compapp.app.contactapp.domain.MemberBean;

import java.util.ArrayList;

/**
 * Created by hb2008 on 2017-02-04.
 */

public interface MemberService {
    //CREATE
    public void add(MemberBean bean);
    //READ ONE
    public MemberBean findOne(MemberBean bean);
    //LOGIN
    public boolean login(MemberBean bean);
    //READ SOME
    public ArrayList<MemberBean> findSome(String key);
    //READ ALL
    public ArrayList<MemberBean> list();
    //UPDATE
    public void upd(MemberBean bean);
    //DELETE
    public void del(MemberBean bean);
}
