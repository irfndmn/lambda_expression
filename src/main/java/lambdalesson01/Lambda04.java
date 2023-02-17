package lambdalesson01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lambda04 {
    public static void main(String[] args) {
        List<Integer> myList=new ArrayList<>();
        myList.add(12);
        myList.add(9);
        myList.add(13);
        myList.add(4);
        myList.add(9);
        myList.add(2);
        myList.add(4);
        myList.add(12);
        myList.add(15);
        System.out.println();
        findSumOfAllElemen(myList);
        System.out.println();
        getSumOfIntFrom7to100();
        System.out.println();
        getSumOfIntFrom7to100a();
        System.out.println();
        getSumOfIntFrom7to100b();
        System.out.println();
        multiplyIntFrom2to11();
        System.out.println();
        multiplyIntFrom2to11a();
        System.out.println();
        getFactorialGivenNum(6);
        System.out.println();
        getFactorialGivenNum1(0);
        System.out.println();
        getSumOfEvenBetween(1,5);
        System.out.println();
        printSumOfDigit(11,13);
        System.out.println();
        printSumOfDigit1(21,24);


    }
    public static void findSumOfAllElemen(List<Integer> k){
        Integer sum =k.stream().reduce(0,Math::addExact);
        System.out.println(sum);

    }
    // Create a method to find sum of integer from 7 to 100
  public static void getSumOfIntFrom7to100(){
        Integer sum= IntStream.range(7,101).reduce(0,Math::addExact);
      System.out.println(sum);
  }
  // 1 Way
    public static void getSumOfIntFrom7to100a(){
        Integer sum= IntStream.range(7,101).sum();
        System.out.println(sum);
    }
    // 2. Way
    public static void getSumOfIntFrom7to100b(){
        Integer sum=IntStream.rangeClosed(7,100).sum();
        System.out.println(sum);
    }

    public static void  multiplyIntFrom2to11(){
        int mul=IntStream.rangeClosed(2,11).reduce(1,(t,u)->t*u); // With Lambda Expression
        System.out.println(mul);
    }
    public static void  multiplyIntFrom2to11a(){
        int mul=IntStream.rangeClosed(2,11).reduce(1,Math::multiplyExact); // With Lambda Expression
        System.out.println(mul);
    }

    public static void getFactorialGivenNum(int a){                              // Fix me --> If we use negative it will be issue
        int fac=IntStream.rangeClosed(1,a).reduce(1,Math::multiplyExact);
        System.out.println(a+"! = "+fac);
    }
    public static void getFactorialGivenNum1(int a){                              // Fixed
       if (a<0) {
            System.out.println("Do not use  negative ...");
        }else {
            int fac = IntStream.rangeClosed(1, a).reduce(1, Math::multiplyExact);
            System.out.println(a + "! = " + fac);
        }
    }


    // Find sum of even integer between given two num


    public static void getSumOfEvenBetween(int a, int b){
        int sum=IntStream.range(a+1,b).filter(Util::isEven).sum();
        System.out.println(sum);
    }



    //Create a method given  the sum of digit between given two num

    public static void printSumOfDigit(int a , int b) {  // if a=11 b=13  it will be  (1+1) + (1+2) + (1+3)=9
        int sum = IntStream.rangeClosed(a, b).map(Util::findSumOfDigit).sum();
        System.out.println(sum);
    }
    public static void printSumOfDigit1(int a , int b) {  // if a=11 b=13  it will be  (1+1) + (1+2) + (1+3)=9
         IntStream.rangeClosed(a, b).map(Util::findSumOfDigit).forEach(Util::printWithSpace);
    }

}
