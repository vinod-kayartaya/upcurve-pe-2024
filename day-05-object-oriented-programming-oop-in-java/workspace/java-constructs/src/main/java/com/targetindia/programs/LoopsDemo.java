package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;


public class LoopsDemo {
    public static void main(String[] args) {
        // find the number of days from 1/1/1900
        // for example, 19/7/2010

        // this gap can be divided into 3 sections
        // 1. days in the years between 1900 and 2009 (y-1)
        // 2. days in the year given between the months 1 to 6 (m-1)
        // 3. no.of days spent in the given month/year = 19

        String inputMonth = KeyboardUtil.getString("enter date in d/m/y format: ");
        var arr = inputMonth.split("/"); // ["19", "7", "2010"]
        var d = Integer.parseInt(arr[0]); // 19
        var m = Integer.parseInt(arr[1]); // 7
        var y = Integer.parseInt(arr[2]); // 2010

        var ds = 0;
        for (int i = 1900; i < y; i++) {
            ds += SwitchDemo.isLeap(i) ? 366 : 365; // i is the year from 1900 till y-1
        }
        for (int i = 1; i < m; i++) {
            ds += SwitchDemo.daysIn(i, y);
        }
        ds += d;

        System.out.printf("Date serial is %d\n", ds);

    }
}
