package com.magicweight.dao;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.magicweight.entity.ArticlesContents;
import com.magicweight.entity.ArticlesRecommend;

import com.magicweight.dao.ArticlesContentsDao;
import com.magicweight.dao.ArticlesRecommendDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig articlesContentsDaoConfig;
    private final DaoConfig articlesRecommendDaoConfig;

    private final ArticlesContentsDao articlesContentsDao;
    private final ArticlesRecommendDao articlesRecommendDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        articlesContentsDaoConfig = daoConfigMap.get(ArticlesContentsDao.class).clone();
        articlesContentsDaoConfig.initIdentityScope(type);

        articlesRecommendDaoConfig = daoConfigMap.get(ArticlesRecommendDao.class).clone();
        articlesRecommendDaoConfig.initIdentityScope(type);

        articlesContentsDao = new ArticlesContentsDao(articlesContentsDaoConfig, this);
        articlesRecommendDao = new ArticlesRecommendDao(articlesRecommendDaoConfig, this);

        registerDao(ArticlesContents.class, articlesContentsDao);
        registerDao(ArticlesRecommend.class, articlesRecommendDao);
    }
    
    public void clear() {
        articlesContentsDaoConfig.getIdentityScope().clear();
        articlesRecommendDaoConfig.getIdentityScope().clear();
    }

    public ArticlesContentsDao getArticlesContentsDao() {
        return articlesContentsDao;
    }

    public ArticlesRecommendDao getArticlesRecommendDao() {
        return articlesRecommendDao;
    }

}
