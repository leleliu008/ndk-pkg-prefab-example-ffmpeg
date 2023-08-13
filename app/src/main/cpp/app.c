#include <stdio.h>

#include <libavformat/avformat.h>
#include <libavutil/dict.h>

#include"app.h"

#include<android/log.h>

#define TAG "app.cpp"

#define LOGV(...) __android_log_print(ANDROID_LOG_VERBOSE, TAG, __VA_ARGS__);
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG,   TAG, __VA_ARGS__);
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO,    TAG, __VA_ARGS__);
#define LOGW(...) __android_log_print(ANDROID_LOG_WARN,    TAG, __VA_ARGS__);
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR,   TAG, __VA_ARGS__);
#define LOGF(...) __android_log_print(ANDROID_LOG_FATAL,   TAG, __VA_ARGS__);

JNIEXPORT jint JNICALL Java_com_fpliu_android_ndk_pkg_prefab_example_ffmpeg_MainActivity_test(JNIEnv *env, jobject obj) {
    // https://ffmpeg.org/doxygen/trunk/show_metadata_8c-example.html

    AVFormatContext *fmt_ctx = NULL;

    const AVDictionaryEntry *tag = NULL;

    int ret;

    if ((ret = avformat_open_input(&fmt_ctx, "a.mp4", NULL, NULL))) {
        LOGW( "Cannot open a.mp4")
        return ret;
    }

    if ((ret = avformat_find_stream_info(fmt_ctx, NULL)) < 0) {
        LOGW( "Cannot find stream information")
        return ret;
    }

    while ((tag = av_dict_iterate(fmt_ctx->metadata, tag)))
        LOGI("%s=%s\n", tag->key, tag->value)

    avformat_close_input(&fmt_ctx);

    return 0;
}
