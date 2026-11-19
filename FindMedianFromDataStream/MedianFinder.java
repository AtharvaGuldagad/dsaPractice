package FindMedianFromDataStream;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {

    Queue<Integer> smolHp;
    Queue<Integer> bigHp;
    public MedianFinder() {
        smolHp=new PriorityQueue<>((a,b)->b-a);
        bigHp=new PriorityQueue<>((a,b)->a-b);
    }
    
    public void addNum(int num) {
        smolHp.add(num);
        if( smolHp.size()-bigHp.size()>1 || !bigHp.isEmpty() && smolHp.peek()>bigHp.peek()){
            bigHp.add(smolHp.poll());
        }
        if(bigHp.size()-smolHp.size()>1){
            smolHp.add(bigHp.poll());
        }
    }
    
    public double findMedian() {
        if(smolHp.size()==bigHp.size()){
            return (double)(bigHp.peek()+smolHp.peek())/2;

        }else if(smolHp.size()>bigHp.size()){
            return (double) smolHp.peek();
        }else{
            return (double) bigHp.peek();
        }
    }
}
