import java.util.ArrayList;
import java.util.*;

import java.util.Collection;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


// Item 12 from Here https://wiki.c2.com/?EffectiveJava
// TODO
// Consider more corner cases
// Review performance

public class SubIntervals {


    /** Tree - no duplicates and already ordered **/

    public static boolean overlapTree(Collection<Intervals> objectDataStructure) {

        Set<Intervals> newList = new TreeSet<Intervals>(objectDataStructure);
        boolean flag=false;
        Iterator iterator = newList.iterator();

        while (iterator.hasNext() && !flag) {
            Intervals temp = (Intervals)iterator.next();

            if(iterator.hasNext()) {
                Intervals temp1 = (Intervals) iterator.next();
                if(temp.getA()<temp1.getB()){
                    flag=true;
                 }
            }
        }

        return (!flag)?true:false;

    }


    /** ArrayList -  duplicates, extension to Comparable **/

    public static boolean overlapArray(Collection<Intervals> objectDataStructure) {

        List<Intervals> newList = new ArrayList<>(objectDataStructure);

        Collections.sort(newList);

        int i=0; boolean flag=false;

        while(i+1<newList.size() && !flag){

            if(newList.get(i).getB()>newList.get(i+1).getA()){
                flag=true;
            }

            i++;

        }

        return (!flag)?true:false;

    }

    @Test
    public void ordered() throws Exception{

        SubIntervals sub = new SubIntervals();

        ArrayList<Intervals> array = new ArrayList<Intervals>();

        array.add(new Intervals(8,11));
        array.add(new Intervals(9,10));
        array.add(new Intervals(2,7));


        Assertions.assertFalse(sub.overlapTree(array));

    }

    public static void main(String[] args) throws Exception {

        ArrayList<Intervals> array = new ArrayList<Intervals>();

        array.add(new Intervals(1,6));
        array.add(new Intervals(9,10));
        array.add(new Intervals(5,7));
        array.add(new Intervals(5,6));

        System.out.println(overlapTree(array));
        System.out.println(overlapArray(array));


    }
}


// Object representing [a,b]

class Intervals implements Comparable {

    private int a;
    private int b;

    public Intervals(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    @Override
    public int compareTo(Object o) {
        int current =((Intervals)o).getA();
        return this.getA() -current;
    }

}

