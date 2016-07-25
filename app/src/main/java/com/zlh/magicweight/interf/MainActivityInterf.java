package com.zlh.magicweight.interf;

import com.magicweight.entity.ArticlesContents;

import java.util.ArrayList;

/**
 * Created by sdbean-zlh on 16/5/21.
 */
public interface MainActivityInterf {

    interface MainView extends BaseInterf.MainView{
        void initViewPager(ArrayList<ArticlesContents>... lists);

    }

    interface ViewModel extends BaseInterf.ViewModel{

    }
}
