package me.roneythomas.tourguideapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_pager);
        ViewPager mViewPager = (ViewPager) findViewById(R.id.activity_places_page_view_pager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {

            @Override
            public Fragment getItem(int position) {
                return new PlacesFragment().newInstance(position);
            }

            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return getString(R.string.page_title_1);
                    case 1:
                        return getString(R.string.page_title_2);
                    case 2:
                        return getString(R.string.page_title_3);
                    case 3:
                        return getString(R.string.page_title_4);
                }
                return "404";
            }
        });

        mViewPager.setCurrentItem(0);
    }
}
