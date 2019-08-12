package com.tech_613.podcast.adpter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tech_613.podcast.fragment.GlobalTop40Fragment;
import com.tech_613.podcast.fragment.LocalTop40Fragment;

public class TopPagerAdapter extends FragmentPagerAdapter {

    private static int NUM_ITEMS = 2;
    public TopPagerAdapter(FragmentManager fragmentManager)
    {
        super(fragmentManager);
    }
    @Override
    public Fragment getItem(int i) {
        switch (i)
        {
            case 0:
                return LocalTop40Fragment.newInstance();
            case 1:
                return GlobalTop40Fragment.newInstance();
                default:
                    return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

}
