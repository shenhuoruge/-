package com.lei.musicplayer.http;

import java.io.IOException;


public interface DownloadCallBack {

    void onMusicSuccess() throws IOException;

    void onMusicFail();

}
