package Model;
import java.util.Date;





public class Task {
    private int taskID;
    private String description;
    private Date dueDate;
    private boolean status;

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int id) {
        this.taskID = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date date) {
        this.dueDate = date;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}



