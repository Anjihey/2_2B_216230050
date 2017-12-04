package com.example.anjihey;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class pageAdapter extends FragmentStatePagerAdapter {
    int num = 3;

    public pageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Pageonethread tab1 = new Pageonethread();
                return tab1;
            case 1:
                 Pagetwodb tab2 = new Pagetwodb();
                return tab2;
            case 2:
                Pagethreeweb tab3 = new Pagethreeweb();
                return tab3;
            default:
                return null;
        }
    }
    @Override
    public CharSequence getPageTitle(int p) { // 탭 이름 넣깅
        switch (p){
            case 0:
                return "Thread";
            case 1:
                return "DataBase";
            case 2:
                return "Web";
                default:
                    return null;
        }
    }

    @Override
    public int getCount() {
        return num;
    }
}
