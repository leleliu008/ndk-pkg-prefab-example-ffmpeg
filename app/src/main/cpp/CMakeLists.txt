cmake_minimum_required(VERSION 3.14)

project(app C)

add_library(app SHARED app.c)

find_package (ffmpeg REQUIRED CONFIG)
target_link_libraries(app ffmpeg::libavformat.so)
target_link_libraries(app ffmpeg::libavcodec.so)
target_link_libraries(app ffmpeg::libavutil.so)
target_link_libraries(app ffmpeg::libswresample.so)

target_link_libraries(app -llog)