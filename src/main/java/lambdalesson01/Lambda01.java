package lambdalesson01;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda01 {
    /* 1- Lambda is Functional Programming
       2- Functional Programming was added to Java in Java 8, before Java 8 we were using just Structure Programming
         But after Java 8 we are able to use both...

       3-  Structured programming focus on "how to do" most of times. In Functional Programming focuses on "What to do"
       4- Functional Programming is used with Collection and Arrays

    */
    public static void main(String[] args) {


        List<Integer> myList = new ArrayList<>();
        myList.add(12);
        myList.add(9);
        myList.add(13);
        myList.add(4);
        myList.add(9);
        myList.add(2);
        myList.add(4);
        myList.add(12);
        myList.add(15);
        printSquareOddElements(myList);
        System.out.println();
        printDistinctOddElement(myList);
        System.out.println();
        printSumOfSquareDistinctEven(myList);
        System.out.println();
        findMultyDistinctCubeOfEven(myList);
        System.out.println();
        findMaxNumInTheList(myList);
        System.out.println();
        findMaxNumInTheList1(myList);
        System.out.println();
        findMaxNumInTheList2(myList);
        System.out.println();
        findMaxNumInTheList3(myList);
        System.out.println();
        getMinValueGreaterThanSeven(myList);
        System.out.println();
        getMinEvenValueGreaterThanSeven1(myList);
        System.out.println();
        List<Double> myList1 = new ArrayList<>();
        myList1.add(12.0);
        myList1.add(6.5);
        myList1.add(10.0);
        myList1.add(1.0);
        myList1.add(6.0);
        myList1.add(12.0);
        System.out.println(getHalfOfElementsDistinctGreaterThanFiveRevers(myList1));
        System.out.println();
        getHalfOfElementsDistinctGreaterThanFiveRevers1(myList);

    }

    public static void printSquareOddElements(List<Integer> km) {
        km.stream().filter(t -> t % 2 != 0).map(t -> t * t).forEach(t -> System.out.print(t + " "));
    }

    public static void printDistinctOddElement(List<Integer> ck) {
        ck.stream().distinct().filter(t -> t % 2 != 0).map(t -> t * t * t).forEach(t -> System.out.print(t + " "));
    }

    public static void printSumOfSquareDistinctEven(List<Integer> m) {
        Integer sum = m.stream().distinct().filter(t -> t % 2 == 0).map(t -> t * t).reduce(0, (t, u) -> t + u);
        System.out.println(sum);
    }

    public static void findMultyDistinctCubeOfEven(List<Integer> k) {
        Integer mult = k.stream().distinct().filter(t -> t % 2 == 0).map(t -> t * t * t).reduce(1, (t, u) -> t * u);
        System.out.println(mult);
    }
    //find max num in the list

    public static void findMaxNumInTheList(List<Integer> m) {
        Integer maks = m.stream().distinct().reduce(Integer.MIN_VALUE, (t, u) -> t > u ? t : u);
        System.out.println(maks);
    }

    public static void findMaxNumInTheList1(List<Integer> m) {
        Integer maks = m.stream().distinct().sorted(Comparator.reverseOrder()).findFirst().get();
        System.out.println(maks);
    }

    public static void findMaxNumInTheList2(List<Integer> m) {
        Integer maks = m.stream().distinct().sorted().reduce(Integer.MIN_VALUE, (t, u) -> u);
        System.out.println(maks);
    }

    public static void findMaxNumInTheList3(List<Integer> m) {
        Integer maks = m.stream().filter(t -> t % 2 == 0 && t > 7).sorted().reduce(((t, u) -> t)).get();
        System.out.println(maks);
    }

    // 1. YOL
    public static void getMinValueGreaterThanSeven(List<Integer> ml) {
        Integer Minn = ml.
                stream().
                distinct().
                filter(t -> t > 7 && t % 2 == 0).
                reduce(Integer.MAX_VALUE, (t, u) -> t < u ? t : u);
        System.out.println(Minn);
    }

    // 2. YOL

    public static void getMinEvenValueGreaterThanSeven1(List<Integer> ml) {
        Integer a = ml.stream().distinct().filter(t -> t % 2 == 0 && t > 7).sorted().findFirst().get();
        System.out.println(a);
    }

    public static List<Double> getHalfOfElementsDistinctGreaterThanFiveRevers(List<Double> kl) {
        return kl.
                stream().
                distinct().
                filter(t -> t > 5).
                map(t -> t / 2).
                sorted(Comparator.reverseOrder()).
                collect(Collectors.toList());
    }

    public static void getHalfOfElementsDistinctGreaterThanFiveRevers1(List<Integer> kl) {
        List<Double> m = kl.
                stream().
                distinct().
                filter(t -> t > 5).
                map(t -> t / 2.0).
                sorted(Comparator.reverseOrder()).
                collect(Collectors.toList());
        System.out.println(m);
    }


}
