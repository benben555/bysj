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

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.VH>{
    private List<OrderBean> list = new ArrayList<>();
    static class VH extends RecyclerView.ViewHolder{
        private TextView tv_orderUID;
        private ImageView imv_photo;
        public VH(View v) {
            super(v);
            tv_orderUID = v.findViewById(R.id.tv_order_id);
            imv_photo = v.findViewById(R.id.imv_order_photo);

        }
    }

    public OrderAdapter(List<OrderBean> list) {
        this.list.addAll(list);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_order,viewGroup,false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, int i) {
        OrderBean order = list.get(i);
        vh.tv_orderUID.setText("订单"+order.getUID());
        int resouceId = 0;
        switch (order.getFlag()){
            case 1:resouceId = R.drawable.txsphy;break;
            case 3:resouceId = R.drawable.lvzuan;break;
            case 4:resouceId = R.drawable.baiduwangpan;break;
            default: resouceId = R.drawable.xinglixiang;
        }
        vh.imv_photo.setImageResource(resouceId);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
