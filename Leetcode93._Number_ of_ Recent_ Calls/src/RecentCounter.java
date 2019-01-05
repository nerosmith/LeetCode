import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    private Queue<Integer> queue;

    public RecentCounter() {
            queue = new LinkedList<>();
        }

    public int ping(int t) {
            queue.add(t);
            while(t - 3000 > queue.peek())
                queue.poll();
            return queue.size();
        }
}
