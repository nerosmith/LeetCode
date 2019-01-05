import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> queue;
    int size = 0;

    public MyStack() {
            queue = new LinkedList<>();
        }

    public void push(int x) {
            queue.offer(x);
            for (int i = 0; i < size ; i++) {
                    queue.offer(queue.poll());
                }
            size++;
        }

    public int pop(){
            size--;
            return queue.poll();
        }

    public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }

}