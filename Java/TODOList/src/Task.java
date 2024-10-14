public class Task implements Comparable<Task>{

    private TodoList.Importance importance;
    private int priority;
    private String item;

    public Task(TodoList.Importance importance, int priority, String item){
        this.importance = importance;
        this.priority = priority;
        this.item = item;
    }

    @Override
    public int compareTo(Task o) {
        if (importance.compareTo(o.importance) == 0) {
            return priority - o.priority;
        }

        return importance.compareTo(o.importance);

    }

    @Override
        public String toString() {
            return "TodoItem{" +
                    "importance=" + importance +
                    ", priority=" + priority +
                    ", item='" + item + '\'' +
                    '}';
        }
}
