package todolist;

public class Task implements Comparable<Task> {
    private int id;
    private int priority;
    private int sequenceNumber;

    public Task(int id) {
        this.id = id;
        this.priority = 0;
        this.sequenceNumber = 0;
    }

    public int getId() {
        return id;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public void increasePriority() {
        priority++;
    }

    public void decreasePriority() {
        priority--;
    }

    public String toString() {
        return "TASK ID: " + id;
    }

    public int getPriority() {
    	return priority;
    }
    
    @Override
    public int compareTo(Task other) {    	
        if (priority != other.priority) {
            return Integer.compare(priority, other.priority);
        } else {
            return Integer.compare(sequenceNumber, other.sequenceNumber);
        }
    }
}
