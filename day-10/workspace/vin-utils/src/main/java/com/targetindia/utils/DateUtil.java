package com.targetindia.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtil {
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

    private DateUtil() {
    }

    public static String fromDate(Date date) {
        if (date == null) {
            return "";
        }
        return SDF.format(date);
    }

    public static Date fromString(String strDate) {
        try {
            return SDF.parse(strDate);
        } catch (ParseException e) {
            return null;
        }
    }
}
