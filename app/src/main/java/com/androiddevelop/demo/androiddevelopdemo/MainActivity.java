package com.androiddevelop.demo.androiddevelopdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.androiddevelop.demo.androiddevelopdemo.class1.Class1Activity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        Button btn_class1 = (Button) findViewById(R.id.btn_class1);
        btn_class1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_class1:
                startActivity(new Intent(MainActivity.this,Class1Activity.class));
                break;
            default:
                break;
        }
    }
}
