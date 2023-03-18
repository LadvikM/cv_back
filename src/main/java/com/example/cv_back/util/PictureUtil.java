package com.example.cv_back.util;

public class PictureUtil {
    public static String byteArrayToString(byte[] byteArray) {
        if (byteArray == null) {
            return null;
        } else {
            return new String(byteArray);
        }
    }
}