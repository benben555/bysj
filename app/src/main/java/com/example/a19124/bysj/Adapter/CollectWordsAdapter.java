package com.example.a19124.bysj.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a19124.bysj.Bean.WordBean;
import com.example.a19124.bysj.R;

import java.util.ArrayList;
import java.util.List;

public class CollectWordsAdapter extends RecyclerView.Adapter<CollectWordsAdapter.VH>{
    private List<WordBean> list = new ArrayList<>();
    static class VH extends RecyclerView.ViewHolder {
        private TextView tv_word;
        private TextView tv_msg;
        public VH(View view){
            super(view);
            tv_word = view.findViewById(R.id.tv_collect_word);
            tv_msg = view.findViewById(R.id.tv_collect_msg);
        }
    }

    public CollectWordsAdapter(List<WordBean> list) {
        this.list.addAll(list);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_collect_word,viewGroup,false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, int i) {
        WordBean word = list.get(i);
        vh.tv_word.setText(word.getWord());
        vh.tv_msg.setText(word.getMsg());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
