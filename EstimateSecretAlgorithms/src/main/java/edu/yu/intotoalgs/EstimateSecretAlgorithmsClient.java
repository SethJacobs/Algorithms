package edu.yu.intotoalgs;

import edu.yu.introtoalgs.SecretAlgorithm1;
import edu.yu.introtoalgs.SecretAlgorithm2;
import edu.yu.introtoalgs.SecretAlgorithm3;
import edu.yu.introtoalgs.SecretAlgorithm4;

public class EstimateSecretAlgorithmsClient {



    public static void runAlgs1(int n)
    {
        SecretAlgorithm1 secretAlgorithm1=new SecretAlgorithm1();
        secretAlgorithm1.setup(n);
        long startTime=System.currentTimeMillis();
        secretAlgorithm1.execute();
        long endTime=System.currentTimeMillis();
        //System.out.println("time took " +( endTime-startTime));
        System.out.println(n+"          " +(endTime-startTime));
    }


    public static void runAlgs2(int n)
    {
        SecretAlgorithm2 secretAlgorithm2=new SecretAlgorithm2();
        secretAlgorithm2.setup(n);
        long startTime=System.currentTimeMillis();
        secretAlgorithm2.execute();
        long endTime=System.currentTimeMillis();
        //System.out.println("time took " +( endTime-startTime));
        System.out.println(n+"          " +(endTime-startTime));
    }

    public static void runAlgs3(int n)
    {
        SecretAlgorithm3 secretAlgorithm3=new SecretAlgorithm3();
        secretAlgorithm3.setup(n);
        long startTime=System.currentTimeMillis();
        secretAlgorithm3.execute();
        long endTime=System.currentTimeMillis();
        //System.out.println("time took " +( endTime-startTime));
        System.out.println(n+"          " +(endTime-startTime));
    }

    public static void runAlgs4(int n)
    {
        SecretAlgorithm4 secretAlgorithm4=new SecretAlgorithm4();
        secretAlgorithm4.setup(n);
        long startTime=System.currentTimeMillis();
        secretAlgorithm4.execute();
        long endTime=System.currentTimeMillis();
        //System.out.println("time took " +( endTime-startTime));
        System.out.println(n+"          " +(endTime-startTime));
    }



    public static void main(String[] args) {
        System.out.println("alg 1");
        for(int i=50; i<=12800; i=i*2)
        {
           // System.out.println("alg 1 test "+i);
            runAlgs1(i);
        }

        System.out.println("alg 2");
        for(int i=1000000; i<=1000000000; i=i*2)
        {
           // System.out.println("alg 2 test "+i);
            runAlgs2(i);
        }

        System.out.println("alg 3");
        for(int i=1000; i<=1000000; i=i*2)
        {
            //System.out.println("alg 3 test "+i);
            runAlgs3(i);
        }

        System.out.println("alg 4");
        for(int i=10000; i<=100000000; i=i*2)
        {
           // System.out.println("alg 4 test "+i);
            runAlgs4(i);
        }

    }

}
