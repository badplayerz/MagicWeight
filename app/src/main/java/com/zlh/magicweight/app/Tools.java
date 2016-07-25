package com.zlh.magicweight.app;

/**
 * Created by sdbean-zlh on 16/6/27.
 */
public class Tools {

    private static long lasttime;

    /**
     * 检查禁止连续点击
     * @return
     */
    public static boolean checkButtonClick(){
        long time = System.currentTimeMillis();
        if(time - lasttime < 500){
            return true;
        }
        lasttime = time;
        return false;
    }
}
