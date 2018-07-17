package hello.bean;

import java.io.Serializable;

/**
 * Created by ASUS on 2018/7/15.
 */
public class Student implements Serializable {
    private String username;

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                '}';
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
