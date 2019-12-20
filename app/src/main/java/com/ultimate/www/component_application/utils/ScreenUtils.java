package com.ultimate.www.component_application.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * @author 李宝
 * @date 2019/12/20
 * @Describe 屏幕工具
 */
public class ScreenUtils {

    /**
     * 屏幕尺寸
     * @param context
     * @return DisplayMetrics
     */
    public static DisplayMetrics getScreenMetrics(Activity context) {
        DisplayMetrics dm = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm;
    }

    /**
     * 屏幕宽度 如果1080
     * @param context
     * @return 1080
     */
    public static int getScreenWidth(Activity context) {
        return getScreenMetrics(context).widthPixels;
    }

    /**
     * 屏幕高度 如果1920
     * @param context
     * @return 1920
     */
    public static int getScreenHeight(Activity context) {
        return getScreenMetrics(context).heightPixels;
    }


    /**
     * 屏幕密度DPI（120 / 160 / 240）
     * @param context
     * @return
     */
    public static int getDensityDip(Activity context) {
        return getScreenMetrics(context).densityDpi;
    }


    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     * @param dpValue
     * @return
     */
    public static int dip2px(float dpValue) {
        Resources r = Resources.getSystem();
        final float scale = r.getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
