package com.example.wulix.sprinkle.ui.listener;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class IndivDispRecyclerViewListener implements RecyclerView.OnItemTouchListener {

    private GestureDetector mGestureDetector;
    private OnItem_IndivDisp_ClickListener mListener;

    //内部接口，定义点击方法以及长按方法
    public interface OnItem_IndivDisp_ClickListener {
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    public IndivDispRecyclerViewListener(Context context, final RecyclerView recyclerView, OnItem_IndivDisp_ClickListener listener) {
        this.mListener = listener;
        this.mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                View childView = recyclerView.findChildViewUnder(e.getX(),e.getY());
                if (childView != null && mListener != null){
                    mListener.onItemClick(childView,recyclerView.getChildLayoutPosition(childView));
                    return true;
                }
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                super.onLongPress(e);
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
        //把事件交给GestureDetector处理
        if(mGestureDetector.onTouchEvent(e)){
            return true;
        }else
            return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
