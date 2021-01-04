// MyJNI.aidl
package com.luis.luisgoogleproject.jni;

// Declare any non-default types here with import statements

interface MyJNI {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
}