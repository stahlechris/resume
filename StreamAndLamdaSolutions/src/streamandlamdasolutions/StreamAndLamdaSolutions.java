package streamandlamdasolutions;

import java.util.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

/**
 *
 * @author christopher stahle
 */
public class StreamAndLamdaSolutions {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 0, 25, 523, 41, 5, 0, -5423, 43, 5, 1, 523, 31, 5, 31, 0};
        findTheFirstTwoUniqueElements(arr);
        ///////////////////////////////////
        findHowManyTimesTheNumber1Occurs(arr);
        //////////////////////////////////
        String[] test = {"test1", "test2", "test2", "test3", "test2", "test3"};
        countTheOccurenceOfEachItem(test);
        //////////////////////////////////
        sumOfNums(arr);
        returnTrueIfTheresTwoOnes(arr);
    }

    public static void findTheFirstTwoUniqueElements(int[] arr) {
        int[] uniqueArray = Arrays.stream(arr) //need help from Arrays to create a stream
                .distinct()
                .limit(2) //delete to find all the unique elements
                .toArray();
        for (int i : uniqueArray) {
            System.out.println(i);
        }
    }

    public static void findHowManyTimesTheNumber1Occurs(int[] arr) {
        long count = Arrays.stream(arr) //need help from Arrays to create a stream
                .filter(i -> i == 1).count();
        System.out.println(count);
    }

    private static void countTheOccurenceOfEachItem(String[] test) {
        Map<String, Long> map = Arrays.stream(test) //need help from Arrays to create a stream
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        System.out.println(map);
        
        //Alternatively solve it with "normal" code 
        Map<String,Integer> map2 = new HashMap<>();
        for (String x : test) {

            if (!map2.containsKey(x)) {
                map2.put(x, 1);
            } else {
                map2.put(x, map2.get(x) + 1);
            } 
        }
        System.out.println(map2);

    }

    private static void sumOfNums(int[] arr) {
        int sum = Arrays.stream(arr).sum();
    }

    private static void returnTrueIfTheresTwoOnes(int[] arr) {
        long count1 = Arrays.stream(arr).filter(s -> 1 == s).count();
        System.out.print(count1);
    }



}