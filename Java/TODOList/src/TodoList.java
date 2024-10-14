import java.util.PriorityQueue;

public class TodoList{
    public enum Importance {
        HIGH,
        MEDIUM,
        LOW;
    }

    private PriorityQueue<Task> taskQueue;

    public TodoList() {
        taskQueue = new PriorityQueue<>();
    }

    public void add(Importance importance, int priority, String item) {
        taskQueue.add(new Task(importance,priority,item));
    }

    public Task remove() {
        return taskQueue.remove();
    }

    public boolean isEmpty() {
        return taskQueue.isEmpty();
    }
}
