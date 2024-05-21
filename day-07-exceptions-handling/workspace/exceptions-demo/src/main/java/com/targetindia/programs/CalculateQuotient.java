package com.targetindia.programs;

public class CalculateQuotient {
    public static void main1(String[] args) {
        System.out.println("start of main()");
        String arg1 = args[0];
        String arg2 = args[1];

        int numerator = Integer.parseInt(arg1);
        int denominator = Integer.parseInt(arg2);

        int quotient = numerator / denominator;
        int remainder = numerator % denominator;
        System.out.printf("%d / %d is %d\n", numerator, denominator, quotient);
        System.out.printf("%d %% %d is %d\n", numerator, denominator, remainder);

        System.out.println("end of main()");
    }

    public static void main2(String[] args) {
        System.out.println("start of main()");
        try {
            String arg1 = args[0];
            String arg2 = args[1];

            int numerator = Integer.parseInt(arg1);
            int denominator = Integer.parseInt(arg2);

            int quotient = numerator / denominator;
            int remainder = numerator % denominator;
            System.out.printf("%d / %d is %d\n", numerator, denominator, quotient);
            System.out.printf("%d %% %d is %d\n", numerator, denominator, remainder);
        } catch (Exception e) {
            System.out.printf("there was an error of type \"%s\" with message \"%s\"\n",
                    e.getClass().getName(),
                    e.getMessage());
        }

        System.out.println("end of main()");
    }

    public static void main(String[] args) {
        System.out.println("start of main()");
        try {
            String arg1 = args[0];
            String arg2 = args[1];

            int numerator = Integer.parseInt(arg1);
            int denominator = Integer.parseInt(arg2);

            int quotient = numerator / denominator;
            int remainder = numerator % denominator;
            System.out.printf("%d / %d is %d\n", numerator, denominator, quotient);
            System.out.printf("%d %% %d is %d\n", numerator, denominator, remainder);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("expected 2 arguments but got " + args.length);
            return; // finally is executed
        }
        catch (NumberFormatException e){
            System.out.println("expected only integers");
            System.exit(1); // finally not executed here
        }
        catch (ArithmeticException e){
            System.out.printf("cannot divide %s by zero\n", args[0]);
            throw new RuntimeException(e); // finally is executed
        }
//        catch (Exception e) {
//            System.out.printf("there was an error of type \"%s\" with message \"%s\"\n",
//                    e.getClass().getName(),
//                    e.getMessage());
//        }
        finally {
            System.out.println("doing some cleanup....");
        }

        System.out.println("end of main()");
    }
}
