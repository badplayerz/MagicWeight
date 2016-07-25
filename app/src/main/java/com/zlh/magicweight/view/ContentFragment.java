package com.zlh.magicweight.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.magicweight.entity.ArticlesContents;
import com.zlh.magicweight.R;
import com.zlh.magicweight.adapter.ContentRecycleAdapter;
import com.zlh.magicweight.databinding.FragmentContentBinding;
import com.zlh.magicweight.interf.ContentFragmentInterf;
import com.zlh.magicweight.viewmodel.ContentViewModel;

import java.util.ArrayList;
import java.util.List;


public class ContentFragment extends Fragment implements ContentFragmentInterf.MainView{

    private static final String CONTENT_LIST = "contentList";

    private ArrayList<ArticlesContents> mList;

    private FragmentContentBinding fragmentContentBinding;
    private ContentViewModel contentViewModel;
    private ContentRecycleAdapter contentRecycleAdapter;

    public ContentFragment() {
        // Required empty public constructor
    }


    public static ContentFragment newInstance(ArrayList<ArticlesContents> list) {
        ContentFragment fragment = new ContentFragment();
        Bundle args = new Bundle();
        args.putSerializable(CONTENT_LIST,list);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mList = (ArrayList<ArticlesContents>)getArguments().getSerializable(CONTENT_LIST);
            contentViewModel = new ContentViewModel(this,getContext());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        fragmentContentBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_content,container,false);

        contentRecycleAdapter = new ContentRecycleAdapter(mList);
        fragmentContentBinding.contentRecyclerview.setAdapter(contentRecycleAdapter);
        fragmentContentBinding.contentRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));

        return fragmentContentBinding.getRoot();
    }



    @Override
    public void onDetach() {
        super.onDetach();
    }


}
