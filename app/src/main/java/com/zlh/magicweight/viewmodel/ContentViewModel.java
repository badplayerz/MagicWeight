package com.zlh.magicweight.viewmodel;

import android.content.Context;

import com.zlh.magicweight.interf.BaseInterf;
import com.zlh.magicweight.interf.ContentFragmentInterf;

/**
 * Created by sdbean-zlh on 16/7/6.
 */
public class ContentViewModel implements ContentFragmentInterf.ViewModel{
    private ContentFragmentInterf.MainView mContentIntf;
    private Context mContext;

    public ContentViewModel(ContentFragmentInterf.MainView contentIntf, Context context) {
        mContentIntf = contentIntf;
        mContext = context;
    }

    @Override
    public void destory() {

    }
}
