package com.androiddevelop.demo.androiddevelopdemo.class1;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.androiddevelop.demo.androiddevelopdemo.R;
import com.androiddevelop.demo.androiddevelopdemo.utils.CommUtil;

import java.util.ArrayList;

public class Class1Activity extends AppCompatActivity implements LinearAdapter.OnItemClickListener {

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
            list.add(arr[i % arr.length]);
        }

        RecyclerView recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(linearLayoutManager);
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        //设置分割线
        CustomItemDecoration customItemDecoration = new CustomItemDecoration(this, R.drawable.shap_dilive, LinearLayoutManager.HORIZONTAL, CommUtil.dip2px(getApplication(), 5));
        recyclerview.addItemDecoration(customItemDecoration);
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        final LinearAdapter linearAdapter = new LinearAdapter(this, this, list);
        recyclerview.setAdapter(linearAdapter);
        linearAdapter.setOnItemClickListener(this);
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
        //新增swiperefreshlayout刷新
        final SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setColorSchemeColors(Color.RED,Color.YELLOW,Color.GREEN);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                        linearAdapter.notifyDataSetChanged();
                    }
                },2000);
            }
        });
    }


    @Override
    public void onItemClick(View view, int position) {
        switch (view.getId()) {
            case R.id.iv_1:
                Toast.makeText(getApplication(), "短点击了第" + position + "页的第1张图片", Toast.LENGTH_SHORT).show();

                break;
            case R.id.iv_2:
                Toast.makeText(getApplication(), "短点击了第" + position + "页的第2张图片", Toast.LENGTH_SHORT).show();

                break;
            case R.id.iv_3:
                Toast.makeText(getApplication(), "短点击了第" + position + "页的第3张图片", Toast.LENGTH_SHORT).show();

                break;
            default:
                break;
        }
    }

    @Override
    public void onLongItemClick(View view, int postion) {
        switch (view.getId()) {
            case R.id.iv_1:
                Toast.makeText(getApplication(), "长点击了第" + postion + "页的第1张图片", Toast.LENGTH_SHORT).show();

                break;
            case R.id.iv_2:
                Toast.makeText(getApplication(), "长点击了第" + postion + "页的第2张图片", Toast.LENGTH_SHORT).show();

                break;
            case R.id.iv_3:
                Toast.makeText(getApplication(), "长点击了第" + postion + "页的第3张图片", Toast.LENGTH_SHORT).show();

                break;
            default:
                break;
        }
    }
}
