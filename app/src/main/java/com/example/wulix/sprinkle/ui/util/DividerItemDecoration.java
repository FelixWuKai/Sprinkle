package com.example.wulix.sprinkle.ui.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DividerItemDecoration extends RecyclerView.ItemDecoration{
    public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;
    public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;

    //使用系统自带的listDivider
    private static final int[] ATTRS = new int[]{
            android.R.attr.listDivider
    };

    private int mOrientation;
    private Drawable mDivider;


    public DividerItemDecoration(Context context, int mOrientation) {
        //使用TypeArray加载该系统资源
        final TypedArray ta = context.obtainStyledAttributes(ATTRS);
        mDivider = ta.getDrawable(0);
        //缓存
        ta.recycle();
        setOrientation(mOrientation);

    }



    public void setOrientation(int orientation){
        if(orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST){
            throw new IllegalArgumentException("invalid orientation");
        }
        mOrientation = orientation;
    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        if(mOrientation == VERTICAL_LIST){
            drawVertical(c,parent);
        }else{
            drawHorizontal(c,parent);
        }
    }

    public void drawVertical(Canvas c,RecyclerView parent){
        //获取分割线的左边距，即RecyclerView的padding值
        final int left = parent.getPaddingLeft();
        //分割线右边距
        final int right = parent.getWidth() - parent.getPaddingRight();

        final int childCount = parent.getChildCount();

        //遍历所有item view，为它们的下方绘制分割线
        for(int i=0;i<childCount;i++){
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin;
            final int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left,top,right,bottom);
            System.out.println("left: " + left + "top: " + top + "right: " + right + "bottom: " + bottom);
            mDivider.draw(c);
        }

    }

    public void drawHorizontal(Canvas c, RecyclerView parent){
        final int top = parent.getPaddingTop();
        final int bottom = parent.getHeight() - parent.getPaddingBottom();

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int left = child.getRight() + params.rightMargin;
            final int right = left + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);

            mDivider.draw(c);
        }
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        if(mOrientation == VERTICAL_LIST){
            //设置偏移的高度是mDivider.getIntrinsicHeight，该高度正是分割线的高度
            outRect.set(0,0,0,mDivider.getIntrinsicHeight());
            outRect.set(0, 0, 0, 15);
            System.out.println("######height1:    " + mDivider.getIntrinsicHeight());
        }else{
            outRect.set(0,0,mDivider.getIntrinsicWidth(),0);
            System.out.println("######width1:     " + mDivider.getIntrinsicWidth());
        }
    }

}
