package com.lei.musicplayer.application;


import android.app.Application;
import android.content.Context;


import com.lei.musicplayer.http.HttpClient;
import com.lei.musicplayer.util.ToastTool;
import com.lei.musicplayer.util.Util;


public class MusicApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AppCache.init(this);
        Util.init(this);
        
        ToastTool.init(this);
    }


}
