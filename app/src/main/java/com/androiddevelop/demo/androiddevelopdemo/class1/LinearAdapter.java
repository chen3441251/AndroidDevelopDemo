package com.androiddevelop.demo.androiddevelopdemo.class1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.androiddevelop.demo.androiddevelopdemo.R;

import java.util.List;
import java.util.Random;

/**
 * Created by CC on 2018/5/28.
 */
class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.MyViewHolder> {
    private Class1Activity mClass1Activity;
    private final Context context;
    private final List<Integer> list;
    private OnItemClickListener mOnItemClickListener;

    public LinearAdapter(Class1Activity class1Activity, Context context, List<Integer> list) {
        mClass1Activity = class1Activity;
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recycleview_layout, parent, false));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Log.d("xxx", "pos=" + position);
        holder.mIv1.setBackgroundResource(list.get(new Random().nextInt(30)));
        holder.mIv2.setBackgroundResource(list.get(new Random().nextInt(30)));
        holder.mIv3.setBackgroundResource(list.get(new Random().nextInt(30)));

        if (mOnItemClickListener != null) {


            holder.mIv1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(v, holder.getLayoutPosition());
                    //                int layoutPosition = holder.getLayoutPosition();
                    //                Toast.makeText(mClass1Activity.getApplication(), "点击了第" + layoutPosition + "页的第1张图片", Toast.LENGTH_SHORT).show();
                }
            });
            holder.mIv2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(v, holder.getLayoutPosition());
                    //                int layoutPosition = holder.getLayoutPosition();
                    //                Toast.makeText(mClass1Activity.getApplication(), "点击了第" + layoutPosition + "页的第2张图片", Toast.LENGTH_SHORT).show();
                }
            });
//
            holder.mIv3.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mOnItemClickListener.onLongItemClick(v, holder.getLayoutPosition());

                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView mIv1;
        ImageView mIv2;
        ImageView mIv3;

        public MyViewHolder(View itemView) {
            super(itemView);
            mIv1 = itemView.findViewById(R.id.iv_1);
            mIv2 = itemView.findViewById(R.id.iv_2);
            mIv3 = itemView.findViewById(R.id.iv_3);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onLongItemClick(View view, int postion);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }
}
