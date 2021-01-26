package com.example.wulix.sprinkle.ui.adapter;

import com.example.wulix.sprinkle.ui.fragment.dispense.IndivDispenseFragment;
import com.example.wulix.sprinkle.ui.fragment.dispense.MassDispenseFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class DispFragmentAdapter extends FragmentPagerAdapter {

    public DispFragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new MassDispenseFragment();
            case 1:
                return new IndivDispenseFragment();
                default:
                    return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
