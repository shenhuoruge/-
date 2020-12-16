package com.lei.musicplayer;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.support.annotation.VisibleForTesting;
import android.test.ApplicationTestCase;

import com.lei.musicplayer.bean.Music;

import java.util.ArrayList;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {



    public ApplicationTest() {
        super(Application.class);
    }





    public static ArrayList<Music> getMusicFile(Context context) {
        //ArrayList<Music>存放音乐
        ArrayList<Music> MusicFiles = new ArrayList<>();
        //查询媒体数据库
        ContentResolver resolver = context.getContentResolver();
        /**
         * Uri：这个Uri代表要查询的数据库名称加上表的名称。
         这个Uri一般都直接从MediaStore里取得，例如我要取所有歌的信息，
         就必须利用MediaStore.Audio.Media. EXTERNAL _CONTENT_URI这个Uri。
         *
         */
        Cursor cursor = resolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                null, null, null, MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
        System.out.println(cursor.getCount());
        //遍历媒体数据库
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {

                //歌曲编号MediaStore.Audio.Media._ID
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID));

                //歌曲标题
                String title = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE));

                //歌曲的专辑名MediaStore.Audio.Media.ALBUM
                String album = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM));

                //歌曲的歌手名MediaStore.Audio.Media.ARTIST
                String artist = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST));

                //歌曲文件的路径MediaStore.Audio.Media.DATA
                String url = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));

                //歌曲的总播放时长MediaStore.Audio.Media.DURATION
                int duration = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION));

                //歌曲文件的大小MediaStore.Audio.Media.SIZE
                long size = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.SIZE));

                if (size > 1024 * 800) {     //是否大于800K
                    if (title.equals("<unknown>") || title.equals("")) {
                        title = "未知";
                    }
                    if ("<unknown>".equals(artist) || "".equals(artist)) {
                        artist = "未知";
                    }

                }
                cursor.moveToNext();
            }
        }
        return MusicFiles;
    }
}