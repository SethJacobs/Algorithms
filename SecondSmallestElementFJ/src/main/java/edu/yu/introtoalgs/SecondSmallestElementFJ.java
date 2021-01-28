
package edu.yu.introtoalgs;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;



public class SecondSmallestElementFJ extends RecursiveTask<Integer[]> {


    private double SEQUENTIAL_THRESHOLD;
    private int[] data;
    private int start;
    private int end;


    /** Constructor .
     *
     * @param array input that we ’ll search
     * for the second smallest element ,
     * cannot be null .
     * @param fractionToApplySequentialCutoff
     * a fraction of the original number of
     * array elements : when the remaining
     * elements dip below this fraction , the
     * fork - join algorithm will process using
     * a sequential algorithm . Cannot be
     * less than 0.0 (fork - join processing
     * for all but arrays of size 1) and
     * cannot exceed 1.0 (no fork - join
     * processing will take place at all).
     */
    public SecondSmallestElementFJ(final int[] array, final double fractionToApplySequentialCutoff )
    {
        // fill me in
        if(array==null)
        {
            throw new IllegalArgumentException("array can not be null");
        }
        this.data=array;
        this.start=0;
        this.end=array.length;
        this.SEQUENTIAL_THRESHOLD=(fractionToApplySequentialCutoff*array.length);
        if(this.SEQUENTIAL_THRESHOLD<1)
        {
            SEQUENTIAL_THRESHOLD=1;
        }
        SecondSmallestElementFJ ss = new SecondSmallestElementFJ(array,0,array.length,SEQUENTIAL_THRESHOLD);
    }

    public SecondSmallestElementFJ(int[] data, int start, int end, double threshold) {
        this.data = data;
        this.start = start;
        this.end = end;
        this.SEQUENTIAL_THRESHOLD=threshold;
    }

    @Override
    protected Integer[] compute() {
        int length = end - start;
        if (length <= SEQUENTIAL_THRESHOLD) {
            return(computeMinimumDirectly());
        } else {
            int mid = start + length / 2;
            SecondSmallestElementFJ firstSubtask = new SecondSmallestElementFJ(data, start, mid,SEQUENTIAL_THRESHOLD);
            SecondSmallestElementFJ secondSubtask = new SecondSmallestElementFJ(data, mid, end, SEQUENTIAL_THRESHOLD);
            firstSubtask.fork();
            Integer[] a=secondSubtask.compute();
            Integer[] b=firstSubtask.join();

            Integer[] joined = new Integer[a.length + b.length];
            System.arraycopy(a, 0, joined, 0, a.length);
            System.arraycopy(b, 0,joined, a.length, b.length);
            return twoMins(joined);
        }
    }
    // ...

    private Integer[] computeMinimumDirectly() {
        int min = Integer.MAX_VALUE;
        int secondMin=Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            if(data[i]==min){
                //secondMin=min;
            } else if (data[i] < min) {
                secondMin = min;
                min = data[i];
            } else if (data[i] < secondMin) {
                secondMin = data[i];
            }
        }
        return new Integer[] {min,secondMin};
    }

    private Integer[] twoMins(Integer [] array)
    {
        int min = Integer.MAX_VALUE;
        int secondMin=Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if(array[i]==min){
               // secondMin=min;
            } else if (array[i] < min) {
                secondMin = min;
                min = array[i];
            } else if (array[i] < secondMin) {
                secondMin = array[i];
            }
        }
        return new Integer[] {min,secondMin};
    }

    private static int secondMin(Integer[] array) {
        int min = Integer.MAX_VALUE;
        int secondMin=Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if(array[i]==min){
                secondMin=min;
            } else if (array[i] < min) {
                secondMin = min;
                min = array[i];
            } else if (array[i] < secondMin) {
                secondMin = array[i];
            }
        }
        return secondMin;
    }
    private int result(Integer[] array)
    {
        return Math.max(array[0],array[1]);
    }


          /*  public static void main(String[] args) {
        int[] data = new int[20];
        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(1000);
            System.out.print(data[i] + " ");
            // Let's print each subarray in a line
           // if( (i+1) % SEQUENTIAL_THRESHOLD == 0 ) {
                System.out.println();
           // }
        }
        ForkJoinPool pool = new ForkJoinPool();
        SecondSmallestElementFJ task =
                new SecondSmallestElementFJ(data,  0.3);
         Arrays.toString(pool.invoke(task));
        secondMin(pool.invoke(task));
    }


           */
    /** Returns the second smallest
     * unique element of the input array .
     *
     * Example : if array is [1 , 7 , 4 , 3 , 6] ,
     * then secondSmallest ( array ) == 3.
     *
     * Example : if array is [6 , 1 , 4 , 3 , 5 ,
     * 2 , 1] , secondSmallest ( array ) == 2.
     2
     *
     * @return second smallest unique element
     * of the input
     * @throws IllegalArgumentException if
     * the input doesn't contain a minimum of
     * two unique elements .
     */
    public int secondSmallest() {
        ForkJoinPool pool = new ForkJoinPool();
        SecondSmallestElementFJ task =
                new SecondSmallestElementFJ(data,  SEQUENTIAL_THRESHOLD);
       // System.out.println("second min" + Arrays.toString(pool.invoke(task)));
        Integer[] array=pool.invoke(task);
        if(array[0].equals(array[1]))
        {
            throw new IllegalArgumentException("need two distinct numbers");
        }

        return (result(array));



    }


}
