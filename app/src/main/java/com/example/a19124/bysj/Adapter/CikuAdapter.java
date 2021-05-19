package com.example.a19124.bysj.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a19124.bysj.Bean.OrderBean;
import com.example.a19124.bysj.R;

import java.util.ArrayList;
import java.util.List;

public class CikuAdapter extends RecyclerView.Adapter<com.example.a19124.bysj.Adapter.CikuAdapter.VH>{
        private List<OrderBean> list = new ArrayList<>();
        static class VH extends RecyclerView.ViewHolder{
            private TextView tv_orderUID;
            private ImageView imv_photo;
            public VH(View v) {
                super(v);
                imv_photo = v.findViewById(R.id.cikutupian);

            }
        }

        public CikuAdapter(List<OrderBean> list) {
            this.list.addAll(list);
        }

        @NonNull
        @Override
        public com.example.a19124.bysj.Adapter.CikuAdapter.VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_order,viewGroup,false);
            return new com.example.a19124.bysj.Adapter.CikuAdapter.VH(view);
        }

        @Override
        public void onBindViewHolder(@NonNull com.example.a19124.bysj.Adapter.CikuAdapter.VH vh, int i) {
            OrderBean order = list.get(i);
            //vh.tv_orderUID.setText("订单"+order.getUID());
            int resouceId = 0;
            switch (order.getFlag()){
                case 3:resouceId = R.drawable.gaokao;break;
                case 4:resouceId = R.drawable.siji;break;
                case 6:resouceId = R.drawable.liuji;break;
                case 8:resouceId = R.drawable.kaoyanjihua;break;
                default: resouceId = R.drawable.xinglixiang;
            }
            vh.imv_photo.setImageResource(resouceId);
        }
        @Override
        public int getItemCount() {
            return list.size();
        }
    }

