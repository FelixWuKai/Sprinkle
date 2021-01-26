package com.example.wulix.sprinkle.ui.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import com.example.wulix.sprinkle.ui.fragment.DispenseFragment;
import com.example.wulix.sprinkle.ui.fragment.ManageFragment;
import com.example.wulix.sprinkle.ui.fragment.SettingFragment;


public class FragmentAdapter extends FragmentPagerAdapter {

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                return new DispenseFragment();
            case 1:
                return new ManageFragment();
            case 2:
                return new SettingFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }


}
