package ca.georgiancollege.comp1011summer2024tuesdays;

import java.util.*;

public class Week8 {

    static void collectionIntro(){
/*
            GeorgianCollege
    Computer Studies            Nursing         FireFighting
Programming     Network



 */
        /*
                Collection
    List       Queue   Set              Map


List: ordered (index) values
Queue: ordered(value)  natural ordering
Set: unordered (index) series of distinct values
Map: key-value pairs aka associative arrays, dictionary


List: ArrayList, LinkedList
Queue: PriorityQueue
Set: TreeSet, HashSet
Map: TreeMap, HashMap

         */


    List<Integer> list1 = new ArrayList<>();
    List<Double> list2 = new LinkedList<>();
    Queue<Float> queue1 = new PriorityQueue<>();
    Set<String> set1 = new HashSet<>();
    Set<Character> set2 = new TreeSet<>();
    Stack<Short> stack = new Stack<>();
    //          5      10
        //           ^
    //add
    list1.add(5);
    list1.add(10);
        list1.add(15);
        list1.add(20);
    list2.add(1.23);
    list2.add(-98d);

    queue1.add(10f);
    queue1.add(-1f);
    queue1.add(5f);
    queue1.add(15f);

    //what is the ordering of the queue.
    // -1   5   10  15

    //how do I get the value 5?
//        System.out.println(queue1.size());
//        System.out.println(queue1.poll()); // -1
//        System.out.println(queue1.poll());
//        System.out.println(queue1.peek());  // 10
//        System.out.println(queue1.size());
while(queue1.size() > 0){
    System.out.println(queue1.poll());
}
        System.out.println("*".repeat(10));
//iterator
Iterator<Integer> iterator1 = list1.iterator();
//list2.iterator();
//queue1.iterator();
//set1.iterator();


/*

       5       10          15      20
^



 */


while (iterator1.hasNext()){
    System.out.println(iterator1.next());
}

ListIterator<Integer> listIterator1 = list1.listIterator();
ListIterator<Double> listIterator2 = list2.listIterator();

//      5       10      15      20
//  ^      ^
listIterator1.hasNext(); // result?  true
listIterator1.next(); // result?  5
listIterator1.next(); // result?   10
listIterator1.hasPrevious(); // result? true
        System.out.println(listIterator1.previous()); // result?
        System.out.println("*".repeat(20));
    }
    static void collectionspart2(){

        TreeSet<Integer> set1 = new TreeSet<>();
        HashSet<Double> set2 = new HashSet<>();

        set1.add(100);
        set1.add(-100);
        set1.add(50);
        set1.add(-50);

        for(int value : set1.tailSet(120, true)){
            System.out.println(value);
        }

    }
    static void collectionspart3(){

        /*
                Map = key-value pair
                        introduce categories as indexes (keys)
         */
        TreeMap<String, String> favFoods = new TreeMap<>();
        favFoods.put("1st", "pizza");
        favFoods.put("2nd", "hamburger");

        System.out.println(favFoods.get("1st")); //pizza
        System.out.println(favFoods.get("2nd")); //hamburget

        favFoods.containsKey("3rd");
        favFoods.containsValue("hot dog");

        Set<String> favFoodKeys = favFoods.keySet();
        System.out.println("*".repeat(10));
        for(String key : favFoodKeys){
            System.out.print(key + " = ");
            System.out.println(favFoods.get(key));
        }

    }
    public static void main(String[] args) {
        //collectionIntro();
        collectionspart3();
    }
}
