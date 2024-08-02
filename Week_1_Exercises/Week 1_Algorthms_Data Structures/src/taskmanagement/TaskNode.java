package taskmanagement;

class TaskNode {
    Task task;
    TaskNode next;

    // Constructor
    public TaskNode(Task task) {
        this.task = task;
        this.next = null;
    }
}

