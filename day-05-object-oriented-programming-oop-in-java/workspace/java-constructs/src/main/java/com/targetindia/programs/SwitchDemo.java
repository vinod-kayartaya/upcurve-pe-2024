package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;

public class SwitchDemo {

    static boolean isLeap(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    static int daysIn(int month, int year) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("month must be between 1 and 12");
        }
        if (year < 1) {
            throw new IllegalArgumentException("year must be >= 1");
        }

        switch (month) {
            case 2:
                return isLeap(year) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
        }

        return 31;
    }

    public static void main(String[] args) {

        var name = KeyboardUtil.getString("enter your name: ");
        System.out.printf("Hello, %s\n", name);
        int m = KeyboardUtil.getInt("enter a value for month: ");
        int y = KeyboardUtil.getInt("enter a value for year: ");
        int days = daysIn(m, y);

        System.out.printf("there are %d days in month %d of year %d\n", days, m, y);
    }
}
