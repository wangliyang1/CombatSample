package com.bawei.combatsample.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.combatsample.R;
import com.bawei.combatsample.model.bean.Bean;
import com.bawei.combatsample.util.NetUtil;

import java.util.List;

public class GridAdapter extends BaseAdapter {
    List<Bean.ListdataBean> listdata;
    public GridAdapter(List<Bean.ListdataBean> listdata) {
        this.listdata = listdata;
    }

    @Override
    public int getCount() {
        return listdata.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView==null){
            viewHolder = new ViewHolder();
            convertView = View.inflate(parent.getContext(),R.layout.child,null);
            viewHolder.image = convertView.findViewById(R.id.image);
            viewHolder.one = convertView.findViewById(R.id.one);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        Bean.ListdataBean listdataBean = listdata.get(position);

        viewHolder.one.setText(listdataBean.getName());
        NetUtil.getInstance().getPhono(listdataBean.getAvatar(),viewHolder.image);
        return convertView;
    }
    class ViewHolder{
        private ImageView image;
        private TextView one;
    }
}
