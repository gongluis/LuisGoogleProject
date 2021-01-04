//
// Created by luis.gong on 2020/12/17.
//
#include <stdio.h>
#include <stdlib.h>
#include <jni.h>

jstring Java_com_luis_luisgoogleproject_JNI_sayHello(JNIEnv *env, jobject jobj){
    char *text = "I am from c";
    return (*env)->NewStringUTF(env, text);
}