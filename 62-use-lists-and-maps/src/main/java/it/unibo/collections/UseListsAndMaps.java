package it.unibo.collections;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    private static void printInfo(long time, List<Integer> c) {
        time = System.nanoTime() - time;
        final var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Converting "
                + c.size()
                + " ints to String and inserting them in a Set took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
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
        final List<Integer> arrayNums = new ArrayList<>();
        for (int i = 1000; i < 2000; i++) {
            arrayNums.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final List<Integer> listNums = new LinkedList<>(arrayNums);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and lastxsd
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        final Integer i = arrayNums.get(arrayNums.size() - arrayNums.size());
        arrayNums.set(arrayNums.size() - arrayNums.size(), arrayNums.get(arrayNums.size()-1));
        arrayNums.set(arrayNums.size()-1, i);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer integer: arrayNums) {
            System.out.println(integer);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long arrayListTimeAdd = System.nanoTime();
        for (int j = 0; j < 100000; j++) {
            arrayNums.add(0, j);
        }
        printInfo(arrayListTimeAdd, arrayNums);
        long linkedListTimeAdd = System.nanoTime();
        for (int j = 0; j < 100000; j++) {
            listNums.add(0, j);
        }
        printInfo(linkedListTimeAdd, listNums);
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        long arrayListTimeRead = System.nanoTime();
        for (int j = 0; j < 1000; j++) {
            arrayNums.get(arrayNums.size() / 2);
        }
        printInfo(arrayListTimeRead, arrayNums);
        long linkedListTimeRead = System.nanoTime();
        for (int j = 0; j < 1000; j++) {
            listNums.get(listNums.size() / 2);
        }
        printInfo(linkedListTimeRead, listNums);
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
        final Map<String, Long> map = new HashMap<>();
        map.put("Africa", 1110635000l);
        map.put("Americas", 972005000l);
        map.put("Antarctica", 0l);
        map.put("Asia", 4298723000l);
        map.put("Europe", 742452000l);
        map.put("Oceania", 38304000l);
        /*
         * 8) Compute the population of the world
         */
        Long population = 0l;
        for (Long p: map.values()) {
            population += p;
        }
        System.out.println("Global population: " + population);
    }
}
