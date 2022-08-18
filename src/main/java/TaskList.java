import java.util.ArrayList;

public class TaskList {
    private final ArrayList<? super Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    public void listTask() {
        System.out.println("\nCurrent Taskings");
        for (int i = 1; i <= taskList.size(); i++) {
            System.out.println(i + ") " + taskList.get(i - 1));
        }
        System.out.println("Number of tasking:" + taskList.size());
    }

    public void addTask(Task task) {
        taskList.add(task);
        String text = "               Successfully Added: ";
        System.out.println(text + task.getTaskName());
    }

    public void checkTask(int index) {
        if (validateIndex(index)) {
            Task task = (Task) taskList.get(index - 1);
            task.markDone();
        } else {
            validateIndexMessage();
        }
    }

    public void uncheckTask(int index) {
        if (validateIndex(index)) {
            Task task = (Task) taskList.get(index - 1);
            task.markUndone();
        } else {
            validateIndexMessage();
        }
    }

    private boolean validateIndex(int index) {
        return index > 0 && index <= taskList.size();
    }

    private void validateIndexMessage() {
        switch (taskList.size()) {
            case 0:
                System.out.println("Please add a task first!");
                break;
            case 1:
                System.out.println("Please choose the index 1");
                break;
            default:
                System.out.println("Please choose an index between 1 and " + taskList.size());
                break;
        }
    }
}
