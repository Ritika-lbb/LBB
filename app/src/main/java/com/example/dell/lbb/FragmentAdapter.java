package com.example.dell.lbb;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.Locale;

/**
 * Created by dell on 5/20/2015.
 */
public class FragmentAdapter extends FragmentPagerAdapter {



    String[] tab = {"Events", "Discover", "Near Me"};

    public  FragmentAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        switch(position){
            case 0:
                fragment= new EventFragment();
                 break;

            case 1:
                fragment= new DiscoverFragment();
                break;

            case 2:
                fragment= new NearMeFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount()
    {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        String names = "";
        switch (position) {
            case 0:
                names=tab[0];
                break;

            case 1:
                names =tab[1];
                break;

            case 2:
                names=tab[2];
                break;

        }
        return names;
    }
}
