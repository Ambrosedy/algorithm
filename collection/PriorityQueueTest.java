package collection;

import java.time.LocalDate;
import java.util.PriorityQueue;

/**
 * @author 汐19990223
 */
public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<LocalDate> pq = new PriorityQueue<>();
        pq.add(LocalDate.of(1999,2,3));
        pq.add(LocalDate.of(1992,4,2));
        pq.add(LocalDate.of(2001,12,23));
        pq.add(LocalDate.of(2020,9,10));


//        for(LocalDate date:pq){
//            System.out.println(date);
//        }
//        System.out.println("******************");
//        while(!pq.isEmpty()){
//            System.out.println(pq.remove());
//        }
    }
}
