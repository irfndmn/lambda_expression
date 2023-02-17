package lambdalesson01;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda03 {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("Ali");
        myList.add("Ali");
        myList.add("Mark");
        myList.add("Amanda");
        myList.add("Christopher");
        myList.add("Jackson");
        myList.add("Mariano");
        myList.add("Alberto");
        myList.add("Tucker");
        myList.add("Benjamin");

        printToUpperCase(myList);
        printToUpperCase1(myList);
        printToUpperCase2(myList);
        printToUpperCase3(myList);
        System.out.println();
        printToUpperCase4(myList);
        System.out.println();
        printElementSortedByLength(myList);
        System.out.println();
        printElementSortedByLength1(myList);
        System.out.println();
        printDistinctElementSortedByLastChar(myList);
        System.out.println();
        printDistinctElementSortedByLastChar1(myList);
        System.out.println();
        sortWithLengthThanFirst(myList);
        System.out.println();
        sortWithLengthThanFirst1(myList);
        System.out.println();
        //  removeElement(myList);
        System.out.println();
        // remeoveElement(myList);
        System.out.println();
        printSquareLength(myList);
        System.out.println();
        printSquareLength1(myList);
        System.out.println();
        System.out.println("checkElement(myList) = " + checkElement(myList));
        chechAllElementsLengthLessThanTwelve(myList);
        System.out.println();
        checkIfAnyElementsInitia(myList);
        System.out.println();
        checkAtLeastOneElem(myList);


    }

    // 1. YOL
    public static void printToUpperCase(List<String> k) {   //Structured Programming
        List<String> a = new ArrayList<>();
        for (String w : k) {
            a.add(w.toUpperCase());
        }
        System.out.println(a);
    }

    // 2. YOL
    public static void printToUpperCase1(List<String> km) {  //Lambda Expression
        List<String> a = km.stream().map(t -> t.toUpperCase()).collect(Collectors.toList());
        System.out.println(a);
    }

    // 3. YOL
    public static void printToUpperCase2(List<String> km) {  //Method Reference
        List<String> a = km.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(a);
    }

    public static void printToUpperCase3(List<String> km) {  //Method Reference
        km.stream().map(String::toUpperCase).forEach(Util::printWithSpace);
    }


    // 4. YOL

    public static void printToUpperCase4(List<String> km) {  //Method Reference without stream
        km.replaceAll(String::toUpperCase);
        System.out.println(km);
    }


    public static void printElementSortedByLength(List<String> kl) {
        kl.stream().sorted(Comparator.comparing(t -> t.length())).forEach(t -> System.out.print(t + " "));// Lambda expression
    }

    public static void printElementSortedByLength1(List<String> kl) {
        kl.stream().sorted(Comparator.comparing(String::length)).forEach(Util::printWithSpace);   // Method Reference
    }

    public static void printDistinctElementSortedByLastChar(List<String> km) {//Lambda Expression
        km.stream().distinct().sorted(Comparator.comparing(t -> t.charAt(t.length() - 1))).forEach(System.out::println);
    }


    //Method Reference
    public static void printDistinctElementSortedByLastChar1(List<String> km) {
        km.stream().distinct().sorted(Comparator.comparing(Util::getLastChar)).forEach(Util::printWithSpace);
    }


    //Create a method to sort the elements according to their lengths then according to their first character

    // 1. YOL
    public static void sortWithLengthThanFirst(List<String> k) {
        k.stream().distinct().sorted(Comparator.comparing(String::length).thenComparing(t -> t.charAt(0))).forEach(Util::printWithSpace);
    }
    //2 YOL

    public static void sortWithLengthThanFirst1(List<String> k) {
        k.stream().distinct().sorted(Comparator.comparing(String::length).thenComparing(Util::getFirsy)).forEach(Util::printWithSpace);
    }


    // remove the element if The length greater than 5

    public static void removeElement(List<String> k) {
        k.removeIf(t -> t.length() > 5);
        System.out.println(k);
    }

    // Remove element if element starts with A , a   ends with N , n
    public static void remeoveElement(List<String> l) {
        l.removeIf(t -> t.startsWith("A") || t.startsWith("a") || t.endsWith("N") || t.endsWith("n"));
        System.out.println(l);
    }


    // Take the square length of elements and print in the reverse order
    public static void printSquareLength(List<String> k) {
        List<Integer> m = k.stream().distinct().map(t -> t.length() * t.length()).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(m);
    }

    public static void printSquareLength1(List<String> k) {
        k.stream().map(String::length).map(Util::getSquare).distinct().sorted(Comparator.reverseOrder()).forEach(Util::printWithSpace);

    }

    public static boolean checkElement(List<String> m) {
        return m.stream().filter(t -> t.length() > 11).collect(Collectors.toList()).size() == 0; /// my try now we make it with allmatch method
    }

    public static void chechAllElementsLengthLessThanTwelve(List<String> k) {
        boolean result = k.stream().allMatch(t -> t.length() < 12);
        System.out.println(result);
    }
    // Create a method to check if the initial of any element is not "X";


    public static void checkIfAnyElementsInitia(List<String> m) {
        boolean a = m.stream().noneMatch(t -> t.startsWith("X"));
        System.out.println(a);
    }

    // Create a method to check if  at least one element ends with "R"
    public static void checkAtLeastOneElem(List<String> k) {
        boolean a = k.stream().anyMatch(t -> t.endsWith("R"));
        System.out.println(a);
    }


}
