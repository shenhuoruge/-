package com.lei.musicplayer.service;

import java.io.IOException;


public interface IPlayerService {

    void onPlay();

    void stop();

    void onPlayNext() throws IOException;

    void onPlayPrev();

}
