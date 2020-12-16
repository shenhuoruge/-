package com.lei.musicplayer.service;


public interface OnPlayMusicListener {

    void onMusicPlay();

    void onMusicCurrentPosition(int currentPosition);

    void onMusicStop();

    void onMusicComplete();

}
