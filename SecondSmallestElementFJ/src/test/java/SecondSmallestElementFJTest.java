import org.junit.Before;

import java.util.Random;

import static org.junit.Assert.*;

public class SecondSmallestElementFJTest {
/*
   int[] data;
   long last=1;
   long nLast=1;

    @org.junit.Test
    public void secondSmallest() {

       // SecondSmallestElementFJ task =
       // new SecondSmallestElementFJ(data,  .1);
      // long start=System.nanoTime();
      //  System.out.println("second min" +task.secondSmallest());
      //  long end=System.nanoTime();
      //  System.out.println("time"+ (end-start));


        Random random = new Random();
        for(int i=50; i<=100000000; i=i*2)
        {
            int[] array = new int[i];
            for(int j=0; j<i; j++)
            {
                array[j] = random.nextInt(1000000000);
                //System.out.print(data[i] + " ");
            }

            SecondSmallestElementFJ task =
                    new SecondSmallestElementFJ(array,  .3);
            System.out.println("n =" +i);
            long start=System.nanoTime();

           // System.out.println("second min" +task.secondSmallest());
            long end=System.nanoTime();
            long time=end-start;
            System.out.println("time"+ time);
            System.out.println("ratio "+(time/last) );
             last = time;
        }


    }


    @org.junit.Test
    public void normalTest() {


        Random random = new Random();
        for (int i = 50; i <= 100000000; i = i * 2) {
            int[] array = new int[i];
            for (int j = 0; j < i; j++) {
                array[j] = random.nextInt(1000000000);
                //System.out.print(data[i] + " ");
            }


            long start = System.nanoTime();
            int min = Integer.MAX_VALUE;
            int secondMin = Integer.MAX_VALUE;
            for (int k = 0; k < array.length; k++) {
                if (array[k] < min) {
                    secondMin = min;
                    min = array[k];
                } else if (array[k] < secondMin) {
                    secondMin = array[k];
                }
            }
            System.out.println("n= "+i);
            System.out.println("second min" + secondMin);
            long end = System.nanoTime();
            long time=end-start;
            System.out.println("time"+ time);
            System.out.println("ratio "+((double)time/last) );
            last = time;
        }
    }

    @org.junit.Test
    public void compare()
    {
        Random random = new Random();
        for(int i=50; i<=100000000; i=i*2)
        {
            int[] array = new int[i];
            for(int j=0; j<i; j++)
            {
                array[j] = random.nextInt(1000000000);
                System.out.print(array[i] + " ");
            }

            SecondSmallestElementFJ task =
                    new SecondSmallestElementFJ(array,  0.5);
            System.out.println("n =" +i);
            long start=System.nanoTime();
           // System.out.println("second min" +task.secondSmallest());
            task.secondSmallest();
            long end=System.nanoTime();
            long sTime=end-start;
            last = sTime;
            System.out.println("fj time" + sTime);

            long nstart = System.nanoTime();
            int min = Integer.MAX_VALUE;
            int secondMin = Integer.MAX_VALUE;
            for (int k = 0; k < array.length; k++) {
                if(array[k]==min)
                {
                    continue;
                }
                else if (array[k] < min) {
                    secondMin = min;
                    min = array[k];
                } else if (array[k] < secondMin) {
                    secondMin = array[k];
                }
            }
           // System.out.println("n= "+i);
            //System.out.println("second min" + secondMin);
            long nend = System.nanoTime();
            long time=nend-nstart;
           // System.out.println("time"+ time);
           // System.out.println("ratio "+(time/last) );
            last = time;
            System.out.println("sequential time" + time);
            System.out.println("speed up = "+((double)time/sTime));
        }
    }

  //  @Before
   /* public void setUp() throws Exception {
         data = new int[100000000];
        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(1000000000);
            //System.out.print(data[i] + " ");
        }

    }

    */
}