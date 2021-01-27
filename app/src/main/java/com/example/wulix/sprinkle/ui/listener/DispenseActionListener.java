//package com.example.wulix.sprinkle.ui.listener;
//
//import android.view.View;
//
//import com.example.wulix.sprinkle.R;
//import com.example.wulix.sprinkle.ui.adapter.IndivDispenseRecycleAdapter2;
//
//public class DispenseActionListener implements View.OnClickListener {
//
//    private IndivDispenseRecycleAdapter2.OnRecyclerViewItemClickListener onRecyclerViewItemClickListener = null;
//
//    public interface OnRecyclerViewItemClickListener {
//        void onItemClick(View view, IndivDispenseRecycleAdapter2.ViewName viewName, int position);
//    }
//
//    public void setOnItemClickListener(IndivDispenseRecycleAdapter2.OnRecyclerViewItemClickListener listener) {
//        IndivDispenseRecycleAdapter2.OnRecyclerViewItemClickListener onRecyclerViewItemClickListener = listener;
//    }
//
//    @Override
//    public void onClick(View v) {
//        int position = (int) v.getTag();
//        if (onRecyclerViewItemClickListener != null) {
//            switch (v.getId()){
//                case R.id.dispense_action:
//                    onRecyclerViewItemClickListener.onItemClick(v, IndivDispenseRecycleAdapter2.ViewName.VIEW_IMAGE, position);
//                    break;
//                default:
//                    break;
//            }
//        }
//    }
//}
