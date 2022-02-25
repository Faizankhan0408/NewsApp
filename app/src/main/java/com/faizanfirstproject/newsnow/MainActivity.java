package com.faizanfirstproject.newsnow;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.faizanfirstproject.newsnow.Adapters.PagerAdapter;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    TabItem mHome,mScience,mEntertainment,mTechnology,mSports,mHealth;
    PagerAdapter pagerAdapter;
    Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar=findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mHome=findViewById(R.id.home);
        mHealth=findViewById(R.id.health);
        mEntertainment=findViewById(R.id.entertainment);
        mScience=findViewById(R.id.science);
        mTechnology=findViewById(R.id.technology);
        mSports=findViewById(R.id.sports);

        ViewPager viewPager=findViewById(R.id.fragmentcontainer);
        tabLayout=findViewById(R.id.tablayout);

        pagerAdapter=new PagerAdapter(getSupportFragmentManager(),6);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0 || tab.getPosition()==1 || tab.getPosition()==2 || tab.getPosition()==3 || tab.getPosition()==4 || tab.getPosition()==5)
                {
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}