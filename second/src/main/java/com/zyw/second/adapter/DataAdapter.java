package com.zyw.second.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zyw.second.R;
import com.zyw.second.bean.AClass;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    List<AClass> data = new ArrayList<>();

    Context context;

    public DataAdapter(Context context) {
        this.context = context;
    }

    public void addData(List<AClass> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        AClass aClass = data.get(i);
        viewHolder.tv_name.setText(aClass.getName());
        viewHolder.tv_sex.setText(aClass.getSex());
        viewHolder.tv_age.setText(aClass.getAge());
        viewHolder.tv_className.setText(aClass.getClassName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView tv_name;
        @BindView(R.id.tv_sex)
        TextView tv_sex;
        @BindView(R.id.tv_age)
        TextView tv_age;
        @BindView(R.id.tv_className)
        TextView tv_className;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
