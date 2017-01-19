package com.example.morpheus.tabz;

import android.os.Bundle;
import android.support.v4.app.BundleCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by morpheus on 21.06.16.
 */
public class CollectionPagerAdapter extends FragmentStatePagerAdapter {
    public CollectionPagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int i)
    {
        Fragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putInt(BlankFragment.ARG, i+1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount()
    {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        return "item " + (position + 1);
    }
}
