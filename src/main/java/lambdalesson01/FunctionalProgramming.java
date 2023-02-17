package lambdalesson01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionalProgramming {
    public static void main(String[] args) {
        Course cTurkishDay=new Course("Summer","Turkish Day",97,128);
        Course cTurkishNight=new Course("Winter","Turkish Night",98,154);
        Course cEnglishDay=new Course("Spring","English Day",95,132);
        Course cEnglishNight=new Course("Winter","English Night",93,144);

        List<Course> coursesList=new ArrayList<>();
        coursesList.add(cTurkishDay);
        coursesList.add(cTurkishNight);
        coursesList.add(cEnglishDay);
        coursesList.add(cEnglishNight);
        System.out.println();
        System.out.println(checkAllAver(coursesList));
        System.out.println();
        checkAllAver1(coursesList);
        System.out.println(checkAtLeastOneOfNameContainsTurkish(coursesList));
        System.out.println(checkAllAver2(coursesList,91));
        System.out.println(checkAtLeastOneOfNameContainsTurkish1(coursesList,"Turkish"));
        System.out.println();
        printCourseWhoseAvHighest(coursesList);
        System.out.println();
        printCourseWhoseAvHighest1(coursesList);
        System.out.println(sortAndSkipFirst2Elements(coursesList));;
        printAOne(coursesList,4);
        System.out.println();
        printAOne1(coursesList,3);


    }
    //Create a method to check if all average score greater than 91

    public static boolean checkAllAver(List<Course> a){     //my try
     return  a.stream().map(t->t.getAverageScore()).allMatch(t->t>91);

    }
    public static void checkAllAver1(List<Course> a){     //my try that is not a best practice
        boolean m=a.stream().allMatch(t->t.getAverageScore()>91);
        System.out.println(m);
    }
    public static boolean checkAllAver2(List<Course> a,double k){     // the best
        return a.stream().allMatch(t->t.getAverageScore()>k);

    }

    public static boolean checkAtLeastOneOfNameContainsTurkish(List<Course> k){ // not best practice

        return  k.stream().anyMatch(t->t.getCourseName().contains("Turkish"));

    }
    public static boolean checkAtLeastOneOfNameContainsTurkish1(List<Course> k,String str){ // The best

        return  k.stream().anyMatch(t->t.getCourseName().contains(str));

    }
    // Print the course whose average score highest
    public static void printCourseWhoseAvHighest(List<Course> m){
       Integer a = m.stream().map(t->t.getAverageScore()).sorted(Comparator.reverseOrder()).findFirst().get();
       m.stream().filter(t->t.getAverageScore()==a).forEach(t-> System.out.println(t+" "));
    }
    public static void printCourseWhoseAvHighest1(List<Course> m){                                     // Best practice
     Course a=m.stream().sorted(Comparator.comparing(Course::getAverageScore).reversed()).findFirst().get();
        System.out.println(a);
    }

    // Sort the list elements according to the average score in ascending order and skip first 2 elements

    public static List<Course> sortAndSkipFirst2Elements(List<Course> a){
       return a.stream().sorted(Comparator.comparing(Course::getAverageScore)).skip(2).collect(Collectors.toList());
    }
    // Sort the list elements according to the average score in ascending order and print just third one
    public static void printAOne(List<Course> k,int a){           // This my try
      Course kl= k.stream().sorted(Comparator.comparing(Course::getAverageScore)).skip(a-1).findFirst().get();
        System.out.println(kl);
    }
    public static void printAOne1(List<Course> k,int a){           // This is best practice
        List<Course> kl= k.stream().sorted(Comparator.comparing(Course::getAverageScore)).skip(a-1).limit(1).collect(Collectors.toList());
        System.out.println(kl);
    }

}
