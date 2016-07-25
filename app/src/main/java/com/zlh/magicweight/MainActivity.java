package com.zlh.magicweight;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.magicweight.entity.ArticlesContents;
import com.umeng.analytics.MobclickAgent;
import com.yyydjk.library.BannerLayout;
import com.zlh.magicweight.Db.DbHelper;
import com.zlh.magicweight.adapter.MainViewPagerAdapter;
import com.zlh.magicweight.databinding.ActivityMainBinding;
import com.zlh.magicweight.interf.MainActivityInterf;
import com.zlh.magicweight.view.BaseActivity;
import com.zlh.magicweight.view.ContentFragment;
import com.zlh.magicweight.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements MainActivityInterf.MainView{

    private ActivityMainBinding activityMainBinding;
    private MainViewModel mainViewModel;
    private TabLayout mTabLayout;
    private MainViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MobclickAgent.enableEncrypt(true);//6.0.0版本及以后
        initDataBinding();
        initView();

    }

    private void initDataBinding(){
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainViewModel = new MainViewModel(this,getContext());
        activityMainBinding.setMainViewModel(mainViewModel);
        setSupportActionBar(activityMainBinding.toolbar);
    }

    private void initView(){

        mainViewModel.postData();
        activityMainBinding.header.setViewRes(mainViewModel.getBannerList());
        activityMainBinding.header.setOnBannerItemClickListener(mainViewModel.bannerItemClick());

    }

    @Override
    public void initViewPager(ArrayList<ArticlesContents>... lists) {

        mTabLayout = activityMainBinding.tabs;
        mTabLayout.addTab(mTabLayout.newTab().setText("瘦身文章"));//给TabLayout添加Tab
        mTabLayout.addTab(mTabLayout.newTab().setText("训练心得"));
        mTabLayout.addTab(mTabLayout.newTab().setText("show秀场"));

        adapter = new MainViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(ContentFragment.newInstance(lists[0]),"瘦身文章");
        adapter.addFragment(ContentFragment.newInstance(lists[1]),"训练心得");
        adapter.addFragment(ContentFragment.newInstance(lists[2]),"show秀场");
        activityMainBinding.viewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(activityMainBinding.viewPager);
    }

    @Override
    public Context getContext() {
        return MainActivity.this;
    }



//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
