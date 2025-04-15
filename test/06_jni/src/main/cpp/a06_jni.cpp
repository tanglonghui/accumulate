#include <jni.h>

// Write C++ code here.
//
// Do not forget to dynamically load the C++ library into your application.
//
// For instance,
//
// In MainActivity.java:
//    static {
//       System.loadLibrary("a06_jni");
//    }
//
// Or, in MainActivity.kt:
//    companion object {
//      init {
//         System.loadLibrary("a06_jni")
//      }
//    }
extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_a06_1jni_MainActivity_makeMsg(JNIEnv *env, jobject thiz) {
    // TODO: implement makeMsg()
    char a[10] = {""};
    jstring ret = env->NewStringUTF("hello world");
    return ret;
}