import java.util.*;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Solution {

        public List<Integer> topKFrequent(int[] nums,int k){
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int num:nums){
                if (map.containsKey(num))
                    map.put(num,map.get(num)+1);
                else
                    map.put(num,1);
            }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer a, Integer b) {
                            return map.get(a) - map.get(b);
                        }
                    });
                //可改寫 (a,b) -> map.get(a) - map.get(b) 在  Comparator<Integer>() 括號中
                for (int key : map.keySet()){
                        if (pq.size() < k)
                            pq.add(key);
                        else if (map.get(key) > pq.peek()){
                                pq.remove();
                                pq.add(key);
                            }
                     }

        LinkedList<Integer> res = new LinkedList<>();
        while (!pq.isEmpty())
            res.add(pq.remove());
        return res;
    }

}
