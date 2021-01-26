package com.example.wulix.sprinkle.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.wulix.sprinkle.R;
import com.example.wulix.sprinkle.module.DataDispenser;


import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class IndivDispenseRecycleAdapter extends BaseAdapter {

    private List<DataDispenser> dataDispensers;
    private Context mContext;

    public IndivDispenseRecycleAdapter(List<DataDispenser> dataDispensers, Context mContext) {
        this.dataDispensers = dataDispensers;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return dataDispensers.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.recycle_view_indiv_dispense, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.dispenserNumber = (TextView) convertView.findViewById(R.id.dispenserNumber);
            viewHolder.spiceName = (TextView) convertView.findViewById(R.id.spiceName);
            viewHolder.teaspoonNumb = (TextView) convertView.findViewById(R.id.teasponNumb);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.dispenserNumber.setText(dataDispensers.get(position).getDispenserNumberString());
        viewHolder.spiceName.setText(dataDispensers.get(position).getSpiceName());
        viewHolder.teaspoonNumb.setText(dataDispensers.get(position).getTeaspoonNumbString());
        return convertView;
    }


    private class ViewHolder{
        TextView dispenserNumber;
        TextView spiceName;
        TextView teaspoonNumb;
    }
}
