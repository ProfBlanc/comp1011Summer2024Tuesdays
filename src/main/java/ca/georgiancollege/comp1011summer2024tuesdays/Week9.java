package ca.georgiancollege.comp1011summer2024tuesdays;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Week9 {


    static void example1() {

       IntStream is =  IntStream.range(1, 11);
       is.forEach(System.out::println);


    }
    static void example2(){

        IntStream.range(1, 21)
                .filter(v -> v % 2 == 0)
                .forEach(v -> System.out.println(v)
                );

    }
    static void example3(){

//        IntStream.range(1, 101)
//                .filter(v -> v % 5 == 0)
//                .forEach(v -> System.out.println(v)
//                );
//

        IntStream.range(1, 21)
                .map(v -> v * 5)
                .forEach(v -> System.out.println(v)
                );

    }
    static void example4(){

        //generate values between 1 and 100
        //discard values where the any digit is a 6
        // output 3 times the value of the remaining numbers

        /*
        1                   30
        1 2 3 4 5 7 8 9 10 11 12 13 14 15 17 18
        3 6 9 12 15 21


         */
        int start = 1, end = 100;
        IntStream.rangeClosed(start, end)
//                .filter(v -> String.valueOf(v).contains("6") )
                .filter(v -> (v+"").contains("6") )
                .map(v -> v * 3)
                .forEach(System.out::println);
    }
    static void example5(){

        Random rand = new Random();
        SecureRandom srand = new SecureRandom();

        IntStream tenRandomNumsBetween1And100 = rand.ints(10, 1, 101);
        //tenRandomNumsBetween1And100.forEach(System.out::println);

       int[] values =  tenRandomNumsBetween1And100.toArray();
        //Arrays.asList(values).stream().forEach(System.out::println);
        for(int value : values){
            System.out.println(value);
        }



    }
    static void example6(){
       Stream<Object> values =  Stream.of(1, 1.2, true, "hi");
       values.filter(v -> String.valueOf(v).length() >= 3)
               .forEach(System.out::println);

       Stream.builder().add(1234).add("hello").add(false).add("blah").build()
               .filter(s-> String.valueOf(s).contains("e"))
               .forEach(System.out::println);
    }

    static void example7(){

        ArrayList<String> names = new ArrayList<>();
        names.add("Mary Brown");
        names.add("Kernel Sanders");
        names.add("Mac Donalds");
        names.add("Wendy Redhead");
        names.add("Toca Bell");

        ArrayList<String> namesContainingDVersion1 = new ArrayList<>();
        for(String name : names){
            if(name.toLowerCase().contains("d"))
                namesContainingDVersion1.add(name);
        }
        for(String name : namesContainingDVersion1){
            System.out.println(name);
        }

        names.stream().filter(s->s.toLowerCase().contains("d")).forEach(System.out::println);

    }

    public static void main(String[] args) {
        example5();
    }

}
