package com.zlh.magicweight.viewmodel;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.os.Build;
import android.os.Bundle;
import android.transition.ChangeTransform;
import android.transition.Transition;
import android.util.Pair;
import android.view.View;

import com.magicweight.entity.ArticlesContents;
import com.zlh.magicweight.interf.ContentFragmentInterf;
import com.zlh.magicweight.view.ContentWebActivity;

/**
 * Created by sdbean-zlh on 16/7/6.
 */
public class ItemContentViewModel extends BaseObservable implements ContentFragmentInterf.ViewModel{

    private ArticlesContents itemBean;
    private Context mContext;

    public String title;
    public String url;

    public String getTitle() {
        return itemBean.getName();
    }

    public String getUrl() {
        return itemBean.getUrl();
    }

    public ItemContentViewModel(ArticlesContents articlesContents, Context context) {
        itemBean = articlesContents;
        mContext = context;
    }

    /**
     * item点击事件
     * @param view
     */
    public void itemonclick(View view){

        Intent intent = new Intent();
        intent.putExtra("webUrl",getUrl());
        intent.setClass(view.getContext(),ContentWebActivity.class);
        mContext.startActivity(intent);
    }

    public void setItemContent(ArticlesContents listBean){
        itemBean = listBean;
        notifyChange();
    }

    @Override
    public void destory() {

    }
}
