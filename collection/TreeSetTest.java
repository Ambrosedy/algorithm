package collection;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author 汐19990223
 */
public class TreeSetTest {

    public static void main(String[] args) {
        /**
         * 基本类型
         *
        SortedSet<Integer> se = new TreeSet<>();
        se.add(9);
        se.add(4);
        se.add(10);
        se.add(87);
        se.add(0);
        for(int a:se){
            System.out.println(a);
        }
         **/
        /**
         * object的比较
         */

        SortedSet<Item> set = new TreeSet<>();
        set.add(new Item("Anna",10));
        set.add(new Item("Tom",13));
        set.add(new Item("Lina",9));
        set.add(new Item("Bill",101));
        set.add(new Item("Lidy",130));
        set.add(new Item("SCD",0));
        //Item{description='Lidy', partNum=130}, Item{description='Bill', partNum=101}, I
        // tem{description='Tom', partNum=13}, Item{description='Anna', partNum=10},
        // Item{description='Lina', partNum=9}, Item{description='SCD', partNum=0}]
        //按int
        System.out.println(set);

        NavigableSet<Item> sortByDesc = new TreeSet<>(
                Comparator.comparing(Item::getDescription));
        sortByDesc.addAll(set);
        //Item{description='Anna', partNum=10}, Item{description='Bill', partNum=101},
        // Item{description='Lidy', partNum=130}, Item{description='Lina', partNum=9},
        // Item{description='SCD', partNum=0}, Item{description='Tom', partNum=13}]
        //按des
        System.out.println(sortByDesc);
//        sortByDesc.add()
    }
}
