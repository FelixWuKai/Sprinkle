package com.example.wulix.sprinkle.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.wulix.sprinkle.R;
import com.example.wulix.sprinkle.ui.adapter.DispFragmentAdapter;
import com.example.wulix.sprinkle.ui.base.BaseFragment;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DispenseFragment extends BaseFragment {
    @BindView(R.id.disp_subtab) TabLayout dispSubtab;
    @BindView(R.id.viewPager) ViewPager viewPager;
    DispFragmentAdapter dispFragmentAdapter;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dispense, container, false);
        ButterKnife.bind(this, view);
        dispFragmentAdapter = new DispFragmentAdapter(getChildFragmentManager());
        viewPager.setAdapter(dispFragmentAdapter);
        dispSubtab.setupWithViewPager(viewPager);
        resetTabs();

        return view;
    }

    private void resetTabs(){
        dispSubtab.getTabAt(0).setText("Mass Dispense");
        dispSubtab.getTabAt(1).setText("Individual Dispense");
    }
}
