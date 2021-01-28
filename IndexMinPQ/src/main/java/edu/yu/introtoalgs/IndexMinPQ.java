package edu.yu.introtoalgs;
import java.util.Iterator;

public class IndexMinPQ < Key extends Comparable <Key > > implements Iterable < Integer >{


    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    public Iterator<Integer> iterator() {
        return new ReverseArrayIterator();
    }


    private class ReverseArrayIterator implements Iterator<Integer>
    {

        private IndexMinPQ<Key> copy;

        public ReverseArrayIterator()
        {
            copy=new IndexMinPQ<Key>(pq.length-1);
            for(int i=1; i<=N; i++)
            {
                copy.insert(pq[i],keys[pq[i]]);
            }
        }

        private int i = 1;


        private boolean greater(int i, int j)
        {
            return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
        }

        private void exch(int i, int j)
        {
            int exchange=pq[i];
            pq[i]=pq[j];
            pq[j]=exchange;
            qp[pq[i]]=i;
            qp[pq[j]]=j;
        }

        private void swim(int k)
        {
            while (k>1 && greater(k/2, k))
            {
                exch(k/2, k);
                k=k/2;
            }
        }

        private void sink(int k)
        {
            while(2*k <= N)
            {
                int j=2*k;
                if(j < N && greater(j, j+1))
                {
                    j++;
                }
                if(!greater(k,j))
                {
                    break;
                }
                exch(k,j);
                k=j;
            }
        }
        public boolean hasNext()
        {
            //sink(1);
            //swim(N);

            //return i < N;

            return !copy.isEmpty();
        }
        public Integer next()
        {
            //return pq[++i];

            return copy.delMin();
        }
       // public void remove()
       // {

       // }
    }

    private int[] pq;
    private int[] qp;
    private Key[] keys;
    private int N=0;
    private int maxN;

    public IndexMinPQ(int maxN)
    {
        pq= new int [maxN+1];
        qp= new int [maxN+1];
        keys=(Key[]) new Comparable[maxN+1];

        this.maxN=maxN;


    }

    public boolean isEmpty()
    {
        return N==0;
    }

    public int size()
    {
        return N;
    }

    public void insert(int i, Key key)
    {
       if(i <0)
       {
           throw new RuntimeException("cant insert at a negetive index");
       }
       if(i>=maxN)
       {
           throw new RuntimeException("cant insert a key at an index greater than maxN");
       }
       if(key==null)
       {
           throw new RuntimeException("key cant be null");
       }

       if(keys[i]!=null)
       {
           throw new RuntimeException("something already in index");
       }

        N++;
        qp[i]=N;
        pq[N]=i;
        keys[i]=key;
        swim(N);

    }




    private boolean greater(int i, int j)
    {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }

    private void exch(int i, int j)
    {
        int exchange=pq[i];
        pq[i]=pq[j];
        pq[j]=exchange;
        qp[pq[i]]=i;
        qp[pq[j]]=j;
    }

    private void swim(int k)
    {
        while (k>1 && greater(k/2, k))
        {
            exch(k/2, k);
            k=k/2;
        }
    }

    private void sink(int k)
    {
        while(2*k <= N)
        {
            int j=2*k;
            if(j < N && greater(j, j+1))
            {
                j++;
            }
            if(!greater(k,j))
            {
                break;
            }
            exch(k,j);
            k=j;
        }
    }
    public int delMin()
    {

        if(isEmpty())
        {
            throw new RuntimeException("is empty");
        }

        int min=pq[1];
        exch(1, N--);
        sink(1);
        assert min==pq[N+1];
        qp[min]=-1;
        keys[min]=null;
        pq[N+1]=-1;
        return min;

    }

    public Key keyOf(int i)
    {
        if(i <0)
        {
            throw new RuntimeException("cant get at a negetive index");
        }
        if(i>=maxN)
        {
            throw new RuntimeException("cant get a key at an index greater than maxN");
        }

        if(keys[i]==null)
        {
            throw new RuntimeException("no key at index");
        }

        return keys[i];
    }

    public Key minKey()
    {
        if(isEmpty())
        {
            throw new RuntimeException("is empty");
        }

        return keys[minIndex()];
    }

    public int minIndex()
    {

        if(isEmpty())
        {
            throw new RuntimeException("is empty");
        }

        return pq[1];
    }
}
