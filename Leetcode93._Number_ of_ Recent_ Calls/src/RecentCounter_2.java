import java.util.LinkedList;

public class RecentCounter_2 {
    private LinkedList<Integer> list;

    public RecentCounter_2() {
            list = new LinkedList<>();
        }

    public int ping(int t) {
            list.add(t);
            while (t - 3000 > list.getFirst())
                list.removeFirst();
            return list.size();
        }
}
