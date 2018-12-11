package com.utils;

import java.util.List;

public class Utils {

    /**
     * 判断为空(忽视空格)
     *
     * @param str
     * @return true则为空
     */
    public static boolean isEmpty(String str) {
        if (str == null || str.length() == 0||str.equals("null"))
            return true;
        else
            return false;
    }

    /**
     * 判断为空
     *
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null || obj.toString().length() == 0)
            return true;
        else
            return false;
    }

    /**
     * 判断为空
     *
     * @param list
     * @return true则为空
     */
    @SuppressWarnings("unchecked")
    public static boolean isEmpty(List list) {
        if (list == null || list.size() == 0)
            return true;
        else
            return false;
    }
}
