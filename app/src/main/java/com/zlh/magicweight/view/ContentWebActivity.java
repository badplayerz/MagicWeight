package com.zlh.magicweight.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.zlh.magicweight.R;
import com.zlh.magicweight.databinding.ActivityContentWebBinding;
import com.zlh.magicweight.interf.ContentWebInterf;
import com.zlh.magicweight.viewmodel.ContentWebViewModel;

public class ContentWebActivity extends BaseActivity implements ContentWebInterf.MainView{
    private ActivityContentWebBinding activityContentWebBinding;
    private ContentWebViewModel contentWebViewModel;
    private String strWebUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        strWebUrl = getIntent().getStringExtra("webUrl");
        if(null != strWebUrl && !"".equals(strWebUrl)){
            strWebUrl = "file:///android_asset/"+strWebUrl+".html";
        }
        initBinding();

    }

    private void initBinding(){
        activityContentWebBinding = DataBindingUtil.setContentView(this,R.layout.activity_content_web);
        contentWebViewModel = new ContentWebViewModel(strWebUrl);
        activityContentWebBinding.setContentWebViewModel(contentWebViewModel);
        setSupportActionBar(activityContentWebBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home)
        {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public Context getContext() {
        return ContentWebActivity.this;
    }
}
