package com.example.wulix.sprinkle.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wulix.sprinkle.R;
import com.example.wulix.sprinkle.module.DataDispenser;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class IndivDispenseRecycleAdapter2 extends RecyclerView.Adapter<IndivDispenseRecycleAdapter2.ViewHolder>{


    private List<DataDispenser> dataDispensers;

    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

    public IndivDispenseRecycleAdapter2(List<DataDispenser> dataDispensers) {
        this.dataDispensers = dataDispensers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_indiv_dispense, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.dispenserNumber.setText(dataDispensers.get(position).getDispenserNumberString());
        holder.spiceName.setText(dataDispensers.get(position).getSpiceName());
        holder.teaspoonNumb.setText(dataDispensers.get(position).getTeaspoonNumbString());

        if(mOnItemClickListener != null){
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition(); // 1
                    System.out.println("position ######### "+ position);
                    //  mOnItemClickListener1.onItemClick1(holder.itemView,position); // 2
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return dataDispensers.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
//        public TextView mTextView;
        public TextView dispenserNumber;
        public TextView spiceName;
        public TextView teaspoonNumb;
        public ViewHolder(View itemView) {
            super(itemView);
            //由于itemView是item的布局文件，我们需要的是里面的textView，因此利用itemView.findViewById获
            //取里面的textView实例，后面通过onBindViewHolder方法能直接填充数据到每一个textView了
            dispenserNumber = (TextView) itemView.findViewById(R.id.dispenserNumber);
            spiceName = (TextView) itemView.findViewById(R.id.spiceName);
            teaspoonNumb = (TextView) itemView.findViewById(R.id.teasponNumb);
        }
    }
}
