package com.example.wulix.sprinkle;

import android.os.Bundle;
import android.widget.TableLayout;

import com.example.wulix.sprinkle.ui.adapter.FragmentAdapter;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.viewPager) ViewPager viewPager;
    @BindView(R.id.tabs) TabLayout tabLayout;

    FragmentAdapter fragmentAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(fragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);

        // needs improvements
        resetTabs();
    }

    private void resetTabs(){
        tabLayout.getTabAt(0).setText("setting");
        tabLayout.getTabAt(1).setText("dispense");
        tabLayout.getTabAt(2).setText("manage");
    }


}
