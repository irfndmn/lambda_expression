package lambdalesson01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda02 {
    public static void main(String[] args) {

        /*
        1- We will learn method reference


        Method Reference =  Class name :: Method Name Without parenthesis
        Example          =  String     :: length


         */

        List<Integer> myList=new ArrayList<Integer>();
        myList.add(12);
        myList.add(9);
        myList.add(13);
        myList.add(4);
        myList.add(9);
        myList.add(2);
        myList.add(4);
        myList.add(12);
        myList.add(15);
        printElementsWithTheSpaceInSameLine(myList);
        System.out.println();
        printElementsWithTheSpaceInSameLine1(myList);
        System.out.println();
        printEvenELementsSameLine(myList);
        System.out.println();
        printSquareOddElements(myList);
        System.out.println();
        printDistinctCubeOfOddElement(myList);
        System.out.println();
        printSumOfSquareDistinctEven(myList);
        System.out.println();
        findMultyDistinctCubeOfEven(myList);
        System.out.println();
        findMaxNumInTheList(myList);
        System.out.println();
        getMinValueGreaterThanSeven(myList);
        System.out.println();
        getMinValueGreaterThanSeven1(myList);
        System.out.println();
        getHalfOfElementsDistinctGreaterThanFiveRevers1(myList);













    }
    public static void printElementsWithTheSpaceInSameLine(List<Integer> km){
        km.stream().forEach(t-> System.out.print(t+" "));

    }

    // If Java has any method we prefer to use it, If Java does not have it we create the method inside Util class
    public static void printElementsWithTheSpaceInSameLine1(List<Integer> km){
        km.stream().forEach(Util::printWithSpace);

    }
    public static void printEvenELementsSameLine(List<Integer> a){
        a.stream().filter(Util::isEven).forEach(Util::printWithSpace);
    }
    public static void printSquareOddElements(List<Integer> km){
        km.stream().filter(Util::isOdd).map(Util::getSquare).forEach(Util::printWithSpace);
    }
    public static void printDistinctCubeOfOddElement(List<Integer> ck){
        ck.
                stream().
                distinct().
                filter(Util::isOdd).
                map(Util::getCube).forEach(Util::printWithSpace);
    }
    public static void printSumOfSquareDistinctEven(List<Integer> m){
        Integer sum= m.
                stream().
                distinct().
                filter(Util::isEven).
                map(Util::getSquare).
                reduce(0,Math::addExact);
        System.out.println(sum);
    }
    public static void findMultyDistinctCubeOfEven(List<Integer> k){
        Integer mult=k.
                stream().
                distinct().
                filter(Util::isEven).
                map(Util::getCube).
                reduce(1,Math::multiplyExact);
        System.out.println(mult);
    }
    public static void findMaxNumInTheList(List<Integer> m){
        Integer maks=m.stream().distinct().reduce(Integer.MIN_VALUE,Math::max);
        System.out.println(maks);
    }
    public static void getMinValueGreaterThanSeven(List<Integer> ml){
        Integer Minn=ml.
                stream().
                distinct().
                filter(Util::getGreaterThanSeven).
                reduce(Integer.MAX_VALUE,Math::min);
                System.out.println(Minn);
    }
    public static void getMinValueGreaterThanSeven1(List<Integer> ml){
        Integer Minn=ml.
                stream().
                distinct().
                filter(t->t>7).
                filter(Util::isEven).
                reduce(Integer.MAX_VALUE,Math::min);
                System.out.println(Minn);
    }
    public static void getHalfOfElementsDistinctGreaterThanFiveRevers1(List<Integer> kl){
        List<Double> m= kl.
                stream().
                distinct().
                filter(t->t>5).map(Util::getHalf).
                sorted(Comparator.reverseOrder()).
                collect(Collectors.toList());
                System.out.println(m);
    }
}
