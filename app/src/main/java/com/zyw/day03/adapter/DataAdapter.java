package com.zyw.day03.adapter;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.zyw.day03.R;
import com.zyw.day03.bean.Bean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private List<Bean.DataBean.DatasBean> data = new ArrayList<>();
    private Context context;

    public DataAdapter(Context context) {
        this.context = context;
    }

    public void addData(List<Bean.DataBean.DatasBean> data) {
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
        Bean.DataBean.DatasBean datasBean = data.get(i);

        RoundedCorners roundedCorners = new RoundedCorners(15);
        RequestOptions override = RequestOptions.bitmapTransform(roundedCorners).override(100, 100);
        Glide.with(context).load(datasBean.getEnvelopePic()).apply(override).into(viewHolder.mImg);

        viewHolder.mTitle.setText(datasBean.getTitle());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.mImg)
        ImageView mImg;
        @BindView(R.id.mTitle)
        TextView mTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
