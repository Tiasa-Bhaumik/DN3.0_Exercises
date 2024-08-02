package taskmanagement;
public class TaskManagementSystem {
    private TaskNode head;

    // Constructor
    public TaskManagementSystem() {
        head = null;
    }

    // Add Task
    public void addTask(Task task) {
        TaskNode newNode = new TaskNode(task);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Search Task by ID
    public Task searchTask(int taskId) {
        TaskNode current = head;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    // Traverse Tasks
    public void traverseTasks() {
        TaskNode current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // Delete Task by ID
    public void deleteTask(int taskId) {
        if (head == null) return;

        if (head.task.getTaskId() == taskId) {
            head = head.next;
            return;
        }

        TaskNode current = head;
        while (current.next != null && current.next.task.getTaskId() != taskId) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        } else {
            System.out.println("Task not found.");
        }
    }

    public static void main(String[] args) {
        TaskManagementSystem tms = new TaskManagementSystem();

        tms.addTask(new Task(1, "Task 1", "Pending"));
        tms.addTask(new Task(2, "Task 2", "Completed"));
        tms.addTask(new Task(3, "Task 3", "In Progress"));

        System.out.println("All Tasks:");
        tms.traverseTasks();

        System.out.println("Searching for Task with ID 2:");
        System.out.println(tms.searchTask(2));

        System.out.println("Deleting Task with ID 2.");
        tms.deleteTask(2);

        System.out.println("All Tasks after deletion:");
        tms.traverseTasks();
    }
}

