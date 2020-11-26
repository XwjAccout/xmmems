package com.xmmems.common.utils;

public class CustomUtils {
    public static String likeValue(String value){
        return "%"+value+ "%";
    }
    public static String likeRightValue(String value){
        return value+ "%";
    }
    public static String likeLeftValue(String value){
        return "%"+value;
    }
}
