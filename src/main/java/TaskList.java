import java.util.List;
import java.util.ArrayList;
public class TaskList {
    private final List<Task> items;
    public TaskList() {
        this.items = new ArrayList<>();
    }
    public TaskList(List<Task> items) {
        this.items = items;
    }
    public List<Task> getItemsList() {
        return new ArrayList<>(this.items);
    }
    public int size(){
        return this.items.size();
    }
    public String add(Task task) {
        this.items.add(task);
        return "morning sir i have added this to the list sir:\n"
                + task
                + "\ni counted all your number of tasks sir it is "
                + this.items.size()
                + " sir";
    }
    public String toString() {
        String numberedItems = "";
        for (int i=0;i<this.items.size();i++) {
            numberedItems += (i+1) + ". " + this.items.get(i) + "\n";
        }
        return numberedItems;
    }
    public Task markItem(int idx) {
        Task selected = this.items.get(idx);
        selected.markAsDone();
        return  selected;
    }
    public Task deleteItem(int idx) {
        return this.items.remove(idx);
    }
}
