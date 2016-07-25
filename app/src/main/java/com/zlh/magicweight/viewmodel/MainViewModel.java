package com.zlh.magicweight.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;

import com.magicweight.entity.ArticlesContents;
import com.yyydjk.library.BannerLayout;
import com.zlh.magicweight.Db.DbHelper;
import com.zlh.magicweight.R;
import com.zlh.magicweight.app.Tools;
import com.zlh.magicweight.interf.MainActivityInterf;
import com.zlh.magicweight.view.ContentWebActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.observables.GroupedObservable;

/**
 * Created by sdbean-zlh on 16/7/5.
 */
public class MainViewModel implements MainActivityInterf.ViewModel{
    private DbHelper dbHelper;
    private MainActivityInterf.MainView mMainInterf;
    private Context mContext;
    private ArrayList<ArticlesContents> onewList;
    private ArrayList<ArticlesContents> twowList;
    private ArrayList<ArticlesContents> threewList;


    public MainViewModel(MainActivityInterf.MainView mainInterf,Context context) {
        mMainInterf = mainInterf;
        mContext = context;
    }


    public void postData(){
        dbHelper = DbHelper.getInstance(mContext);
        List<ArticlesContents> list = dbHelper.queryContents(ArticlesContents.class.getName(),"",new String[]{});
        Log.e("asdasd", ""+list.size());
        onewList = new ArrayList<ArticlesContents>();
        twowList = new ArrayList<ArticlesContents>();
        threewList = new ArrayList<ArticlesContents>();

        for (ArticlesContents articlesContents:list){
            switch (articlesContents.getType()){
                case "1":
                    onewList.add(articlesContents);
                    break;
                case "2":
                    twowList.add(articlesContents);
                    break;
                case "3":
                    threewList.add(articlesContents);
                    break;
            }
        }

        mMainInterf.initViewPager(new ArrayList[]{onewList,twowList,threewList});



//        Observable.from(list).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<ArticlesContents>() {
//            @Override
//            public void call(ArticlesContents articlesContents) {
//                switch (articlesContents.getType()){
//                    case "1":
//                        onewList.add(articlesContents);
//                        break;
//                    case "2":
//                        twowList.add(articlesContents);
//                        break;
//                    case "3":
//                        threewList.add(articlesContents);
//                        break;
//                }
//
//                mMainInterf.initViewPager(new ArrayList[]{onewList,twowList,threewList});
//                onewList = null;
//                twowList = null;
//                threewList = null;
//            }
//        });

    }


    public List<Integer> getBannerList(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(R.drawable.image_index_one);
        list.add(R.drawable.image_index_two);
        list.add(R.drawable.image_index_three);
        list.add(R.drawable.image_index_four);
        return list;
    }

    public BannerLayout.OnBannerItemClickListener bannerItemClick(){
        BannerLayout.OnBannerItemClickListener clickListener = new BannerLayout.OnBannerItemClickListener() {
            @Override
            public void onItemClick(int i) {
                String strUrl = "";
                switch (i){
                    case 0:
                        strUrl = onewList.get(0).getUrl();
                        break;
                    case 1:
                        strUrl = onewList.get(4).getUrl();
                        break;
                    case 2:
                        strUrl = onewList.get(6).getUrl();
                        break;
                    case 3:
                        strUrl = onewList.get(7).getUrl();
                        break;
                }

                Intent intent = new Intent();
                intent.putExtra("webUrl",strUrl);
                intent.setClass(mContext,ContentWebActivity.class);
                mContext.startActivity(intent);
            }
        };
        return clickListener;
    }

    /**
     * fab按钮事件
     * @param view
     */
    public void onClickFabLoad(View view) {
        if(Tools.checkButtonClick()) return;
        Snackbar.make(view, "It is a fab button", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public void destory() {

    }
}
