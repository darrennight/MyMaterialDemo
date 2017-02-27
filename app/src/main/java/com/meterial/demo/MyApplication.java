package com.meterial.demo;

import android.app.Application;
import android.support.v4.util.Pair;

/**
 * TODO
 *
 * @author zenghao
 * @since 17/2/25 下午5:51
 */
public class MyApplication extends Application implements ILottieApplication{

    private int droppedFrames;
    private long droppedFramesStartingNs;
    private long currentFrameNs;

    @Override public void onCreate() {
        super.onCreate();

    }

    @Override public void startRecordingDroppedFrames() {
        droppedFrames = 0;
        droppedFramesStartingNs = currentFrameNs;
    }

    @Override public Pair<Integer, Long> stopRecordingDroppedFrames() {
        long duration = currentFrameNs - droppedFramesStartingNs;
        Pair<Integer, Long> ret = new Pair<>(droppedFrames, duration);
        droppedFrames = 0;
        return ret;
    }
}
