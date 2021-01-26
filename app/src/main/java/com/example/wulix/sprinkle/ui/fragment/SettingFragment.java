package com.example.wulix.sprinkle.ui.fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.wulix.sprinkle.R;
import com.example.wulix.sprinkle.ui.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingFragment extends BaseFragment {
    @BindView(R.id.setting) Button setting;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        ButterKnife.bind(this, view);
        setting.setOnClickListener(btnOnClickListener);
        return view;
    }

    View.OnClickListener btnOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getContext(), "Setting Fragment", Toast.LENGTH_SHORT).show();
        }
    };


}
