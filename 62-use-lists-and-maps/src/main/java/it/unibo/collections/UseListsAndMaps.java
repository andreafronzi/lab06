package it.unibo.collections;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;


import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int INITIAL_VALUE = 1000;
    private static final int FINAL_VALUE = 2000;
    private static final int ELEM = 100_000;
    private static final int READS = INITIAL_VALUE; 

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final List<Integer> list = new ArrayList<>();

        for(int i = INITIAL_VALUE; i < FINAL_VALUE; i++){
            list.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final List<Integer> list2 = new LinkedList<>(list);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        Integer tmp = list.getFirst();
        list.set(0, list.getLast());
        list.set(list.size() - 1, tmp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for(final Integer e: list){
            System.out.println(e);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        for(int i = 0; i < ELEM; i++){
            list.addFirst(Integer.valueOf(i));
        }
        time = System.nanoTime() - time;
        System.out.println("Inserting " + ELEM + " element in a array list are required " + Long.valueOf(time).toString() + "ns " + timeConvert(time));

        time = System.nanoTime();
        for(int i = 0; i < ELEM; i++){
            list2.addFirst(Integer.valueOf(i));
        }
        time = System.nanoTime() - time;
        System.out.println("Inserting " + ELEM + " element in a linked list are required " + Long.valueOf(time).toString() + "ns " + timeConvert(time));
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        final int middleElement = list.size() / 2;
        time = System.nanoTime();
        for(int i = 0; i < READS; i++){
            list.get(middleElement);
        }
        time = System.nanoTime() - time;
        System.out.println("Reading " + READS + " elements in the middle of an Array list took " + Long.valueOf(time).toString() + "ns " + timeConvert(time));

        time = System.nanoTime();
        for(int i = 0; i < INITIAL_VALUE; i++){
            list2.get(middleElement);
        }
        time = System.nanoTime() - time;
        System.out.println("Reading " + READS + " elements in the middle of an Array list took " + Long.valueOf(time).toString() + "ns " + timeConvert(time));
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        /*
         * 8) Compute the population of the world
         */
        final Map<String, Long> map = new HashMap<>();
        map.put("Africa", 1_110_635_000L);
        map.put("Americas", 972_005_000L);
        map.put("Antarctica", 0L);
        map.put("Asia", 4_298_723_000L);
        map.put("Europe", 742_452_000L);
        map.put("Oceania", 38_304_000L);

        long worldpopulation = 0;
        for(final long e: map.values()){
            worldpopulation = worldpopulation + e;
        }

        System.out.println("We are " + worldpopulation);
        
    }
    private static String timeConvert(final long nanosecond){
        return NANOSECONDS.toMillis(nanosecond) + "ms";
    }
}
