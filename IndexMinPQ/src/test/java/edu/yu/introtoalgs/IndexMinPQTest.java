package edu.yu.introtoalgs;

import edu.yu.introtoalgs.IndexMinPQ;

import static org.junit.Assert.*;

public class IndexMinPQTest {

    @org.junit.Test
    public void isEmpty() {
        IndexMinPQ<Double> indexMinPQ = new IndexMinPQ<Double>(3);

        assertTrue(indexMinPQ.isEmpty());
    }

    @org.junit.Test
    public void size() {

        IndexMinPQ<Double> indexMinPQ = new IndexMinPQ<Double>(3);

        indexMinPQ.insert(2,3.5);
        indexMinPQ.insert(1,2.4);

        assertEquals("size should be two", 2,indexMinPQ.size());

        // System.out.println(indexMinPQ);


    }

    @org.junit.Test
    public void insert() {

        IndexMinPQ<Double> indexMinPQ = new IndexMinPQ<Double>(3);


        indexMinPQ.insert(0,3.5);
        indexMinPQ.insert(1,2.4);
        indexMinPQ.insert(2,1.2);

        System.out.println(indexMinPQ);
    }

    @org.junit.Test
    public void delMin() {
        IndexMinPQ<Double> indexMinPQ = new IndexMinPQ<Double>(3);


        indexMinPQ.insert(0,3.5);
        indexMinPQ.insert(1,2.4);
        indexMinPQ.insert(2,1.2);

        //assertEquals("should be 2.4", 2.4, (double) indexMinPQ.delMax());
        System.out.println(indexMinPQ.delMin());
        System.out.println(indexMinPQ.delMin());

    }
}