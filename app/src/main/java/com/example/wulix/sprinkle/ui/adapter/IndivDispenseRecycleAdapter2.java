package com.example.wulix.sprinkle.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wulix.sprinkle.R;
import com.example.wulix.sprinkle.module.DataDispenser;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class IndivDispenseRecycleAdapter2 extends RecyclerView.Adapter<IndivDispenseRecycleAdapter2.ViewHolder> implements View.OnClickListener{


    @BindView(R.id.disp_img) ImageView dispImg;
    @BindView(R.id.dispenserNumber) TextView dispenserNumber;
    @BindView(R.id.spiceName) TextView spiceName;
    @BindView(R.id.teasponNumb) TextView teasponNumb;
    @BindView(R.id.dispense_action) ImageView dispenseAction;
    @BindView(R.id.indiv_disp) CardView indivDisp;

    private List<DataDispenser> dataDispensers;

    private OnItemClickListener mOnItemClickListener;
    private OnRecyclerViewItemClickListener onRecyclerViewItemClickListener = null;
    private OnRecyclerViewItemClickListenerTest onRecyclerViewItemClickListenerTest = null;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, ViewName viewName, int position);
    }

    public interface OnRecyclerViewItemClickListenerTest{
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.onRecyclerViewItemClickListener = listener;
    }

    //为RecyclerView的每一个子Item设置setOnClickListener
    //这一点在Adapter中设置
    public void setOnItemClickListenerTest(OnRecyclerViewItemClickListenerTest listenerTest){
        this.onRecyclerViewItemClickListenerTest = listenerTest;
    }

    public enum ViewName{
        VIEW_IMAGE
    }

    //在OnCick中调用一下对外封装的接口，在这里就是onItemClick，
    //也就OnRecyclerViewItemClickListenerTest接口里面的一个方法
    //不在这里处理OnClick事件，而是由调用它的地方来处理，是为了保护代码的一致性
    @Override
    public void onClick(View v) {
        int position = (int) v.getTag();
        if (onRecyclerViewItemClickListenerTest != null) {
            switch (v.getId()){
                case R.id.dispense_action:
                    onRecyclerViewItemClickListenerTest.onItemClick(v, position);
                    break;
                    default:
                        break;
            }
        }

    }




    public IndivDispenseRecycleAdapter2(List<DataDispenser> dataDispensers) {
        this.dataDispensers = dataDispensers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_indiv_dispense_edit2, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.dispenserNumber.setText(dataDispensers.get(position).getDispenserNumberString());
        holder.spiceName.setText(dataDispensers.get(position).getSpiceName());
        holder.teaspoonNumb.setText(dataDispensers.get(position).getTeaspoonNumbString());
        holder.dispenseAction.setTag(position);
//        if (mOnItemClickListener != null) {
//            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
//            holder.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int position = holder.getLayoutPosition(); // 1
//                    System.out.println("position ######### " + position);
//                    //  mOnItemClickListener1.onItemClick1(holder.itemView,position); // 2
//                }
//            });
//        }

    }

    @Override
    public int getItemCount() {
        return dataDispensers.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        //        public TextView mTextView;
        public TextView dispenserNumber;
        public TextView spiceName;
        public TextView teaspoonNumb;
        public ImageView dispenseAction;

        public ViewHolder(View itemView) {
            super(itemView);
            //由于itemView是item的布局文件，我们需要的是里面的textView，因此利用itemView.findViewById获
            //取里面的textView实例，后面通过onBindViewHolder方法能直接填充数据到每一个textView了
            dispenserNumber = (TextView) itemView.findViewById(R.id.dispenserNumber);
            spiceName = (TextView) itemView.findViewById(R.id.spiceName);
            teaspoonNumb = (TextView) itemView.findViewById(R.id.teasponNumb);
            dispenseAction = (ImageView) itemView.findViewById(R.id.dispense_action);
            dispenseAction.setOnClickListener(IndivDispenseRecycleAdapter2.this);
        }
    }




}
