package com.example.wulix.sprinkle.ui.adapter;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wulix.sprinkle.R;
import com.example.wulix.sprinkle.module.DataDispenser;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

import static androidx.constraintlayout.widget.StateSet.TAG;

public class IndivDispenseRecycleAdapter3 extends RecyclerView.Adapter<IndivDispenseRecycleAdapter3.ViewHolder> implements View.OnClickListener {


    @BindView(R.id.disp_img) ImageView dispImg;
    @BindView(R.id.dispenser) TextView dispenser;
    @BindView(R.id.disp_numb) TextView dispNumb;
    @BindView(R.id.spice) TextView spice;
    @BindView(R.id.spic_name) TextView spicName;
    @BindView(R.id.enter_amount) TextView enterAmount;
    @BindView(R.id.spice_amount) EditText spiceAmount;
    @BindView(R.id.tps) TextView tps;
    @BindView(R.id.btn_disp) Button btnDisp;
    @BindView(R.id.btn_edit) Button btnEdit;
    @BindView(R.id.indiv_disp) CardView indivDisp;

    private List<DataDispenser> dataDispensers;

//    private OnItemClickListener mOnItemClickListener;
//    private OnRecyclerViewItemClickListener onRecyclerViewItemClickListener = null;
    private OnRecyclerViewItemClickListenerTest onRecyclerViewItemClickListenerTest = null;

//    public interface OnItemClickListener {
//        void onItemClick(View view, int position);
//    }
//
//    public interface OnRecyclerViewItemClickListener {
//        void onItemClick(View view, ViewName viewName, int position);
//    }

    public interface OnRecyclerViewItemClickListenerTest {
        void onDispClick(View view, int position);
        void onEditClick(View view, int positon);
    }

//    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
//        this.onRecyclerViewItemClickListener = listener;
//    }

    //为RecyclerView的每一个子Item设置setOnClickListener
    //这一点在Adapter中设置
    public void setOnItemClickListenerTest(OnRecyclerViewItemClickListenerTest listenerTest) {
        this.onRecyclerViewItemClickListenerTest = listenerTest;
    }

    public enum ViewName {
        VIEW_IMAGE
    }

    //在OnCick中调用一下对外封装的接口，在这里就是onItemClick，
    //也就OnRecyclerViewItemClickListenerTest接口里面的一个方法
    //不在这里处理OnClick事件，而是由调用它的地方来处理，是为了保护代码的一致性
    @Override
    public void onClick(View v) {
        int position = (int) v.getTag();
        if (onRecyclerViewItemClickListenerTest != null) {
            switch (v.getId()) {
                case R.id.btn_disp:
                    onRecyclerViewItemClickListenerTest.onDispClick(v, position);
                    break;
                case R.id.btn_edit:
                    onRecyclerViewItemClickListenerTest.onEditClick(v, position);
                    break;
                    default:
                        break;
            }
        }
    }




    public IndivDispenseRecycleAdapter3(List<DataDispenser> dataDispensers) {
        this.dataDispensers = dataDispensers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_indiv_dispense_edit4, parent, false);
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
        final EditText teaspoonNumb;
        public Button dispenseAction;
        public Button editAction;
        private int num = 0;
        public ViewHolder(View itemView) {
            super(itemView);
            //由于itemView是item的布局文件，我们需要的是里面的textView，因此利用itemView.findViewById获
            //取里面的textView实例，后面通过onBindViewHolder方法能直接填充数据到每一个textView了
            dispenserNumber = (TextView) itemView.findViewById(R.id.disp_numb);
            spiceName = (TextView) itemView.findViewById(R.id.spic_name);
            teaspoonNumb = (EditText) itemView.findViewById(R.id.spice_amount);
            dispenseAction = itemView.findViewById(R.id.btn_disp);
            editAction = itemView.findViewById(R.id.btn_edit);
            dispenseAction.setOnClickListener(IndivDispenseRecycleAdapter3.this);
            editAction.setOnClickListener(IndivDispenseRecycleAdapter3.this);

            teaspoonNumb.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if(keyCode == KeyEvent.KEYCODE_DEL){
                        //获取当前editText中的内容
                        String text = teaspoonNumb.getText().toString();
                        //判断text中是否有内容
                        if(0<text.length()){
                            //判断text中是否只有一个字符
                            if(0 == text.length()-1){
                                //如果只有一个则直接令editText为""，即none
                                teaspoonNumb.setText("");
                                //将焦点置于第0位，即最开始
                                teaspoonNumb.setSelection(0);
                            }else{
                                //否则删除该字段的最后一个字符并将删除后的结果赋予newText
                                String newText = text.substring(0,text.length()-1);
                                //显示newText中的内容
                                teaspoonNumb.setText(newText);
                                //设置焦点在该字段最后
                                teaspoonNumb.setSelection(newText.length());
                            }
                        }
                        return true;
                    }
                    return false;
                }
            });
            teaspoonNumb.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    Log.d(TAG, "beforeTextChanged: s = " + s + ", start = " + start +
                            ", count = " + count + ", after = " + after);
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    Log.d(TAG, "onTextChange: " + s);
                }

                @Override
                public void afterTextChanged(Editable s) {
                    Log.d(TAG, "afterTextChanged: " + s);
                    dataDispensers.get(getAdapterPosition()).setTeaspoonNumb(Integer.parseInt(teaspoonNumb.getText().toString()));
                }
            });


        }
    }


}
