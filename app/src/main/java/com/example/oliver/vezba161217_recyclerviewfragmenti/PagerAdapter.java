package com.example.oliver.vezba161217_recyclerviewfragmenti;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Oliver on 12/16/2017.
 */

public class PagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragmenti = new ArrayList<>();
    ArrayList<String> titles = new ArrayList<>();

    public void AddFragments(Fragment fragment, String title){
        titles.add(title);
        fragmenti.add(fragment);

    }

    public PagerAdapter(Main2Activity main2Activity, FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmenti.get(position);
    }

    @Override
    public int getCount() {
        return fragmenti.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
