package com.example.wulix.sprinkle.ui.fragment.dispense;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.wulix.sprinkle.R;
import com.example.wulix.sprinkle.module.DataDispenser;
import com.example.wulix.sprinkle.module.Translation1;
import com.example.wulix.sprinkle.network.api.GetRequestTest;
import com.example.wulix.sprinkle.ui.adapter.IndivDispenseRecycleAdapter2;
import com.example.wulix.sprinkle.ui.adapter.IndivDispenseRecycleAdapter3;
import com.example.wulix.sprinkle.ui.base.BaseFragment;
import com.example.wulix.sprinkle.ui.listener.IndivDispRecyclerViewListener;
import com.example.wulix.sprinkle.ui.util.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class IndivDispenseFragment extends BaseFragment {

    private List<DataDispenser> dataDispensers;
    private View view;

    private RecyclerView.LayoutManager layoutManager;
    private IndivDispenseRecycleAdapter2 indivDispenseRecycleAdapter2;
    private IndivDispenseRecycleAdapter3 indivDispenseRecycleAdapter3;
    String trans = null;

    DataDispenser dispenser1 = new DataDispenser(1, "salt", 12);
    DataDispenser dispenser2 = new DataDispenser(2, "sugar", 22);
    DataDispenser dispenser3 = new DataDispenser(3, "pepper", 3);
    DataDispenser dispenser4 = new DataDispenser(4, "mint", 6);
    DataDispenser dispenser5 = new DataDispenser(5, "garlic", 4);



//    @BindView(R.id.indiv_disp) Button indivDisp;
    @BindView(R.id.disp_recyView) RecyclerView dispRecyView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.fragment_indiv_dispense, container, false);
        ButterKnife.bind(this, view);
        initData();
        initRecyclerView();
//        indivDisp.setOnClickListener(btnOnClickListener);
        return view;
    }

//    View.OnClickListener btnOnClickListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            Toast.makeText(getContext(), "Device is Individually Dispensing ", Toast.LENGTH_SHORT).show();
//        }
//    };


    private void initData() {

        dataDispensers = new ArrayList<>();
        dataDispensers.add(dispenser1);
        dataDispensers.add(dispenser2);
        dataDispensers.add(dispenser3);
        dataDispensers.add(dispenser4);
        dataDispensers.add(dispenser5);
//        System.out.println("initData");
//        for (int i = 0; i<5; i++){
//            System.out.println(dataDispensers.get(i).generalGetter());
//        }


    }

    private void initRecyclerView() {
        layoutManager = new LinearLayoutManager(getActivity());
        dispRecyView.setLayoutManager(layoutManager);
//        dispRecyView.addOnItemTouchListener(new IndivDispRecyclerViewListener(getContext(), dispRecyView, new IndivDispRecyclerViewListener.OnItem_IndivDisp_ClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                Toast.makeText(getActivity(),"Click "+dataDispensers.get(position),Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onItemLongClick(View view, int position) {
//                Toast.makeText(getActivity(),"Long Click "+dataDispensers.get(position),Toast.LENGTH_SHORT).show();
//            }
//        }));


        indivDispenseRecycleAdapter2 = new IndivDispenseRecycleAdapter2(dataDispensers);
        dispRecyView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        dispRecyView.setAdapter(indivDispenseRecycleAdapter2);
        indivDispenseRecycleAdapter2.setOnItemClickListenerTest(new IndivDispenseRecycleAdapter2.OnRecyclerViewItemClickListenerTest() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getContext(), "On Item Click I started dispensing bitch ", Toast.LENGTH_SHORT).show();
                requestGet();
            }
        });

        indivDispenseRecycleAdapter3 = new IndivDispenseRecycleAdapter3(dataDispensers);
        dispRecyView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        dispRecyView.setAdapter(indivDispenseRecycleAdapter3);
        indivDispenseRecycleAdapter3.setOnItemClickListenerTest(new IndivDispenseRecycleAdapter3.OnRecyclerViewItemClickListenerTest() {
            @Override
            public void onDispClick(View view, int position) {
                Toast.makeText(getContext(), dataDispensers.get(position).getTeaspoonNumbString(), Toast.LENGTH_SHORT).show();
                requestGet();
            }

            @Override
            public void onEditClick(View view, int position) {
                Toast.makeText(getContext(), "edit button", Toast.LENGTH_SHORT).show();
                requestGet();
            }
        });



    }

    public void requestGet(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.7/salt/2/") // 设置网络请求的Url地址
                .addConverterFactory(GsonConverterFactory.create()) // 设置数据解析器
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 支持RxJava平台
                .build();

        // 创建 网络请求接口 的实例
        final GetRequestTest requestGet = retrofit.create(GetRequestTest.class);

        //对 发送请求 进行封装
        Call<Translation1> call = requestGet.getCall(trans);
        call.enqueue(new Callback<Translation1>() {
            @Override
            public void onResponse(Call<Translation1> call, Response<Translation1> response) {
                Toast.makeText(getContext(), "yeeeeeeeeeeeeeeeeeee I started dispensing bitch ", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Translation1> call, Throwable t) {
                Toast.makeText(getContext(), "fuckkkkkkkkkkkkkkkk I faied dispensing bitch ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
