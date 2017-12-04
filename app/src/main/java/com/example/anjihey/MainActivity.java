package com.example.anjihey;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //////////////////// 탭 레이아웃 ////////////////////////////////////////////////////

        pageAdapter pa = new pageAdapter(
                getSupportFragmentManager()
        );
        ViewPager mvp = (ViewPager) findViewById(R.id.vp); // 뷰페이저 찾기 연결하기
        mvp.setAdapter(pa); // 뷰페이저 연결하기

        TabLayout tab = (TabLayout) findViewById(R.id.tl);
        tab.setupWithViewPager(mvp); // 탭과뷰페이지 연결ㄹ

    }

}
