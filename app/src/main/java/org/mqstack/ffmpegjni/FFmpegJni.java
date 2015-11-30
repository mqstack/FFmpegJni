package org.mqstack.ffmpegjni;

import android.util.Log;

/**
 * Created by mqstack on 2015/11/23.
 */
public class FFmpegJni {

    static {
        System.loadLibrary("avutil");
        System.loadLibrary("swresample");
        System.loadLibrary("avcodec");
        System.loadLibrary("avformat");
        System.loadLibrary("swscale");
        System.loadLibrary("avfilter");
        System.loadLibrary("avdevice");
        System.loadLibrary("ffmpegjni");
    }

    public int ffmpegRunCommand(String command) {
        if (command.isEmpty()) {
            return 1;
        }
        String[] args = command.split(" ");
        for (int i = 0; i < args.length; i++) {
            Log.d("ffmpeg-jni", args[i]);

        }
        return run(args.length, args);
    }

    public native int run(int argc, String[] args);
}
