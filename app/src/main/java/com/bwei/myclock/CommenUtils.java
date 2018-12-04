package com.bwei.myclock;

import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gjl on 2018/12/2.
 */

public class CommenUtils {
    //    单利
    private static CommenUtils commenUtils;

    private CommenUtils() {
    }

    public static CommenUtils getCommenUtils() {
        if (commenUtils == null) {
            commenUtils = new CommenUtils();
        }
        return commenUtils;
    }

    //    系统当前时间
    public String getCurrentTime(Context context) {
        String h1 = "";
        String m1 = "";
        String s1 = "";
        Date date = new Date();
//        int year = date.getYear();
        int moth = date.getMonth() + 1;
        int day = date.getDate();
        int h = date.getHours();
        if (h<0){
            h1="0"+h;
        }else {
            h1=h+"";
        }
        int m = date.getMinutes();
        if (m<10){
            m1="0"+m;
        }else {
            m1=m+"";
        }
        int s = date.getSeconds();
        if (s<10){
            s1="0"+s;
        }else {
            s1=s+"";
        }

        String time = moth + "月" + day + "日\r\n" + h1 + ":" + m1 + ":" + s1;

        return time;
    }

}
