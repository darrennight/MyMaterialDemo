package com.meterial.demo;

import android.app.Application;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatDelegate;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.listener.RequestLoggingListener;
import com.meterial.demo.commonActivity.supportBottom.AppConstants;
import com.wuxiaolong.androidutils.library.LogUtil;
import com.wuxiaolong.androidutils.library.SharedPreferencesUtil;
import java.util.HashSet;
import java.util.Set;

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
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }


    @Override public void onCreate() {
        super.onCreate();

        Set<RequestListener> requestListeners = new HashSet<>();
        requestListeners.add(new RequestLoggingListener());
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                // other setters
                .setRequestListeners(requestListeners)
                .build();
        Fresco.initialize(this, config);
        FLog.setMinimumLoggingLevel(FLog.VERBOSE);
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
