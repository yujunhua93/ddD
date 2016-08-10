package com.example.e450c.myapplicationdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.e450c.myapplicationdemo.R;

import java.util.List;

/**
 * Created by e450c on 2016/7/19.
 */
public class Myadapter extends BaseAdapter{
    private LayoutInflater layoutInflater;
    private List a ;
    public Myadapter(List a,Context context) {
        this.a = a;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return a.size();
    }

    @Override
    public Object getItem(int position) {
        return a.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.layout,null);
            viewHolder = new ViewHolder();
            viewHolder.tv = (TextView) convertView.findViewById(R.id.layout_tv);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv.setText(a.get(position).toString());

        return convertView;
    }

    class ViewHolder{
        public TextView tv;
    }
}

