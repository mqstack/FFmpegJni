package org.mqstack.ffmpegjni;

import android.util.Log;

/**
 * Created by mqstack on 2015/11/23.
 */
public class FFmpegJni {

    static {
        System.loadLibrary("avutil-54");
        System.loadLibrary("swresample-1");
        System.loadLibrary("avcodec-56");
        System.loadLibrary("avformat-56");
        System.loadLibrary("swscale-3");
        System.loadLibrary("avfilter-5");
        System.loadLibrary("avdevice-56");
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
