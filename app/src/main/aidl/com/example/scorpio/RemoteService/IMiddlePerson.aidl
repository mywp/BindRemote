// IMiddlePerson.aidl
package com.example.scorpio.RemoteService;

// Declare any non-default types here with import statements

interface IMiddlePerson {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
     void callMethodInService();
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
}
