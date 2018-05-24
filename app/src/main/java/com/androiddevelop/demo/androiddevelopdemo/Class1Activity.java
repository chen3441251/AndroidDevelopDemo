package com.androiddevelop.demo.androiddevelopdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Class1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class1);
        initView();
    }

    private void initView() {
        int[] arr = {R.mipmap.imag1, R.mipmap.imag2, R.mipmap.imag3, R.mipmap.imag4, R.mipmap.imag5, R.mipmap.imag6,
                R.mipmap.imag7, R.mipmap.imag8, R.mipmap.imag9};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(arr[i%arr.length]);
        }

        RecyclerView recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerview.setLayoutManager(linearLayoutManager);
        recyclerview.setAdapter(new LinearAdapter(this, list));
        recyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.MyViewHolder> {
        private final Context context;
        private final List<Integer> list;

        public LinearAdapter(Context context, List<Integer> list) {
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
            Log.d("xxx","pos="+position);
            holder.mIv1.setBackgroundResource(list.get(position%3));
            holder.mIv2.setBackgroundResource(list.get((position+1)%3));
            holder.mIv3.setBackgroundResource(list.get((position+2)%3));
            holder.mIv1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int layoutPosition = holder.getLayoutPosition();
                    Toast.makeText(getApplication(),"点击了第"+layoutPosition+"页的第1张图片",Toast.LENGTH_SHORT).show();
                }
            });
            holder.mIv2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int layoutPosition = holder.getLayoutPosition();
                    Toast.makeText(getApplication(),"点击了第"+layoutPosition+"页的第2张图片",Toast.LENGTH_SHORT).show();
                }
            });
            holder.mIv3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int layoutPosition = holder.getLayoutPosition();
                    Toast.makeText(getApplication(),"点击了第"+layoutPosition+"页的第3张图片",Toast.LENGTH_SHORT).show();
                }
            });
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
    }


}
