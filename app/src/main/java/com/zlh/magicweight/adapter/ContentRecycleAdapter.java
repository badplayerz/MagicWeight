package com.zlh.magicweight.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.magicweight.entity.ArticlesContents;
import com.zlh.magicweight.R;
import com.zlh.magicweight.databinding.ItemContentfragmentBinding;
import com.zlh.magicweight.viewmodel.ItemContentViewModel;

import java.util.ArrayList;

/**
 * Created by sdbean-zlh on 16/7/6.
 */
public class ContentRecycleAdapter extends RecyclerView.Adapter<ContentRecycleAdapter.ViewHolder>{

    private ArrayList<ArticlesContents> mList;

    public ContentRecycleAdapter(ArrayList<ArticlesContents> list) {
        mList = list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemContentfragmentBinding mItemContentfragmentBinding;
        public ViewHolder(ItemContentfragmentBinding itemContentfragmentBinding) {
            super(itemContentfragmentBinding.itemRelative);
            mItemContentfragmentBinding = itemContentfragmentBinding;
        }

        void bindItem(ArticlesContents listBean){
            if(mItemContentfragmentBinding.getItemContentViewModel() == null){
                mItemContentfragmentBinding.setItemContentViewModel(new ItemContentViewModel(listBean,itemView.getContext()));
            }else{
                mItemContentfragmentBinding.getItemContentViewModel().setItemContent(listBean);
            }
        }
    }

    @Override
    public ContentRecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ItemContentfragmentBinding itemContentfragmentBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_contentfragment,parent,false);
        return new ViewHolder(itemContentfragmentBinding);
    }

    @Override
    public void onBindViewHolder(ContentRecycleAdapter.ViewHolder holder, int position) {
        holder.bindItem(mList.get(position));
    }

    @Override
    public int getItemCount() {
        if(null == mList){
            return 0;
        }else{
            return mList.size();
        }
    }
}
