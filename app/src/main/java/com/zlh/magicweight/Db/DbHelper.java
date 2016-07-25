package com.zlh.magicweight.Db;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.magicweight.dao.ArticlesContentsDao;
import com.magicweight.dao.ArticlesRecommendDao;
import com.magicweight.dao.DaoSession;
import com.magicweight.entity.ArticlesContents;
import com.magicweight.entity.ArticlesRecommend;
import com.zlh.magicweight.app.BaseApplication;

import java.util.List;

/**
 * Created by sdbean-zlh on 16/7/2.
 */
public class DbHelper {

    private static final String TAG = DbHelper.class.getSimpleName();
    private static DbHelper instance;
    private static Context appContext;
    private DaoSession mDaoSession;
    private ArticlesContentsDao mArticlesContentsDao;
    private ArticlesRecommendDao mArticlesRecommendDao;

    private DbHelper(){}


    /**
     * 采用单例模式
     * @param context     上下文
     * @return            dbservice
     */
    public static DbHelper getInstance(Context context) {

        DbHelper dbHelper = instance;
        if (dbHelper == null) {
            synchronized (DbHelper.class){
                dbHelper = instance;
                if(dbHelper == null){
                    dbHelper = new DbHelper();
                    if (appContext == null){
                        appContext = context.getApplicationContext();
                    }
                    dbHelper.mDaoSession = BaseApplication.getDaoSession(context);
                    dbHelper.mArticlesContentsDao = dbHelper.mDaoSession.getArticlesContentsDao();
                    dbHelper.mArticlesRecommendDao = dbHelper.mDaoSession.getArticlesRecommendDao();
                    instance = dbHelper;
                }
            }

        }
        return dbHelper;
    }

    /**
     * 按条件查询
     * @param className List泛型需要的ClassName
     * @param where 查询条件
     * @param params    参数内容
     * @return
     */
//    public List<?> queryContents(String className,String where, String... params){
//
//
//        if(className == ArticlesContents.class.getName()){
//            List<ArticlesContents> list = mArticlesContentsDao.queryRaw(where, params);
//            return list;
//        }else if(className == ArticlesRecommend.class.getName()){
//            List<ArticlesRecommend> list = mArticlesRecommendDao.queryRaw(where, params);
//            return list;
//        }
//
//    return null;
//    }

    public List<ArticlesContents> queryContents(String className,String where, String... params){


        List<ArticlesContents> list = mArticlesContentsDao.queryRaw(where, params);
        return list;
    }

//    /**
//     * 根据用户id,取出用户信息
//     * @param id           用户id
//     * @return             用户信息
//     */
//    public ArticlesContents loadNote(long id) {
//        if(!TextUtils.isEmpty(id + "")) {
//            return mArticlesContentsDao.load(id);
//        }
//        return  null;
//    }
//
//    /**
//     * 取出所有数据
//     * @return      所有数据信息
//     */
//    public List<ArticlesContents> loadAllNote(){
//        return mArticlesContentsDao.loadAll();
//    }
//
//    /**
//     * 生成按id倒排序的列表
//     * @return      倒排数据
//     */
//    public List<ArticlesContents> loadAllNoteByOrder()
//    {
//        return mArticlesContentsDao.queryBuilder().orderDesc(ArticlesContentsDao.Properties.Id).list();
//    }
//
//    /**
//     * 根据查询条件,返回数据列表
//     * @param where        条件
//     * @param params       参数
//     * @return             数据列表
//     */
//    public List<ArticlesContents> queryNote(String where, String... params){
//        return mArticlesContentsDao.queryRaw(where, params);
//    }
//
//        /**
//     * 根据用户信息,插件或修改信息
//     * @param user              用户信息
//     * @return 插件或修改的用户id
//     */
//    public long saveNote(ArticlesContents user){
//        return mArticlesContentsDao.insertOrReplace(user);
//    }
//
//
//    /**
//     * 批量插入或修改用户信息
//     * @param list      用户信息列表
//     */
//    public void saveNoteLists(final List<ArticlesContents> list){
//        if(list == null || list.isEmpty()){
//            return;
//        }
//        mArticlesContentsDao.getSession().runInTx(new Runnable() {
//            @Override
//            public void run() {
//                for(int i=0; i<list.size(); i++){
//                    ArticlesContents user = list.get(i);
//                    mArticlesContentsDao.insertOrReplace(user);
//                }
//            }
//        });
//
//    }
//
//    /**
//     * 删除所有数据
//     */
//    public void deleteAllNote(){
//        mArticlesContentsDao.deleteAll();
//    }
//
//    /**
//     * 根据id,删除数据
//     * @param id      用户id
//     */
//    public void deleteNote(long id){
//        mArticlesContentsDao.deleteByKey(id);
//        Log.i(TAG, "delete");
//    }
//
//    /**
//     * 根据用户类,删除信息
//     * @param user    用户信息类
//     */
//    public void deleteNote(ArticlesContents user){
//        mArticlesContentsDao.delete(user);
//    }
}
