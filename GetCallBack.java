package com.lei.musicplayer.http;


public interface GetCallBack<T> {

    void onSuccess(T response);

    void onFail(Throwable t);

}
