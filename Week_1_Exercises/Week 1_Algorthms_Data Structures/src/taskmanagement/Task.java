package taskmanagement;
public class Task {
    private int taskId;
    private String taskName;
    private String status;

    // Constructor
    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    // Getters
    public int getTaskId() { return taskId; }
    public String getTaskName() { return taskName; }
    public String getStatus() { return status; }

    // Setters
    public void setTaskName(String taskName) { this.taskName = taskName; }
    public void setStatus(String status) { this.status = status; }

    // toString method
    @Override
    public String toString() {
        return "TaskID: " + taskId + ", TaskName: " + taskName + ", Status: " + status;
    }
}
