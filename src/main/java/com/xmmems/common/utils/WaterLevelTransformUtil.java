package com.xmmems.common.utils;

/**
 * @描述
 * @创建人 ithxw
 * @创建时间 2020.10.15 16:20
 */
public class WaterLevelTransformUtil {
    //字符串等级转换为数字
    public static int levelStringToLevelInt(String level){
        switch (level) {
            case "I":return 1;
            case "II":return 2;
            case "III":return 3;
            case "IV":return 4;
            case "V":return 5;
            case "劣V":return 6;
            default:return -1;
        }
    }
    //数字转换为字符串等级
    public static String levelIntToLevelString(int level){
        switch (level) {
            case 1:return "I";
            case 2:return "II";
            case 3:return "III";
            case 4:return "IV";
            case 5:return "V";
            case 6:return "劣V";
            default:return "-";
        }
    }
    //true level1 等级大于 level2  ,false level1 小于或等于 level2
    public static boolean compare(String level1,String level2){
        int i1 = levelStringToLevelInt(level1);
        int i2 = levelStringToLevelInt(level2);
        return i1>i2;
    }
    //true level1 等级大于 level2  ,false level1 小于或等于 level2
    public static boolean compare(String level1,int level2){
        int i1 = levelStringToLevelInt(level1);
        return i1>level2;
    }
    //true level1 等级大于 level2  ,false level1 小于或等于 level2
    public static boolean compare(int level1,String level2){
        int i2 = levelStringToLevelInt(level2);
        return level1 > i2;
    }
    //true level1 等级大于 level2  ,false level1 小于或等于 level2
    public static boolean compare(int level1,int level2){
        return level1>level2;
    }


}
