package com.sudhirkhanger.app.photogallery;

import android.os.HandlerThread;
import android.util.Log;

/**
 * Created on 1/19/15 by
 * Sudhir Khanger
 * sudhirkhanger.com
 * github.com/donniezazen
 * 5577 8CDB A059 085D 1D60  807F 8C00 45D9 F5EF C394
 */
public class ThumbnailDownloader<Token> extends HandlerThread {
    private static final String TAG = "ThumbnailDownloader";

    public ThumbnailDownloader() {
        super(TAG);
    }

    public void queueThumbnail(Token token, String url) {
        Log.i(TAG, "Got an URL: " + url);
    }
}
