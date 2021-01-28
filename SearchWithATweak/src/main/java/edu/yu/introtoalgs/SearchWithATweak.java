package edu.yu.introtoalgs;

import java.util.List;

public class SearchWithATweak {

    /** Searches the specified sorted list of Integers for
     * the specified key. The list must be sorted prior to
     * making this call: otherwise , the results are
     * undefined. If the list contains multiple elements
     * with the specified value , will return the index of
     * the first instance of that value.
     * @param list the list to be searched: the list is
     * assumed to be sorted
     * @param key the value to be searched for
     * @return Index of the search key, if it is contained
     * in the list; otherwise , returns -1.
     */
    public static int findFirstInstance(final List<Integer> list , final int key )
    {
        if(list.isEmpty())
        {
            return -1;
        }

        int front=0; // pointer to front
        int end=list.size()-1; // pointer to end
        int midI=front + (end - front) / 2;//set the pointer to the middle of the list

        if(ascending(list)) {
            while (front<=end)
            {
                midI = front + (end - front) / 2;
                if (list.get(midI) > key)
                {
                    end=midI-1;// split list only look at left
                }
                else if (list.get(midI) < key)
                {
                    front=midI+1;// split list only look at right

                }
                else if (list.get(midI) == key)//then found it check for other instances
                {
                    while (midI > 0) {
                        if (list.get(midI - 1) == key) {
                            midI--;
                        } else {
                            break; // no other instances
                        }
                    }
                    return midI;
                }
            }
            return -1;
        }
        else
        {
            while (front<=end)
            {

                midI = front + (end - front) / 2;
                if (list.get(midI) < key)
                {
                    end=midI-1;
                }
                else if (list.get(midI) > key)
                {
                    front=midI+1;
                }
                else if (list.get(midI) == key) //then found it check for other instances
                {
                    while (midI > 0)
                    {
                        if (list.get(midI - 1) == key)
                        {
                            midI--;
                        }
                        else {
                            break; // no other instances
                        }
                    }
                    return midI;
                }
            }
            return -1;
        }
    }

    /** Searched the specified sorted list of distinct
     * Integers and returns an index i with the property
     * that the value of the ith element is itself i.
     * @param list the list to be searched: the list is
     * assumed to be sorted and contains distinct values
     * @return Index satisfying the specified property if any
     * such elements exist; otherwise , return -1
     */
    public static int elementEqualToItsIndex ( final List<Integer> list )
    {
        if(list.isEmpty())
        {
            return -1;
        }

        int front=0;
        int end=list.size();
        int midI= front + (end - front) / 2; //set the pointer to the middle of the list

        if(ascending(list)) {
            while (front<=end)
            {

                midI = front + (end - front) / 2;

                if (list.get(midI) > midI)
                {
                    end=midI-1;
                }
                else if (list.get(midI) < midI)
                {
                    front=midI+1;
                }
                else if (list.get(midI) == midI)
                {
                    //return first instance found even if not first instance
                    return midI;
                }
            }
            return -1;
        }
        else
        {
            while (front<=end)
            {

                midI = front + (end - front) / 2;

                if (list.get(midI) < midI)
                {
                    end=midI-1;
                }
                else if (list.get(midI) > midI)
                {
                    front=midI+1;
                }
                else if (list.get(midI) == midI)
                {
                    //return first instance found even if not first instance
                    return midI;
                }
            }
            return -1;

        }
    }


    private static boolean ascending(final List<Integer> list)
    {
        int first=0;
        int end=list.size()-1;

        return list.get(first) < list.get(end);
    }

}
