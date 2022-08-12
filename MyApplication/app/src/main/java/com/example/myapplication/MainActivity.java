package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ViewPager loopPager;
    private loopPagerAdapter loopPagerAdapter;
    private static List<Integer> sPics=new ArrayList<>();
    private Handler handler;

    static{
        sPics.add(R.mipmap.t1);
        sPics.add(R.mipmap.t2);
        sPics.add(R.mipmap.t3);
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        initView();

        handler=new Handler();



        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });


        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, MainActivity3.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        //当我这个界面绑定到窗口
        handler.post(loopTask);
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        handler.removeCallbacks(loopTask);
    }

    private Runnable loopTask=new Runnable() {
        @Override
        public void run() {
                //切换ViewPager里的图片到下一个
                int currentItem = loopPager.getCurrentItem();
                loopPager.setCurrentItem(++currentItem, true);
                handler.postDelayed(this, 1500);
            }
    };

    private void initView(){
        //找到viewPager的控件
        loopPager=(ViewPager) this.findViewById(R.id.viewpager);
        //设置适配器
        loopPagerAdapter =new loopPagerAdapter();
        loopPagerAdapter.setData(sPics);
        loopPager.setAdapter(loopPagerAdapter);
        loopPager.setCurrentItem(loopPagerAdapter.getDataRealSize()*100,false);
    }
 }