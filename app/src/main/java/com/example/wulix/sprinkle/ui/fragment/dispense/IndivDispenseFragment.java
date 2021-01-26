package com.example.wulix.sprinkle.ui.fragment.dispense;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.wulix.sprinkle.R;
import com.example.wulix.sprinkle.ui.base.BaseFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;

public class IndivDispenseFragment extends BaseFragment {
    @BindView(R.id.indiv_disp) Button indivDisp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_indiv_dispense, container, false);
        ButterKnife.bind(this, view);
        indivDisp.setOnClickListener(btnOnClickListener);
        return view;
    }

    View.OnClickListener btnOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getContext(), "Device is Individually Dispensing ", Toast.LENGTH_SHORT).show();
        }
    };
}
