package com.bigggfish.coordinatorlayoutdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private SimpleViewPagerIndicator mIndicator;
    private final String[] mTitles = new String[]{"NestedScrollView", "RecyclerView"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mIndicator = (SimpleViewPagerIndicator) findViewById(R.id.indicator);
        mIndicator.setTitles(mTitles);
        mIndicator.setIndicatorColor(R.color.colorAccent);
        mIndicator.setOnItemClickListener(new SimpleViewPagerIndicator.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                mViewPager.setCurrentItem(position);
            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mIndicator.scroll(position, positionOffset);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
    }



    class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position == 0){
                return NestedScrollViewTabFragment.newInstance();
            }else{
                return RecyclerViewTabFragment.newInstance();
            }
        }

        @Override
        public int getCount() {
            return mTitles.length;
        }
    }


}
