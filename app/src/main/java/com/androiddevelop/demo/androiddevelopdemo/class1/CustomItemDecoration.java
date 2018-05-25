package com.androiddevelop.demo.androiddevelopdemo.class1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @ Creator     :     chenchao
 * @ CreateDate  :     2018/5/25 0025 15:54
 * @ Description :     自定义分割线
 */

public class CustomItemDecoration extends RecyclerView.ItemDecoration {
    //定义垂直和水平方向常量
    private static final int VERTICAL_LIST   = LinearLayoutManager.VERTICAL;
    private static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;
    private final Drawable mDiverDrawable;
    private final Context  mContext;
    private final int      mInset;
    private final Paint    mPaint;
    private       int      mOrientation;

    /**
     * @param context
     * @param diverRes    分割线资源文件
     * @param orientation recycleviewlayout方向
     * @param insert      分割线的缩进
     */
    public CustomItemDecoration(Context context, int diverRes, int orientation, int insert) {
        this.mContext = context;
        mDiverDrawable = context.getResources().getDrawable(diverRes);
        this.mInset = insert;
        mPaint = new Paint();
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        setOrientation(orientation);
    }

    private void setOrientation(int orientation) {
        //根据layout方向绘制分割线
        if (orientation != VERTICAL_LIST && orientation != HORIZONTAL_LIST) {
            throw new IllegalArgumentException("orientation exception");
        }
        mOrientation = orientation;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        if (mOrientation == VERTICAL_LIST) {
            drawVerticaItem(c, parent);
        } else {
            drawHorizontalItem(c, parent);
        }
    }

    private void drawHorizontalItem(Canvas c, RecyclerView parent) {
        //获取分割线的位置
        int top=parent.getPaddingTop();
        int bottom=parent.getHeight()-parent.getPaddingBottom();
        //获取纵向的条目数量，最后一个条目不需要分割线（-1）
        for (int i = 0; i < parent.getChildCount() - 1; i++) {
            View childAt = parent.getChildAt(i);
            RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            int left=childAt.getRight()+lp.rightMargin;
            int right=left+mDiverDrawable.getIntrinsicHeight();
            //设置分割线的位置
            mDiverDrawable.setBounds(left,top,right,bottom);
            if(mInset>0){
                mDiverDrawable.setBounds(left,top+mInset,right,bottom-mInset);
            }
            mDiverDrawable.draw(c);
        }


    }

    private void drawVerticaItem(Canvas c, RecyclerView parent) {
        //获取分割线的位置
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        //获取所有的条目数量，最后一个条目不需要设置分割线(减去1)
        for (int i = 0; i < parent.getChildCount() - 1; i++) {
            //获取子view
            View childAt = parent.getChildAt(i);
            RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            int top = childAt.getBottom() + lp.bottomMargin;
            int bottom = top + mDiverDrawable.getIntrinsicHeight();
            //如果有缩进
            mDiverDrawable.setBounds(left,top,right,bottom);
            if(mInset>0){
                mDiverDrawable.setBounds(left+mInset,top,right-mInset,bottom);
            }
            mDiverDrawable.draw(c);
        }
    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        //由于分割线也要占据空间，所以条目在各自的方向上需要偏移
        if (mOrientation==VERTICAL_LIST) {
            outRect.set(0,0,0,mDiverDrawable.getIntrinsicHeight());
        }else {
            outRect.set(0,0,mDiverDrawable.getIntrinsicHeight(),0);
        }
    }
}
