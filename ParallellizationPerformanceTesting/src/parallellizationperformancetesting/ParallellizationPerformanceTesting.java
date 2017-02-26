package parallellizationperformancetesting;

import java.util.function.Function;
import java.util.stream.LongStream;

/**
 *This program is testing parallel vs non parallel stream's performance.
 * A lower time equals better performance.
 * @author christopher stahle
 */
public class ParallellizationPerformanceTesting {

    public static void main(String[] args) {
        long n = 10_000l;
        System.out.println("Non-Parallel range sum done in: " + 
            measureSumPerformance(ParallellizationPerformanceTesting::rangedSumNonParallel, 10_000_000)
            + " msecs");
            System.out.println("Parallel range sum done in: " + 
            measureSumPerformance(ParallellizationPerformanceTesting::parallelRangedSum, 10_000_000)
            + " msecs");
        
    }
    public static long rangedSumNonParallel(long n)
    {
        return LongStream.rangeClosed(1, n)                  
                .reduce(0L, Long::sum);       
    }
    public static long parallelRangedSum(long n)
    {// using a non autoboxing/unboxing LongStream
        return LongStream.rangeClosed(1, n)   //produce different ranges from 1-10mil
                .parallel()                   //range chunks are given to multiple cores to process in ||
                .reduce(0L, Long::sum);       //reduction parallelizes well due to operating on subsets of data
    }
    public static long measureSumPerformance (Function<Long, Long> adder, long n)
    {
        long fastest = Long.MAX_VALUE;
        for(int i=0;i<10;i++)
        {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if(duration < fastest)
                fastest = duration;
        }
        return fastest;
    }
    /*
        Apply the function 10 times, register the time taken by each execution.
        Return the duration of the fastest one.
        Testing by summing the first 10mil natural numbers
    */
}
