buildscript {
    repositories {
        maven { url = uri("https://maven.aliyun.com/repository/central") }
        google()
    }

    dependencies {
        //用于构建出apk/aar的插件
        //https://developer.android.google.cn/studio/releases/gradle-plugin
        classpath("com.android.tools.build:gradle:8.13.2")

        //用于编译Kotlin代码的插件
        //http://kotlinlang.org/docs/reference/using-gradle.html
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:2.3.21")
    }
}