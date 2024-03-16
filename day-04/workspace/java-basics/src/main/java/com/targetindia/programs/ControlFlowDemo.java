package com.targetindia.programs;


public class ControlFlowDemo {

    static int daysInMonth(int month) {

        if(month<1 || month>12){
            throw new IllegalArgumentException("invalid value was supplied.");
        }

        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        if (month == 2) {
            return 28;
        }
        return 31;
    }


    static int square(int num) {
        System.out.println("square was called with " + num);
        return num * num;
    }

    static boolean isEven(int num) {
        /*
        if (num % 2 == 0) {
            return true;
        } else {
            return false;
        }
        */
        /*
        if (num % 2 == 0) {
            return true;
        }
        return false;
        */

        return num % 2 == 0;
    }


    public static void main(String[] args) {
        System.out.println("control flow demo");

        // ControlFlowDemo cfd = new ControlFlowDemo();
        var n = 1230;
        var sq = square(n);  // ControlFlowDemo.square(n);

        var sroot = Math.sqrt(n);

        System.out.printf("square of %d is %d\n", n, sq);
        System.out.printf("square root of %d is %f\n", n, sroot);

        if (isEven(n)) {
            System.out.printf("%d is an even number\n", n);
        } else {
            System.out.printf("%d is an odd number\n", n);
        }

        var m = 91;
        var days = daysInMonth(m);
        System.out.printf("the month %d has %d days\n", m, days);

        System.out.println("end of main().");
    }
}
