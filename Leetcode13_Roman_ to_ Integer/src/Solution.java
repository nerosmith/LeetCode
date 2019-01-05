import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static final Map<Character,Integer> map;
    private int next;
    private int cur;
    private int index;

    static {
        map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
    }

    public int romanToInt(String s) {
        index = s.length()-1;
        int sum = map.get(s.charAt(index));
        cur = sum;
        while (index > 0) {
            next = map.get(s.charAt(index-1));
            sum = cur > next ? sum - next : sum + next;
            cur = next;
            index--;
        }
        return sum;
    }
}