package lambdalesson01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionalProgramming1 {
    public static void main(String[] args) throws IOException {

//        // How to read text from the file
//       Files.lines(Path.of("D:\\JavaMyProject\\lambda_expression\\src\\main\\java\\lambdalesson01\\LambdaExpressionFile.txt")).forEach(System.out::println);
//        System.out.println("===========================");
//       Files.lines(Paths.get("src\\main\\java\\lambdalesson01\\LambdaExpressionFile.txt")).forEach(System.out::println);   // Every line will be stream elements
/*
        System.out.println("===========================");
        Files.lines(Paths.get("src\\main\\java\\lambdalesson01\\LambdaExpressionFile.txt")).map(String::toUpperCase).forEach(System.out::println);
*/
        System.out.println("===========================");
        //If a specific word exist
        // boolean a =Files.lines(Paths.get("src\\main\\java\\lambdalesson01\\LambdaExpressionFile.txt")).anyMatch(t->t.contains("Java"));
        //   System.out.println(a);
        List<String> a = Files.
                lines(Paths.get("src\\main\\java\\lambdalesson01\\LambdaExpressionFile.txt")).
                map(t -> t.split(" ")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());// Her bir stream yani satir kelimelerden olusan Arraylar olmus oldu
        System.out.println(a);
        System.out.println("===========================");
        System.out.println();
        Files.
                lines(Paths.get("src\\main\\java\\lambdalesson01\\LambdaExpressionFile.txt")).
                map(t -> t.split(" ")).flatMap(Arrays::stream).distinct().forEach(Util::printWithSpace);// Her bir stream yani satir kelimelerden olusan Arraylar olmus oldu
        System.out.println();

        Files.
                lines(Paths.get("src\\main\\java\\lambdalesson01\\LambdaExpressionFile.txt")).
                map(t -> t.split(" ")).
                flatMap(Arrays::stream).
                filter(t -> t.endsWith("e")).
                forEach(Util::printWithSpace);
    }


}



/*
With different way to read words
        How to read text from the file
        FileInputStream a =new FileInputStream("D:\\JavaMyProject\\lambda_expression\\src\\main\\java\\lambdalesson01\\LambdaExpressionFile.txt");
        int i=0;
        while (i!=-1){

            i=a.read();
            System.out.print((char)i);

        }
 */