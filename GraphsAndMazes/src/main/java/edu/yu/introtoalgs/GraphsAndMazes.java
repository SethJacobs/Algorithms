package edu.yu.introtoalgs;


import java.util.*;

public class GraphsAndMazes {

    /** A immutable coordinate in 2D space.
     *
     * Students must NOT modify the constructor (or its semantics) in any way,
     * but can ADD whatever they choose.
     */
    public static class Coordinate {
        public final int x, y;
        Coordinate parent;
        /** Constructor, defines an immutable coordinate in 2D space.
         *
         * @param x specifies x coordinate
         * @param y specifies x coordinate
         */
        public Coordinate(final int x, final int y) {
            this.x = x;
            this.y = y;
            Coordinate parent;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Coordinate that = (Coordinate) o;

            if (x != that.x) return false;
            if (y != that.y) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        @Override
        public String toString() {
            return ("("+x+","+y+")");
        }

        /** Add any methods, instance variables, static variables that you choose
         */


    } // Coordinate class

    private static int[][] compass={{0,1},{1,0},{0,-1},{-1,0}};

    private static Coordinate getNext(int row, int colum, int addRow, int addColum)
    {
        return new Coordinate(row+addRow,colum+addColum);
    }

    /** Given a maze (specified by a 2D integer array, and start and end
     * Coordinate instances), return a path (beginning with the start
     * coordinate, and terminating wih the end coordinate), that legally
     * traverses the maze from the start to end coordinates.  If no such
     * path exists, returns an empty list.  The path need need not be a
     * "shortest path".
     *
     * @param maze 2D 2int array whose "0" entries are interpreted as
     * "coordinates that can be navigated to in a maze traversal (can be
     * part of a maze path)" and "1" entries are interpreted as
     * "coordinates that cannot be navigated to (part of a maze wall)".
     * @param start maze navigation must begin here, must have a value
     * of "0"
     * @param end maze navigation must terminate here, must have a value
     * of "0"
     * @return a path, beginning with the start coordinate, terminating
     * with the end coordinate, and intervening elements represent a
     * legal navigation from maze start to maze end.  If no such path
     * exists, returns an empty list.  A legal navigation may only
     * traverse maze coordinates, may not contain coordinates whose
     * value is "1", may only traverse from a coordinate to one of its
     * immediate neighbors using one of the standard four compass
     * directions (no diagonal movement allowed).  A legal path may not
     * contain a cycle.  It is legal for a path to contain only the
     * start coordinate, if the start coordinate is equal to the end
     * coordinate.
     */
    private static boolean isValid(int[][] maze, Coordinate coordinate)
    {
        try
        {
            int x=maze[coordinate.x][coordinate.y];
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public static List<Coordinate> searchMaze(final int[][] maze, final Coordinate start, final Coordinate end)
    {
        if(maze[start.x][start.y]!=0 || maze[end.x][end.y]!=0)
        {
            throw new IllegalArgumentException("maze needs to start and end in a valid location");
        }
        if(start==null || end ==null)
        {
            throw new IllegalArgumentException("start and end can not be null");
        }

        LinkedList<Coordinate> path= new LinkedList<>();
        Stack<Coordinate> stack=new Stack<edu.yu.introtoalgs.GraphsAndMazes.Coordinate>();
        int i,j;
        i=start.x;
        j=start.y;
        stack.push(start);

        maze[i][j]=1;
        Boolean finished=false;
        while(!stack.isEmpty())
        {
            Coordinate child=stack.pop();
            i=child.x;
            j=child.y;


            if(end.x==i && end.y==j)
            {
                end.parent=child;
                finished=true;
                break;
            }
            Coordinate coordinate=new Coordinate(i,j);
            Coordinate up=getNext(coordinate.x,coordinate.y,-1,0);

            if(isValid(maze,up)) {
                if (maze[up.x][up.y] == 0) {
                    up.parent=child;
                    maze[up.x][up.y]=1;
                    stack.push(up);


                }
            }
            Coordinate right=getNext(coordinate.x,coordinate.y,0,1);
            if(isValid(maze,right)) {
                if (maze[right.x][right.y] == 0) {
                    right.parent=child;
                    maze[right.x][right.y]=1;
                    stack.push(right);


                }
            }

            Coordinate down=getNext(coordinate.x,coordinate.y,1,0);
            if(isValid(maze, down)) {
                if (maze[down.x][down.y] == 0) {
                    down.parent=child;
                    maze[down.x][down.y]=1;
                    stack.push(down);


                }
            }

            Coordinate left=getNext(coordinate.x,coordinate.y,0,-1);
            if(isValid(maze, left)) {
                if (maze[left.x][left.y] == 0) {
                    left.parent=child;
                    maze[left.x][left.y]=1;
                    stack.push(left);


                }
            }

        }


        if(finished==false)
        {
            ArrayList<Coordinate> empty= new ArrayList<>();
            return empty;
        }
        else
        {

            Coordinate node=end;

            path.add(node);

            while(node.parent!=null)
            {
                path.addFirst(node);
                if(node.equals(path.getLast()))
                {
                    path.removeLast();
                }
                node=node.parent;
            }
            path.addFirst(start);


        }

        return path;
    }

    /** minimal main() demonstrates use of APIs
     */
    public static void main (final String[] args) {
        final int[][] exampleMaze = {
                {0, 1, 1, 1, 0, 0},
                {0, 0, 1},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0, 0, 1},
                {0, 1, 0, 0, 1, 0},
                {0, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0}
        };


        final Coordinate start = new Coordinate(1,1);
        final Coordinate end = new Coordinate(8, 4);
        final List<Coordinate> path = searchMaze(exampleMaze, start, end);
        System.out.println("path = "+path);

    }

}
