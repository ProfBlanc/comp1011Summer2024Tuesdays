package ca.georgiancollege.comp1011summer2024tuesdays;

import java.security.SecureRandom;
import java.util.*;
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
    static void funtask1(){

        LinkedList<Student> students = new LinkedList<>();
        int numberOfValuesToGenerate = 1000;
        SecureRandom srand = new SecureRandom();
        ArrayList<String> firstNames = new ArrayList<>();
        ArrayList<String> lastNames = new ArrayList<>();

        firstNames.add("John");
        firstNames.add("Mary");
        firstNames.add("Paul");
        firstNames.add("Jennifer");
        firstNames.add("Sue");
        firstNames.add("Larry");

        lastNames.add("Smith");
        lastNames.add("Johnson");
        lastNames.add("Edwards");
        lastNames.add("James");
        lastNames.add("Ronaldo");
        lastNames.add("Hamilton");

       int[] ageValues =  srand.ints(numberOfValuesToGenerate, 18, 66).toArray();
        int[] gradeValues =  srand.ints(numberOfValuesToGenerate, 40,101).toArray();

        for(int i = 0; i < numberOfValuesToGenerate; i++){
            students.add(new Student(
                    srand.nextInt(1000,100000),
                    firstNames.get(srand.nextInt(firstNames.size())),
                    lastNames.get(srand.nextInt(lastNames.size())),
                    ageValues[i],
                    gradeValues[i]
            ));
        }

        System.out.println("Failing Students");
        students.stream().filter(s-> s.getGrade() < 50).forEach(s-> System.out.printf("Name = %s, Grade=%.1f\n",
                s.getFirstName() +" " + s.getLastName(), s.getGrade()));

        System.out.println("*".repeat(20));

        System.out.println("Mature Students");
        students.stream().filter(s-> s.getAge() >= 30).forEach(s-> System.out.printf("Name = %s, Age=%d\n",
                s.getFirstName() +" " + s.getLastName(), s.getAge()));

        System.out.println("*".repeat(20));
        System.out.println("Young(18-25) Honor Roll Students");
        students.stream().filter(s-> s.getAge() < 26 && s.getGrade() >= 80 ).forEach(s-> System.out.printf("Name = %s, Age=%d, Grade=%.1f\n",
                s.getFirstName() +" " + s.getLastName(), s.getAge(), s.getGrade()));

    }

    public static void main(String[] args) {
        //example5();
        funtask1();
    }

}
