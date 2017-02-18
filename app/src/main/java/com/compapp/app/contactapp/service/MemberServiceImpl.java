package com.compapp.app.contactapp.service;

import android.content.Context;

import com.compapp.app.contactapp.dao.MemberDAO;
import com.compapp.app.contactapp.domain.MemberBean;

import java.util.ArrayList;

/**
 * Created by hb2008 on 2017-02-04.
 */

public class MemberServiceImpl implements  MemberService{
    MemberDAO dao;

    public MemberServiceImpl(Context context) {
        dao = new MemberDAO(context);
    }

    @Override
    public void add(MemberBean bean) {
        dao.add(bean);
    }

    @Override
    public MemberBean findOne(MemberBean bean) {
        return dao.findOne(bean);
    }

    @Override
    public boolean login(MemberBean bean) {
        MemberBean resultBean = this.findOne(bean);
        return !resultBean.getId().equals("fail") && bean.getPw().equals(resultBean.getPw());
    }

    @Override
    public ArrayList<MemberBean> findSome(String key) {

        return null;
    }

    @Override
    public ArrayList<MemberBean> list() {

        return dao.selectAll();
    }

    @Override
    public void upd(MemberBean bean) {

    }

    @Override
    public void del(MemberBean bean) {
        dao.delete(bean);
    }
}
