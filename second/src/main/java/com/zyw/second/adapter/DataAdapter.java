package com.zyw.second.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zyw.second.R;
import com.zyw.second.bean.ListBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private List<ListBean.DataBean.DatasBean> data = new ArrayList<>();
    private Context context;
    private boolean theState = false;

    public DataAdapter(Context context) {
        this.context = context;
    }

    public void addData(List<ListBean.DataBean.DatasBean> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        ListBean.DataBean.DatasBean datasBean = data.get(i);

        Glide.with(context).load(datasBean.getEnvelopePic()).into(viewHolder.mImg);
        viewHolder.tvTitle.setText(datasBean.getTitle());
        viewHolder.tvDesc.setText(datasBean.getDesc());
        viewHolder.tvWriter.setText(datasBean.getChapterName());
        viewHolder.tvTime.setText(datasBean.getNiceDate());

        viewHolder.ivState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (theState == false) {
                    viewHolder.ivState.setBackgroundResource(R.drawable.video_is_follow_icon);
                    theState = true;
                } else {
                    viewHolder.ivState.setBackgroundResource(R.drawable.add_keep);
                    theState = false;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.mImg)
        ImageView mImg;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_desc)
        TextView tvDesc;
        @BindView(R.id.tv_writer)
        TextView tvWriter;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.iv_state)
        ImageView ivState;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
