package com.zlh.magicweight.app;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.magicweight.dao.DaoMaster;
import com.magicweight.dao.DaoSession;
import com.zlh.magicweight.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by sdbean-zlh on 16/7/2.
 */
public class BaseApplication extends Application{

    public static BaseApplication mInstence;
    private static DaoMaster daoMaster;
    private static DaoSession daoSession;

    public static final String DB_NAME = "magicweight.db"; //保存的数据库文件名
    public static final String PACKAGE_NAME = "com.magicweight.activity";
    public static final String DB_PATH = "/data/data/com.zlh.magicweight/databases";

    @Override
    public void onCreate() {
        super.onCreate();
        if(mInstence == null){
            mInstence = this;
        }
    }

    /**
     * 取得DaoMaster
     * @param context        上下文
     * @return               DaoMaster
     */
    public static DaoMaster getDaoMaster(Context context) {

        File dir = new File(DB_PATH);
        if(!dir.exists()) {
            dir.mkdir();
        }
        File file = new File(dir,DB_NAME);

        try {

            if(!file.exists()) {
                file.createNewFile();

                InputStream is = mInstence.getResources().openRawResource(
                        R.raw.magicweight); //欲导入的数据库
                FileOutputStream fos = new FileOutputStream(file);
                byte[] buffere=new byte[is.available()];
                is.read(buffere);
                fos.write(buffere);
                is.close();
                fos.close();
            }

        } catch (FileNotFoundException e) {
            Log.e("Database", "File not found");
            e.printStackTrace();
        } catch (IOException e) {
            Log.e("Database", "IO exception");
            e.printStackTrace();
        }

        if (daoMaster == null) {
            DaoMaster.OpenHelper helper = new DaoMaster.DevOpenHelper(context,DB_PATH + "/" + DB_NAME,null);
            daoMaster = new DaoMaster(helper.getReadableDatabase());
        }
        return daoMaster;
    }

    /**
     * 取得DaoSession
     * @param context        上下文
     * @return               DaoSession
     */
    public static DaoSession getDaoSession(Context context) {
        if (daoSession == null) {
            if (daoMaster == null) {
                daoMaster = getDaoMaster(context);
            }
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }

}
