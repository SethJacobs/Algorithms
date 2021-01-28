//package edu.yu.introtoalgs;

import edu.yu.introtoalgs.SearchWithATweak;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class SearchWithATweakTest {

    @org.junit.Test
    public void findFirstInstance() {

        List<Integer> list =new ArrayList<Integer>();
        list.add(1);
        list.add(5);
        list.add(10);
        list.add(3);

        Collections.sort(list);

        assertEquals("should return 1 bc 3 is 2nd spot in list at index 1", 1, SearchWithATweak.findFirstInstance(list,3));
        assertEquals("should return 2 bc 5 is 3rd spot in list at index 2", 2, SearchWithATweak.findFirstInstance(list,5));
        assertEquals("should -1 because not found int list", -1, SearchWithATweak.findFirstInstance(list,7));
        assertEquals("should return 3 because 10 is fourth in the 3rd index", 3, SearchWithATweak.findFirstInstance(list,10));
        assertEquals("should return 0 bc 1 is in 1st spot in list at index 0", 0, SearchWithATweak.findFirstInstance(list,1));
    }

    @org.junit.Test
    public void elementEqualToItsIndex() {
        List<Integer> list =new ArrayList<Integer>();
        list.add(-1); // first element
        list.add(1); // second element
        list.add(6); // fourth element
        list.add(3); // third element

        Collections.sort(list);

        assertEquals("should return 1 bc 1 is in the 2nd spot in list at index 1", 1, SearchWithATweak.elementEqualToItsIndex(list));


    }
    @Test
    public void noElemEqualToIn()
    {

        List<Integer> list =new ArrayList<Integer>();
        list.add(2); // second element
        list.add(1); // first element
        list.add(6); // fourth element
        list.add(3); // third element

        Collections.sort(list);


        assertEquals("should return -1 bc no element is equal to its index", -1, SearchWithATweak.elementEqualToItsIndex(list));

    }

    @Test
    public void multipleThrees()
    {
        List<Integer> list =new ArrayList<Integer>();
        list.add(2); // first element
        list.add(3); // second element
        list.add(6); // fourth element
        list.add(3); // third element

        Collections.sort(list);

        assertEquals("should return 1 bc first 3 is 2nd spot in list at index 1", 1, SearchWithATweak.findFirstInstance(list,3));

    }

    @Test
    public void manyInputs()
    {
        List<Integer> list =new ArrayList<Integer>();

        for(int i=0; i<10000000; i++)
        {
            list.add(i);
        }

        Collections.sort(list);

        assertEquals("should return 25 bc first 25 is 25th spot in list at index 14", 25, SearchWithATweak.findFirstInstance(list,25));


    }

    @Test
    public void decreasingOrder()
    {
        List<Integer> list =new ArrayList<Integer>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);

        assertEquals("should return 1 bc first 4 is 2nd spot in list at index 1", 1, SearchWithATweak.findFirstInstance(list,4));


    }

    @Test
    public void dOrderIndex()
    {
        List<Integer> list =new ArrayList<Integer>();
        list.add(6);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);

        assertEquals("should return 3 bc 3 is in the 4th spot in list at index 3", 3, SearchWithATweak.elementEqualToItsIndex(list));


    }
    @Test
    public void oneElement()
    {
        List<Integer> list =new ArrayList<Integer>();
        list.add(1);

        assertEquals("should return 0 bc first 1 is in first spot in list at index 0", 0, SearchWithATweak.findFirstInstance(list,1));
        assertEquals("should return -1 bc no 5 in the list", -1, SearchWithATweak.findFirstInstance(list,5));

    }

    @Test
    public void emptyList()
    {
        List<Integer> list =new ArrayList<Integer>();

        assertEquals("should return -1 because list is empty",-1,SearchWithATweak.elementEqualToItsIndex(list));
    }


}