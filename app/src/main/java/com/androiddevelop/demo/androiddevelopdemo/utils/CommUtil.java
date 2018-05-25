package com.androiddevelop.demo.androiddevelopdemo.utils;

import android.content.Context;

/**
 * @ Creator     :     chenchao
 * @ CreateDate  :     2018/5/25 0025 17:13
 * @ Description :     AndroidDevelopDemo
 */

public class CommUtil {

    /**
     * @param dpValue
     * @return
     */
    public static int dip2px(Context context, float dpValue){

        final float scale=context.getResources().getDisplayMetrics().density;

        return (int) (dpValue*scale+0.5f);

    }

    /**

     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp

     */

    public static int px2dip(Context context,float pxValue){

        final float scale=context.getResources().getDisplayMetrics().density;

        return (int)(pxValue/scale+0.5f);

    }

}
