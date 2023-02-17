package lambdalesson01;

public class Util {
    public static void printWithSpace(Object a){
        System.out.print(a+" ");
    }
    public static boolean isEven(Integer a){
        return a%2==0;
    }
    public static boolean isOdd(Integer a){
        return a%2!=0;
    }
    public static Integer getSquare(int x){
        return x*x;
    }
    public static Integer getCube(int x){
        return x*x*x;
    }
    public static boolean getGreaterThanSeven(int x){
        return x%2==0&&x>7;
    }
    public static double getHalf(int a){
        return a/2.0;
    }
    public static char getLastChar(String a){
        return a.charAt(a.length()-1);
    }
    public static char getFirsy(String a){
        return a.charAt(0);
    }

    public static int findSumOfDigit(int a){
        int sum=0;
    while (a!=0){
        sum=sum+a%10;
        a=a/10;

    }
        return sum;
    }

}
