package com.compapp.app.contactapp.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.compapp.app.contactapp.R;
import com.compapp.app.contactapp.domain.MemberBean;

import java.util.ArrayList;

/**
 * Created by hb2008 on 2017-02-18.
 */

public class MemberAdapter extends BaseAdapter{
    ArrayList<MemberBean> list;
    LayoutInflater inflater;
    private int[] photos = {
            R.drawable.cupcake,
            R.drawable.donut,
            R.drawable.eclair,
            R.drawable.froyo,
            R.drawable.gingerbread,
            R.drawable.honeycomb,
            R.drawable.icecream,
            R.drawable.jellybean,
            R.drawable.kitkat,
            R.drawable.lollipop
    };

    public MemberAdapter(ArrayList<MemberBean> list, Context context) {
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View v, ViewGroup g) {
        ViewHolder holder;

        if (v == null) {
             v = inflater.inflate(R.layout.memberlist, null);
            holder = new ViewHolder();
            holder.ivProfile = (ImageView) v.findViewById(R.id.ivProfile);
            holder.tvName = (TextView) v.findViewById(R.id.tvName);
            holder.tvPhone = (TextView) v.findViewById(R.id.tvPhone);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }

        holder.ivProfile.setImageResource(photos[i]);
        holder.tvName.setText(list.get(i).getName());
        holder.tvPhone.setText(list.get(i).getPhone());

        return v;
    }

    static class ViewHolder{
        ImageView ivProfile;
        TextView tvName, tvPhone;
    }
}
