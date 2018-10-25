package bcs.mamun.com.days.Model;


public class daysItem {
    private int id;
    private String data;
    private String date;
    private boolean priority;

    public daysItem(int id, String date, String data) {
        this.id = id;
        this.data = data;
        this.date = date;
        this.priority = true;
    }

    public boolean isPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
