package bcs.mamun.com.days.Model;

/**
 * Created by Mamun on 5/19/2018.
 */

public class eItem {
    String writer;
    String writes;

    public eItem(String writer, String writes) {
        this.writer = writer;
        this.writes = writes;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getWrites() {
        return writes;
    }

    public void setWrites(String writes) {
        this.writes = writes;
    }
}
