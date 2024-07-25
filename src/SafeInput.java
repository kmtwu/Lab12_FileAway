import java.util.Scanner;
public class SafeInput {
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";
        do
        {
            System.out.println("\n"+ prompt + ": ");
            retString = pipe.nextLine();
        }while(retString.length() == 0);

        return retString;

    }

    public static int getInt(Scanner pipe, String prompt) {
        int ReturnValue = 0;
        boolean YorN;
        do {
            System.out.println("\n" + prompt + ":");
            if (pipe.hasNextInt()) {
                ReturnValue = pipe.nextInt();
                pipe.nextLine();
                YorN = true;
            } else {
                System.out.println("Invalid input!");
                pipe.nextLine();
                YorN = false;
            }
        } while (!YorN);
        return ReturnValue;
    }

    public static double getDouble(Scanner pipe, String prompt) {
        double ReturnValue = 0;
        boolean YorN;
        do {
            System.out.println("\n" + prompt + ":");
            if (pipe.hasNextDouble()) {
                ReturnValue = pipe.nextDouble();
                pipe.nextLine();
                YorN = true;
            } else {
                System.out.println("Invalid input!");
                pipe.nextLine();
                YorN = false;
            }
        } while (!YorN);
        return ReturnValue;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int ReturnValue = 0;
        boolean YorN;
        do {
            System.out.println("\n" + prompt + ":");
            if (pipe.hasNextInt()) {
                ReturnValue = pipe.nextInt();
                if (ReturnValue >= low) {
                    if (ReturnValue <= high) {
                        YorN = true;
                    }
                    else {
                        System.out.println("Invalid input!");
                        pipe.nextLine();
                        YorN = false;
                    }
                }
                else {
                    System.out.println("Invalid input!");
                    pipe.nextLine();
                    YorN = false;
                }
            } else {
                System.out.println("Invalid input!");
                pipe.nextLine();
                YorN = false;
            }
        } while (!YorN);
        return ReturnValue;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double ReturnValue = 0;
        boolean YorN;
        do {
            System.out.println("\n" + prompt + ":");
            if (pipe.hasNextDouble()) {
                ReturnValue = pipe.nextDouble();
                if (ReturnValue >= low) {
                    if (ReturnValue <= high) {
                        YorN = true;
                    }
                    else {
                        System.out.println("Invalid input!");
                        pipe.nextLine();
                        YorN = false;
                    }
                }
                else {
                    System.out.println("Invalid input!");
                    pipe.nextLine();
                    YorN = false;
                }
            } else {
                System.out.println("Invalid input!");
                pipe.nextLine();
                YorN = false;
            }
        } while (!YorN);
        return ReturnValue;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean ReturnValue = true;
        boolean YorN;
        String input;
        do {
            System.out.println("\n" + prompt + ":");
            input = pipe.next();
            if (input.equals("Y")) {
                ReturnValue = true;
                YorN = true;
                pipe.nextLine();
            }
            else if (input.equals("y")) {
                ReturnValue = true;
                YorN = true;
                pipe.nextLine();
            }
            else if (input.equals("N")) {
                ReturnValue = false;
                YorN = true;
                pipe.nextLine();
            }
            else if (input.equals("n")) {
                ReturnValue = false;
                YorN = true;
                pipe.nextLine();
            }
            else {
                System.out.println("Invalid input!");
                YorN = false;
                pipe.nextLine();
            }
        } while (!YorN);
        return ReturnValue;
    }
    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String ReturnValue = "";
        boolean YorN = false;
        do {
            System.out.println("\n" + prompt + ":");
            ReturnValue = pipe.next();
            if (ReturnValue.matches(regEx)) {
                YorN = true;
            }
            else {
                System.out.println("Invalid input!");
            }
        } while(!YorN);
        return ReturnValue;
    }
    public static void prettyHeader(String msg) {
        int i;
        int j;
        int length = msg.length();
        for (i = 1; i <= 60; i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.print("***");
        if (length % 2 == 1) {
            for (j = 1; j <= (26 - length / 2); j++) {
                System.out.print(" ");
            }
            System.out.print(msg);
            for (j = 1; j <= (27 - length / 2); j++) {
                System.out.print(" ");
            }
            System.out.print("***" + "\n");
        }
        else {
            for (j = 1; j <= (27 - length / 2); j++) {
                System.out.print(" ");
            }
            System.out.print(msg);
            for (j = 1; j <= (27 - length / 2); j++) {
                System.out.print(" ");
            }
            System.out.print("***" + "\n");
        }
        for (i = 1; i <= 60; i++) {
            System.out.print("*");
        }
    }
    public static double CtoF(double Celsius) {
        double returnValue;
        returnValue = (Celsius * 1.8) + 32;
        return returnValue;
    }
}
