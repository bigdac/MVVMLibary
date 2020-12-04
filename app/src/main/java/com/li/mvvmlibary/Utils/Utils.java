package com.li.mvvmlibary.Utils;

import android.app.Application;
import android.util.Log;

import java.lang.reflect.Method;

/**
 * @author 版本：1.0
 * 创建日期：2020-12-04 09
 * 描述：
 */
public class Utils {
    public static Application getCurApplication(){
        Application application = null;
        try{
            Class atClass = Class.forName("android.app.ActivityThread");
            Method currentApplicationMethod = atClass.getDeclaredMethod("currentApplication");
            currentApplicationMethod.setAccessible(true);
            application = (Application) currentApplicationMethod.invoke(null);
            Log.d("fw_create","curApp class1:"+application);
        }catch (Exception e){
            Log.d("fw_create","e:"+e.toString());
        }

        if(application != null)
            return application;

        try{
            Class atClass = Class.forName("android.app.AppGlobals");
            Method currentApplicationMethod = atClass.getDeclaredMethod("getInitialApplication");
            currentApplicationMethod.setAccessible(true);
            application = (Application) currentApplicationMethod.invoke(null);
            Log.d("fw_create","curApp class2:"+application);
        }catch (Exception e){
            Log.d("fw_create","e:"+e.toString());
        }

        return application;
    }
}
