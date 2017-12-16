package com.example.oliver.vezba161217_recyclerviewfragmenti;

import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.oliver.vezba161217_recyclerviewfragmenti.Fragments.FragmentRV;
import com.example.oliver.vezba161217_recyclerviewfragmenti.Fragments.FragmentSignIn;
import com.example.oliver.vezba161217_recyclerviewfragmenti.SharedPreferences.User;
import com.google.gson.Gson;

import butterknife.BindView;

public class Main2Activity extends AppCompatActivity {
    @BindView(R.id.myPager)
    ViewPager pager;
    @BindView(R.id.myTab)
    TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        SharedPreferences preferences = getSharedPreferences("MyFiles", MODE_PRIVATE);
        if (preferences.contains("User")) {

            User user1;
            Gson gson = new Gson();
            user1 = gson.fromJson(preferences.getString("User", ""), User.class);
        }
        PostaviPager(pager);
    }

    private void PostaviPager(ViewPager pager){
        PagerAdapter pagerAdapter = new PagerAdapter(this,getSupportFragmentManager());
        pagerAdapter.AddFragments(new FragmentSignIn(),"tab 1");
        pagerAdapter.AddFragments(new FragmentRV(),"tab 2");

        pager.setAdapter(pagerAdapter);
    }
}
