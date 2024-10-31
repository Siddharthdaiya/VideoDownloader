package com.example.videodownloader;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity{

    TabLayout tablayout;
    TabItem mphoto,mvideo,mreels,migtv,mprofilepic;
    Toolbar toolbar;
    PagerAdapter pagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceStates){
        super.onCreate(savedInstanceStates);
        setContentView(R.layout.activity_main);
//        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mphoto=findViewById(R.id.photo);
        mreels=findViewById(R.id.reels);
        mvideo=findViewById(R.id.video);
        migtv=findViewById(R.id.igtv);
        mprofilepic=findViewById(R.id.profilepic);

        ViewPager viewPager=findViewById(R.id.fragmentcontainer);
        tablayout=findViewById(R.id.include);

        pagerAdapter=new PagerAdapter(getSupportFragmentManager(),5);
        viewPager.setAdapter(pagerAdapter);

        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||tab.getPosition()==3||tab.getPosition()==4)
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
viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
    }

}
